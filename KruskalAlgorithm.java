package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KruskalAlgorithm {
    private ArrayList<WeightedNode> nodeList;
    private ArrayList<UndirectedEdge> edgeList;

    public KruskalAlgorithm(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
        this.edgeList = new ArrayList<>();
    }

    public void addWeightedUndirectedEdge(int index1,int index2,int weight){
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(index1),nodeList.get(index2),weight);

        WeightedNode node1 = edge.getFirstNode();
        WeightedNode node2 = edge.getSecondNode();

        node1.getNeighbours().add(node2);
        node2.getNeighbours().add(node1);

        node1.getWeightedMap().put(node2,weight);
        node2.getWeightedMap().put(node1,weight);

        edgeList.add(edge);
    }

    public void kruskalAlgorithm(){
        DisjointSet.makeSet(nodeList);
        int totalCost = 0;

        Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
            @Override
            public int compare(UndirectedEdge e1, UndirectedEdge e2) {
                return e1.getWeight() - e2.getWeight();
            }
        };

        Collections.sort(edgeList,comparator);

        for(UndirectedEdge edge : edgeList){
            WeightedNode node1 = edge.getFirstNode();
            WeightedNode node2 = edge.getSecondNode();

            if(!node1.getDisjointSet().equals(node2.getDisjointSet())){
                DisjointSet.unionSet(node1,node2);

                totalCost += edge.getWeight();

                System.out.println("Taken " + edge);
            }
        }

        System.out.println("Total cost is " + totalCost);

    }

    public ArrayList<WeightedNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public ArrayList<UndirectedEdge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(ArrayList<UndirectedEdge> edgeList) {
        this.edgeList = edgeList;
    }
}
