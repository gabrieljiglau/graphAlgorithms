package graphs;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphMatrix {
    private ArrayList<GraphNodeMatrix> nodeList;
    private int[][] adjacencyMatrix;

    public GraphMatrix(ArrayList<GraphNodeMatrix> nodeList){
        this.nodeList = nodeList;
        this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append(" ");

      for(int i = 0; i < nodeList.size(); i++){
          sb.append(nodeList.get(i).getName() + " ");
      }
      sb.append("\n");

      for(int i = 0; i < nodeList.size(); i++){
          sb.append(nodeList.get(i).getName() + ":");

          for(int j : adjacencyMatrix[i]){
              sb.append( (j) + " ");
          }
          sb.append("\n");
      }
      return sb.toString();
    }

     private ArrayList<GraphNodeMatrix> getNeighbours(GraphNodeMatrix node){
        ArrayList<GraphNodeMatrix> neighbours = new ArrayList<>();
        int index = node.getIndex();

        for(int i = 0; i < adjacencyMatrix.length; i++){
            if(adjacencyMatrix[index][i] == 1){
                neighbours.add(nodeList.get(i));
            }
        }
        return neighbours;
     }

     private int[] modifiedBfs(GraphNodeMatrix node) {
         int[] array = new int[9];
         int index = 0;

         Queue<GraphNodeMatrix> queue = new LinkedList<>();
         queue.add(node);

         while (!queue.isEmpty()) {
             GraphNodeMatrix current = queue.remove();
             current.setVisited(true);
             if (current.getIndex() == 1) {

                 ArrayList<GraphNodeMatrix> neighbours = getNeighbours(current);

                 int size = 1;

                 for (GraphNodeMatrix neighbour : neighbours) {
                     if (!neighbour.isVisited()) {
                         queue.add(neighbour);
                         neighbour.setVisited(true);
                         if (neighbour.getIndex() == 1) {
                             size++;
                         } else {
                             continue;
                         }
                     }
                 }

                 array[index] = size;
                 index++;
             }
         }

         return array;
     }


     public void riverSizes(){
        for(GraphNodeMatrix node : nodeList){
            if(!node.isVisited()){
                modifiedBfs(node);
            }
        }
     }


     private void bfs(GraphNodeMatrix node){
        Queue<GraphNodeMatrix> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            GraphNodeMatrix currentNode = queue.remove();
            currentNode.setVisited(true);

            ArrayList<GraphNodeMatrix> neighbours = getNeighbours(currentNode);

            for(GraphNodeMatrix neighbour : neighbours){
                if(!neighbour.isVisited()){
                    queue.add(neighbour);
                    neighbour.setVisited(true);
                }
            }
        }
    }

    public void actualBfs(){
        for(GraphNodeMatrix node : nodeList){
            if(!node.isVisited()){
                bfs(node);
            }
        }
    }

    public void addDirectedEdge(int index1,int index2){
        if(index1 < nodeList.size() && index2 < nodeList.size()){
            adjacencyMatrix[index1][index2] = 1;
        }
    }

    private void topologicalSort(GraphNodeMatrix node,Stack<GraphNodeMatrix> stack){
        ArrayList<GraphNodeMatrix> neighbours = getNeighbours(node);

        for(GraphNodeMatrix neighbour : neighbours){
            if(!neighbour.isVisited()){
                topologicalSort(neighbour,stack);
            }
        }

        node.setVisited(true);
        stack.push(node);
    }

    public void printPath(GraphNodeMatrix node){
        if (node.getParent() != null){
            printPath(node.getParent());
        }
        System.out.print(node.getName() + " ");
    }

    public void bfsShortestPath(GraphNodeMatrix node){
        Queue<GraphNodeMatrix> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            GraphNodeMatrix currentNode = queue.remove();
            currentNode.setVisited(true);
            printPath(node);

            ArrayList<GraphNodeMatrix> neighbours = getNeighbours(currentNode);

            for(GraphNodeMatrix neighbour : neighbours){
                if(!neighbour.isVisited()){
                    neighbour.setVisited(true);
                    queue.add(neighbour);

                    neighbour.setParent(currentNode);
                }
            }
        }
    }

    public void actualTopologicalSort(){
        Stack<GraphNodeMatrix> stack = new Stack<>();

        for(GraphNodeMatrix node : nodeList){
            if(!node.isVisited()){
                topologicalSort(node,stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop().getName() + " ");
        }
   }

    private void dfs(GraphNodeMatrix node){
        Stack<GraphNodeMatrix> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            GraphNodeMatrix currentNode = stack.pop();
            currentNode.setVisited(true);
            System.out.print(currentNode.getName() + " ");

            ArrayList<GraphNodeMatrix> neighbours = getNeighbours(node);

            for(GraphNodeMatrix neighbour : neighbours){
                if(!neighbour.isVisited()){
                    stack.push(neighbour);
                    neighbour.setVisited(true);
                }
            }
        }
    }

    public void actualDfs(){
        for(GraphNodeMatrix node : nodeList){
            if(!node.isVisited()){
                dfs(node);
            }
        }
    }

    public void printTwoDimensionalArray(){
        for(int i = 0; i < adjacencyMatrix.length; i++){
            for(int j = 0; j < adjacencyMatrix.length; j++){
                System.out.print(adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public void addUndirectedEdge(int index1,int index2){
        if(index1 < nodeList.size() && index2 < nodeList.size()){
            adjacencyMatrix[index1][index2] = 1;
            adjacencyMatrix[index2][index1] = 1;
        }
    }

    public ArrayList<GraphNodeMatrix> getNodeList() {
        return nodeList;
    }

    public void setNodeList(ArrayList<GraphNodeMatrix> nodeList) {
        this.nodeList = nodeList;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
}
