package graphs;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<GraphNodeMatrix> graphNodeMatirx = new ArrayList<>();
        graphNodeMatirx.add(new GraphNodeMatrix("A",0));
        graphNodeMatirx.add(new GraphNodeMatrix("B",1));
        graphNodeMatirx.add(new GraphNodeMatrix("C",2));
        graphNodeMatirx.add(new GraphNodeMatrix("D",3));
        graphNodeMatirx.add(new GraphNodeMatrix("E",4));
        graphNodeMatirx.add(new GraphNodeMatrix("F",5));
        graphNodeMatirx.add(new GraphNodeMatrix("G",6));
        graphNodeMatirx.add(new GraphNodeMatrix("H",7));


        GraphMatrix graphMatrix = new GraphMatrix(graphNodeMatirx);

        graphMatrix.addUndirectedEdge(0,3);
        graphMatrix.addUndirectedEdge(1,5);
        graphMatrix.addUndirectedEdge(5,7);
        graphMatrix.riverSizes();

        /*graphList.addUndirectedEdge(0,1);
        graphList.addUndirectedEdge(0,6);
        graphList.addUndirectedEdge(6,7);
        graphList.addUndirectedEdge(6,4);
        graphList.addUndirectedEdge(7,5);
        graphList.addUndirectedEdge(7,1);
        graphList.addUndirectedEdge(4,5);
        graphList.addUndirectedEdge(4,2);
        graphList.addUndirectedEdge(0,2);
        graphList.addUndirectedEdge(2,3);
        graphList.addUndirectedEdge(3,5);


        graphList.actualBfs(); */

        //System.out.println(graphList.isPath(graphNodeMatirx.get(4),graphNodeMatirx.get(2)));



       /* ArrayList<WeightedNode> nodeList = new ArrayList<>();
        WeightedNode node1 = new WeightedNode("A",0);
        WeightedNode node2 = new WeightedNode("B",1);
        WeightedNode node3 = new WeightedNode("C",2);
        WeightedNode node4 = new WeightedNode("D",3);
        WeightedNode node5 = new WeightedNode("E",4);

        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);

        nodeList.add(node5);

        KruskalAlgorithm kruskalAlgorithmGraph = new KruskalAlgorithm(nodeList);

        PrimAlgorithm primAlgorithmGraph = new PrimAlgorithm(nodeList);

        primAlgorithmGraph.addWeightedUndirectedEdge(0,1,5);
        primAlgorithmGraph.addWeightedUndirectedEdge(1,2,10);
        primAlgorithmGraph.addWeightedUndirectedEdge(1,3,8);
        primAlgorithmGraph.addWeightedUndirectedEdge(3,2,6);

        primAlgorithmGraph.addWeightedUndirectedEdge(2,0,13);
        primAlgorithmGraph.addWeightedUndirectedEdge(2,4,20);
        primAlgorithmGraph.addWeightedUndirectedEdge(4,0,15);


        kruskalAlgorithmGraph.addWeightedUndirectedEdge(0,1,5);
        kruskalAlgorithmGraph.addWeightedUndirectedEdge(1,2,10);
        kruskalAlgorithmGraph.addWeightedUndirectedEdge(1,3,8);
        kruskalAlgorithmGraph.addWeightedUndirectedEdge(3,2,6);

        kruskalAlgorithmGraph.addWeightedUndirectedEdge(2,0,13);
        kruskalAlgorithmGraph.addWeightedUndirectedEdge(2,4,20);
        kruskalAlgorithmGraph.addWeightedUndirectedEdge(4,0,15);

       primAlgorithmGraph.primAlgorithm(nodeList.get(0));*/




    }
}
