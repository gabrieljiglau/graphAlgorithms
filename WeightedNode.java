package graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode>{
    private int index;
    private String name;
    private ArrayList<WeightedNode> neighbours;
    private boolean isVisited;
    private HashMap<WeightedNode,Integer> weightedMap = new HashMap<>();
    private WeightedNode parent;
    private int distance;
    private DisjointSet disjointSet;

    public DisjointSet getDisjointSet() {
        return disjointSet;
    }

    public void setDisjointSet(DisjointSet disjointSet) {
        this.disjointSet = disjointSet;
    }

    public WeightedNode(String name, int index){
        this.name = name;
        this.index = index;
        this.neighbours = new ArrayList<>();
        this.parent = null;
        this.distance = Integer.MAX_VALUE;
        this.isVisited = false;
    }

    @Override
    public String toString(){
        return this.name + " ";
    }



    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<WeightedNode> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<WeightedNode> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public HashMap<WeightedNode, Integer> getWeightedMap() {
        return weightedMap;
    }

    public void setWeightedMap(HashMap<WeightedNode, Integer> weightedMap) {
        this.weightedMap = weightedMap;
    }

    public WeightedNode getParent() {
        return parent;
    }

    public void setParent(WeightedNode parent) {
        this.parent = parent;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(WeightedNode node) {
        if(this.distance < node.getDistance()){
            return -1;
        } else if(this.distance == node.getDistance()){
            return 0;
        } else {
            return 1;
        }
    }
}
