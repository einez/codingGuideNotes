package _ch7Tree;

public class Contract {
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

    static class BTNode {
        int data;
        BTNode lChild;
        BTNode rChild;

        public BTNode(int data) {
            this.data = data;
            this.lChild = null;
            this.rChild = null;
        }

        public static BTNode createBTNode(String str) {
            return createBTNodeBottom(str, new int[]{0});
//            return createBTNodeTopDown(str, 0, str.length());
        }

        private static BTNode createBTNodeBottom(String str, int[] p) {
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
                root.lChild = createBTNodeBottom(str, p);
                root.rChild = createBTNodeBottom(str, p);
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
