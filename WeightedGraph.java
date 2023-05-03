package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {
    private ArrayList<WeightedNode> nodeList;

    public WeightedGraph(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
    }

    public void addWeightedEdge(int index1,int index2, int weight){
        WeightedNode node1 = nodeList.get(index1);
        WeightedNode node2 = nodeList.get(index2);

        node1.getNeighbours().add(node2);
        node1.getWeightedMap().put(node2,weight);
    }

    public void dijkstraAlgorithm(WeightedNode source){
        PriorityQueue<WeightedNode> priorityQueue = new PriorityQueue<>();
        source.setDistance(0);
        priorityQueue.addAll(nodeList);

        while(!priorityQueue.isEmpty()){
            WeightedNode currentNode = priorityQueue.remove();

            for(WeightedNode neighbour : currentNode.getNeighbours()){
                if(neighbour.getDistance() > currentNode.getDistance() + currentNode.getWeightedMap().get(neighbour)){
                    neighbour.setDistance(currentNode.getDistance() + currentNode.getWeightedMap().get(neighbour));
                    neighbour.setParent(currentNode);

                    priorityQueue.remove(neighbour);
                    priorityQueue.add(neighbour);
                }
            }
        }


        for(WeightedNode node : nodeList){
            System.out.println("Node " + node + "'s distance : " + node.getDistance() + ".Path :");
            printPath(node);
            System.out.println();
        }
    }

    public void floydWarshallAlgorithm(){
        int size = nodeList.size();
        int[][] array = new int[size][size];

        for(int i = 0; i < size; i++){
            WeightedNode first = nodeList.get(i);
            for(int j = 0; j < size; j++){
                WeightedNode second = nodeList.get(j);

                if(i == j){
                    array[i][j] = 0;
                } else if(first.getWeightedMap().containsKey(second)){
                    array[i][j] = first.getWeightedMap().get(second);
                } else {
                    array[i][j] = Integer.MAX_VALUE / 10;
                }
            }
        }

        for(int k = 0; k < size; k++){
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(array[i][j] < array[i][k] + array[k][j]){
                        array[i][j] = array[i][k] + array[k][j];
                    }
                }
            }
        }

        for(int i = 0 ; i < size; i++){
            System.out.println("Distance for node : " + nodeList.get(i).getName());
            for(int j = 0 ; j < size; j++){
                System.out.println(array[i][j] +  " ");
            }
            System.out.println();
        }
    }

    public void bellmanFordAlgorithm(WeightedNode source){
        source.setDistance(0);

        for(int i = 0 ; i < nodeList.size(); i++){
            for(WeightedNode node : nodeList){
                for(WeightedNode neighbour : node.getNeighbours()){
                    if(neighbour.getDistance() > node.getDistance() + node.getWeightedMap().get(neighbour)){
                        neighbour.setDistance(node.getDistance() + node.getWeightedMap().get(neighbour));
                        neighbour.setParent(node);
                    }
                }
            }
        }

        for(WeightedNode node : nodeList){
            for(WeightedNode neighbour : node.getNeighbours()){
                if(neighbour.getDistance() > node.getDistance() + node.getWeightedMap().get(neighbour)){
                    System.out.println("Negative cycle detected at node's " + node.getName() + " neighbours");

                    System.out.println("Old distance " + neighbour.getDistance());
                    System.out.println("New distance " + node.getDistance() + node.getWeightedMap().get(neighbour));
                    return;
                }
            }
        }

        for(WeightedNode node : nodeList){
            System.out.println("Node " + node.getName() + " and its distance : " + node.getDistance() + " .Path : ");
            printPath(node);
            System.out.println();
        }
    }

    public void printPath(WeightedNode node){
        if(node.getParent() != null){
            printPath(node.getParent());
        }

        System.out.print(node.getName() + " ");
    }
}
