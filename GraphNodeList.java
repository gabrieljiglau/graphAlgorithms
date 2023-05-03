package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphNodeList {
    private String name;
    private int index;
    private ArrayList<GraphNodeList> neighbours;
    private boolean isVisited;
    private GraphNodeList parent;

    public GraphNodeList(String name,int index){
        this.name = name;
        this.index = index;
        this.neighbours = new ArrayList<>();
        this.isVisited = false;
    }

    public GraphNodeList getParent() {
        return parent;
    }

    public void setParent(GraphNodeList parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
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

    public ArrayList<GraphNodeList> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<GraphNodeList> neighbours) {
        this.neighbours = neighbours;
    }
}
