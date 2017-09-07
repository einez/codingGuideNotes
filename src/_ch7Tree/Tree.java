package _ch7Tree;


public class Tree {
    static class SCTNode {
        int data;
        SCTNode sibling;
        SCTNode child;

        public SCTNode(int data) {
            this.data = data;
            this.sibling = null;
            this.child = null;
        }
    }

    static class ThreadBTNode {
        int data;
        int ltag;
        int rtag;
        ThreadBTNode lChild;
        ThreadBTNode rChild;

        public ThreadBTNode(int data) {
            this.data = data;
            this.ltag = 0;
            this.rtag = 0;
            this.lChild = null;
            this.rChild = null;
        }
    }

    static class BTNode {
        int data;
        BTNode lChild;
        BTNode rChild;

        public BTNode(int data) {
            this.data = data;
            this.lChild = null;
            this.rChild = null;
        }

        public static BTNode createBTNode(String str) {//用括号表示法构建
            return createBTNodeBottomUp(str, new int[]{0});
//            return createBTNodeTopDown(str, 0, str.length());
        }

        private static BTNode createBTNodeBottomUp(String str, int[] p) {
            if (p[0] >= str.length())
                return null;
            BTNode root = null;
            if (p[0] < str.length() && Character.isDigit(str.charAt(p[0]))) {
                int value = 0;
                while (p[0] < str.length() && Character.isDigit(str.charAt(p[0]))) {
                    value = value * 10 + -'0' + str.charAt(p[0]);
                    p[0]++;
                }
                root = new BTNode(value);
            }
            if (p[0] >= str.length() || str.charAt(p[0]) == ',' || str.charAt(p[0]) == ')') {
                p[0]++;
                return root;
            } else { //eg.(str.charAt(p[0]) == '(')
                p[0]++;
                root.lChild = createBTNodeBottomUp(str, p);
                root.rChild = createBTNodeBottomUp(str, p);
                p[0]++;
                return root;
            }
        }

        private static BTNode createBTNodeTopDown(String str, int start, int end) {
            if (end <= start)
                return null;
            BTNode root = null;
            if (start < str.length() && Character.isDigit(str.charAt(start))) {
                int value = 0;
                while (start < str.length() && Character.isDigit(str.charAt(start))) {
                    value = value * 10 - '0' + str.charAt(start);
                    start++;
                }
                root = new BTNode(value);
            }

            if (end <= start) {
                return root;
            } else {
                int lb = 0, i = start;
                while (i < end) {
                    if (str.charAt(i) == '(')
                        lb++;
                    else if (str.charAt(i) == ')')
                        lb--;
                    else if (str.charAt(i) == ',' && lb == 1)
                        break;
                    i++;
                }
                root.lChild = createBTNodeTopDown(str, start + 1, i);
                root.rChild = createBTNodeTopDown(str, i + 1, end - 1);
                return root;
            }
        }

        public static BTNode createBTNodeWithPreIn(String pre, String in) {
            if (pre.length() != in.length() || pre.length() < 1)
                return null;
            return createBTNodeWithPreIn(pre.toCharArray(), in.toCharArray(), 0, pre.length() - 1, 0, in.length() - 1);
        }

        private static BTNode createBTNodeWithPreIn(char[] pre, char[] in, int start1, int end1, int start2, int end2) {
            if (end1 < start1 || end2 - start2 != end1 - start1)
                return null;
            int index = start1 + 1;
            int value = 0;
            while (index <= end1 && Character.isDigit(pre[index])) {
                value = value * 10 - '0' + pre[index];
                index++;
            }
            BTNode root = new BTNode(value);
            if (index > end1)
                return root;
            int i = start2, j = start1;
            while (j < index) {
                if (in[i] != pre[j] || (i + index - j) <= end2 && in[i + index - j] != '#') {
                    i = i - (j - start1) + 1;
                    j = start1;
                } else {
                    i++;
                    j++;
                }
            }
            root.lChild = createBTNodeWithPreIn(pre, in, index, i - start2 + start1 - 1, start2, i - (index - start1) - 1);
            root.rChild = createBTNodeWithPreIn(pre, in, end1 - (end2 - i), end1, i, end2);
            return root;
        }

        public static BTNode createBTNodeWithPostIn(String post, String in) {
            return createBTNodeWithPostIn(post.toCharArray(), in.toCharArray(), 0, post.length() - 1, 0, in.length() - 1);
        }

        private static BTNode createBTNodeWithPostIn(char[] post, char[] in, int start1, int end1, int start2, int end2) {
            if (end1 <= start1 || end1 - start1 != end2 - start2)
                return null;
            int value = 0, weight = 1;
            int index = end1;
            while (index >= start1 && Character.isDigit(post[index])) {
                value += weight * (post[index] - '0');
                weight *= 10;
                index--;
            }
            BTNode root = new BTNode(value);
            if (index == start1)
                return root;
            int i = start2, j = index;
            while (j <= end1) {
                if (in[i] != post[j] || (i + end1 - j + 1) <= end2 && in[i + end1 - j + 1] != '#') {
                    i = i - (j - index) + 1;
                    j = index;
                } else {
                    i++;
                    j++;
                }
            }
            index--;
            root.lChild = createBTNodeWithPostIn(post, in, start1, index - end2 + i - 1, start2, i - 1 - end1 + index);
            root.rChild = createBTNodeWithPostIn(post, in, index - end2 + i, index, i, end2);
            return root;
        }

        public static BTNode findNode(BTNode root, int value) {
            if (root == null || root.data == value)
                return root;
            BTNode find = findNode(root.lChild, value);
            return find == null ? findNode(root.rChild, value) : find;
        }

        public static int getHeight(BTNode root) {
            if (root == null)
                return 0;
            int max = getHeight(root.lChild);
            max = Math.max(max, getHeight(root.rChild));
            return 1 + max;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.data);
            if (this.lChild != null || this.rChild != null) {
                sb.append('(');
                if (this.lChild != null)
                    sb.append(this.lChild.toString());
                sb.append(',');
                if (this.rChild != null)
                    sb.append(this.rChild.toString());
                sb.append(')');
            }
            return sb.toString();
        }
    }
}
