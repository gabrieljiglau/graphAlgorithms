package graphs;

public class UndirectedEdge {
    private WeightedNode firstNode;
    private WeightedNode secondNode;
    private int weight;

    public UndirectedEdge(WeightedNode firstNode,WeightedNode secondNode,int weight){
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge from " + firstNode + " to " + secondNode +
                " with the weight " + getWeight();
    }

    public WeightedNode getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(WeightedNode firstNode) {
        this.firstNode = firstNode;
    }

    public WeightedNode getSecondNode() {
        return secondNode;
    }

    public void setSecondNode(WeightedNode secondNode) {
        this.secondNode = secondNode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
