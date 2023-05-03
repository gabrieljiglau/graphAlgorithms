package graphs;

import java.util.ArrayList;

public class DisjointSet {
    private ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public ArrayList<WeightedNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public static void makeSet(ArrayList<WeightedNode> nodeList){
        for(WeightedNode node : nodeList){
            DisjointSet disjointSet = new DisjointSet();
            disjointSet.getNodeList().add(node);
            node.setDisjointSet(disjointSet);
        }
    }

    public static DisjointSet findSet(WeightedNode node){
        return node.getDisjointSet();
    }

    public static DisjointSet unionSet(WeightedNode node1,WeightedNode node2){
        if(node1.getDisjointSet() == node2.getDisjointSet()){
            return null;
        }

       DisjointSet set1 = node1.getDisjointSet();
       DisjointSet set2 = node2.getDisjointSet();

       if(set1.getNodeList().size() > set2.getNodeList().size()){
           ArrayList<WeightedNode> nodeSet2 = set2.getNodeList();
           for(WeightedNode node : nodeSet2){
               node.setDisjointSet(set1);
               set1.getNodeList().add(node);
           }
           return set1;
       } else {
           ArrayList<WeightedNode> nodeSet1 = set1.getNodeList();
           for(WeightedNode node : nodeSet1){
               node.setDisjointSet(set2);
               set2.getNodeList().add(node);
           }

           return set2;
       }
    }


    public void printSet(){
        for(WeightedNode node : this.nodeList){
            System.out.println(node + " ");
        }
        System.out.println();
    }

}








