package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphList {
    private ArrayList<GraphNodeList> nodeList;

    public GraphList(ArrayList<GraphNodeList> nodeList){
        this.nodeList = nodeList;
    }

    public void printList(){
        for(GraphNodeList g : nodeList){
            System.out.println("Name : " + g.getName()  + " and neighbours : " + g.getNeighbours().toString());
        }
    }

    @Override
    public String toString() {
        return "GraphList{" +
                "nodeList=" + nodeList+
                '}';
    }

    private void printPath(GraphNodeList node){
        if(node.getParent() != null){
            printPath(node.getParent());
        }
        System.out.println(node.getName() + " ");
    }

    public void bfsShortestPath(GraphNodeList node){
        Queue<GraphNodeList> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            GraphNodeList currentNode = queue.remove();
            currentNode.setVisited(true);
            System.out.println("Printing path for node " + currentNode.getName() + ":");
            printPath(currentNode);

            for(GraphNodeList neighbour : currentNode.getNeighbours()){
                if(!neighbour.isVisited()){
                    neighbour.setVisited(true);
                    queue.add(neighbour);

                    neighbour.setParent(currentNode);
                }
            }
        }
    }


    private void bfs(GraphNodeList node){
        Queue<GraphNodeList> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            GraphNodeList currentNode = queue.remove();
            currentNode.setVisited(true);
            System.out.print(currentNode.getName() + " ");

            for(GraphNodeList neighbour : currentNode.getNeighbours()){
                if(!neighbour.isVisited()){
                    queue.add(neighbour);
                    neighbour.setVisited(true);
                }
            }
        }
    }

    public void actualBfs(){
        for(GraphNodeList node : nodeList){
            if(!node.isVisited()){
                bfs(node);
            }
        }
    }



    private void dfs(GraphNodeList node){
        Stack<GraphNodeList> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            GraphNodeList currentNode = stack.pop();
            currentNode.setVisited(true);
            System.out.print(currentNode.getName() + " ");

            for(GraphNodeList neighbour : currentNode.getNeighbours()){
                if(!neighbour.isVisited()){
                    stack.push(neighbour);
                    neighbour.setVisited(true);
                }
            }
        }
    }


    public void actualDfs(){
        for(GraphNodeList node : nodeList){
            if(!node.isVisited()){
                dfs(node);
            }
        }
    }

    public boolean isPath(GraphNodeList node1,GraphNodeList node2){
        Queue<GraphNodeList> queue = new LinkedList<>();
        queue.add(node1);

        while(!queue.isEmpty()){
            GraphNodeList currentNode = queue.remove();
            currentNode.setVisited(true);

            for(GraphNodeList neighbour : currentNode.getNeighbours()){
                if(!neighbour.isVisited()){
                    if(neighbour.equals(node2)){
                        return true;
                    } else {
                        neighbour.setVisited(true);
                        queue.add(neighbour);
                    }
                }
            }
        }

        return false;
    }

    private void topologicalSort(GraphNodeList node,Stack<GraphNodeList> stack){

        for(GraphNodeList neighbour : node.getNeighbours()){
            if(!neighbour.isVisited()){
                topologicalSort(neighbour,stack);
            }
        }

        node.setVisited(true);
        stack.add(node);
    }

    public void actualTopologicalSort(){
        Stack<GraphNodeList> stack = new Stack<>();

        for(GraphNodeList node : nodeList){
            if(!node.isVisited()){
                topologicalSort(node,stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop().getName() + " ");
        }
    }

    public void addDirectedEdge(int index1,int index2){
        GraphNodeList node1 = nodeList.get(index1);
        GraphNodeList node2 = nodeList.get(index2);

        node1.getNeighbours().add(node2);
    }

    public void addUndirectedEdge(int index1, int index2){
        GraphNodeList node1 = nodeList.get(index1);
        GraphNodeList node2 = nodeList.get(index2);

        node1.getNeighbours().add(node2);
        node2.getNeighbours().add(node1);
    }

    public ArrayList<GraphNodeList> getNodeList() {
        return nodeList;
    }

    public void setNodeList(ArrayList<GraphNodeList> nodeList) {
        this.nodeList = nodeList;
    }
}
