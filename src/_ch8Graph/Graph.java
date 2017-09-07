package _ch8Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Graph {
    public static class MGraph {
        int n;
        int e;
        int[][] edges;

        public MGraph(int n) {
            this.n = n;
            this.e = 0;
            this.edges = new int[n][n];
        }

        public MGraph(int n, int[][] edges) {
            this.n = n;
            this.edges = Arrays.copyOf(edges, edges.length);
            this.e = 0;
            for (int i = 0; i < this.edges.length; i++) {
                for (int j = 0; j < this.edges[0].length; j++) {
                    if (this.edges[i][j] != 0)
                        this.e++;
                }
            }
            this.e /= 2;
        }

        public MGraph(MGraph mg) {
            this.n = mg.n;
            this.e = mg.e;
            this.edges = Arrays.copyOf(mg.edges, mg.edges.length);
        }

        public MGraph(ALGraph alg) {
            this.n = alg.n;
            this.e = alg.e;
            this.edges = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (ALGraph.GNode v : alg.vertex[i].neibs) {
                    this.edges[i][v.data] = 1;
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i = 0; i < n; i++) {
                sb.append("-*-");
            }
            sb.append("\nn = " + this.n + ", e = " + this.e);
            for (int i = 0; i < n; i++) {
                sb.append("\n");
                sb.append(Arrays.toString(this.edges[i]));
            }
            sb.append("\n");
            for (int i = 0; i < n; i++) {
                sb.append("-*-");
            }
            sb.append("\n");
            return sb.toString();
        }
    }


    public static class ALGraph {
        public static class GNode {
            int data;
            List<GNode> neibs;

            public GNode(int data) {
                this.data = data;
                this.neibs = new LinkedList<>();
            }
        }

        int n;
        int e;
        GNode[] vertex;

        public ALGraph(int n) {
            this(n, 0);
        }

        private ALGraph(int n, int e) {
            this.n = n;
            this.e = e;
            this.vertex = new GNode[n];
            for (int i = 0; i < n; i++) {
                this.vertex[i] = new GNode(i);
            }
        }

        public ALGraph(ALGraph origin) {
            this.n = origin.n;
            this.e = origin.e;
            this.vertex = Arrays.copyOf(origin.vertex, origin.vertex.length);
        }

        public ALGraph(MGraph mg) {
            this(mg.n, mg.e);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mg.edges[i][j] != 0) {
                        this.vertex[i].neibs.add(this.vertex[j]);
                    }
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i = 0; i < n; i++) {
                sb.append("-*-");
            }
            sb.append("\nn = " + this.n + ", e = " + this.e);
            for (int i = 0; i < n; i++) {
                sb.append("\n");
                sb.append(this.vertex[i].data + ": ");
                for (GNode n : this.vertex[i].neibs)
                    sb.append(" " + n.data);
            }
            sb.append("\n");
            for (int i = 0; i < n; i++) {
                sb.append("-*-");
            }
            sb.append("\n");
            return sb.toString();
        }
    }

    public static MGraph createUndirectedMGraph() {
        Random random = new Random();
        int n = random.nextInt(10) + 1;
        MGraph mg = new MGraph(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (random.nextInt(2) == 1) {
                    mg.edges[i][j] = 1;
                    mg.edges[j][i] = mg.edges[i][j];
                    mg.e++;
                }
            }
        }
        return mg;
    }

    public static MGraph createDirectedMGraph() {
        Random random = new Random();
        int n = random.nextInt(10) + 1;
        MGraph mg = new MGraph(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i && random.nextInt(2) == 1) {
                    mg.edges[i][j] = 1;
                    mg.e++;
                }
            }
        }
        return mg;
    }

    public static ALGraph createUndirectedALGraph() {
        Random random = new Random();
        int n = random.nextInt(10) + 1;
        ALGraph alg = new ALGraph(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (random.nextInt(2) == 1) {
                    alg.vertex[i].neibs.add(alg.vertex[j]);
                    alg.vertex[j].neibs.add(alg.vertex[i]);
                    alg.e++;
                }
            }
        }
        return alg;
    }

    public static ALGraph createDirectedALGraph() {
        Random random = new Random();
        int n = random.nextInt(10) + 1;
        ALGraph alg = new ALGraph(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i && random.nextInt(2) == 1) {
                    alg.vertex[i].neibs.add(alg.vertex[j]);
                    alg.e++;
                }
            }
        }
        return alg;
    }
}
