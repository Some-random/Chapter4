/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem2 {
    public static class Graph {
        private Node vertices[];
        public int count;
        public Graph() {
            vertices = new Node[6];
            count = 0;
        }

        public void addNode(Node x) {
            if (count < 30) {
                vertices[count] = x;
                count++;
            } else {
                System.out.print("Graph full");
            }
        }

        public Node[] getNodes() {
            return vertices;
        }
    }

    static class Node {
        private Node adjacent[];
        public int adjacentCount;
        private String vertex;
        public Problem2.State state;
        public Node(String vertex, int adjacentLength) {
            this.vertex = vertex;
            adjacentCount = 0;
            adjacent = new Node[adjacentLength];
        }

        public void addAdjacent(Node x) {
            if (adjacentCount < 30) {
                this.adjacent[adjacentCount] = x;
                adjacentCount++;
            } else {
                System.out.print("No more adjacent can be added");
            }
        }
        public Node[] getAdjacent() {
            return adjacent;
        }
        public String getVertex() {
            return vertex;
        }
    }

    public enum State {
        Unvisited, Visited, Visiting;
    }

    public static Graph createNewGraph()
    {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    public static boolean search(Graph g, Node start, Node end) {
        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        if(start == null) {
            return false;
        }
        if (start == end) {
            return true;
        } else {
            for (Node i : start.getAdjacent()) {
                if (i.state == State.Visited) {
                    continue;
                } else {
                    if (i == end) {
                        return true;
                    } else {
                        i.state = State.Visited;
                        for(Node j : i.getAdjacent()) {
                            if(search(g, j, end)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //Notice the implementation of Graph and Node here. Also the use of state
    public static void main(String[] args) {
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5];
        System.out.println(search(g, start, end));
    }
}
