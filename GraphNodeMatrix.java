package graphs;

public class GraphNodeMatrix {
    private String name;
    private int index;
    private boolean visited;
    private GraphNodeMatrix parent;

    public GraphNodeMatrix(String name, int index){
        this.name = name;
        this.index = index;
        this.visited = false;
        this.parent = null;
    }

    public GraphNodeMatrix getParent() {
        return parent;
    }

    public void setParent(GraphNodeMatrix parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
