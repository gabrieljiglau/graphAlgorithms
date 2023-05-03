package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgorithm {
    private ArrayList<WeightedNode> nodeList;

    public PrimAlgorithm(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
    }

    public void primAlgorithm(WeightedNode source){
        for(WeightedNode node : nodeList){
            node.setDistance(Integer.MAX_VALUE /10);
        }
        source.setDistance(0);
        PriorityQueue<WeightedNode> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(nodeList);

        while(!priorityQueue.isEmpty()){
            WeightedNode currentNode = priorityQueue.remove();
            currentNode.setVisited(true);

            for(WeightedNode neighbour : currentNode.getNeighbours()) {
                if (priorityQueue.contains(neighbour)) {
                   if(neighbour.getDistance() > currentNode.getWeightedMap().get(neighbour)){
                       neighbour.setDistance(currentNode.getWeightedMap().get(neighbour));

                       neighbour.setParent(currentNode);

                       priorityQueue.remove(neighbour);
                       priorityQueue.add(neighbour);
                   }
                }
            }
        }

        int totalCost = 0;

        for(WeightedNode node : nodeList){
            System.out.println("Node " + node + " and his parent " + node.getParent() + ",with the distance of "
                               + node.getDistance());
            totalCost += node.getDistance();
        }

        System.out.println("Total distance of MST " + totalCost);

    }

    public void addWeightedUndirectedEdge(int index1,int index2,int weight){
        WeightedNode node1 = nodeList.get(index1);
        WeightedNode node2 = nodeList.get(index2);

        node1.getNeighbours().add(node2);
        node2.getNeighbours().add(node1);

        node1.getWeightedMap().put(node2,weight);
        node2.getWeightedMap().put(node1,weight);

    }

    public ArrayList<WeightedNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }
}
