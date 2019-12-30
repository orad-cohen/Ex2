package Tests;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.Node;
import org.junit.jupiter.api.Test;
import utils.Point3D;

import static org.junit.jupiter.api.Assertions.*;

class Graph_AlgoTest {

    @Test
    void init() {
    }

    @Test
    void testInit() {
    }

    @Test
    void save() {
    }

    @Test
    void isConnected() {
        Point3D rand = new Point3D(1, 1);
        Point3D rand1 = new Point3D(2, 2);
        Point3D rand2 = new Point3D(3, 3);
        Point3D rand3 = new Point3D(4,4 );
        Node n1 = new Node(rand);
        Node n2 = new Node(rand1);
        Node n3= new Node(rand2);
        Node n4 = new Node(rand3);
        DGraph graph = new DGraph();
        graph.addNode(n1);;
        graph.addNode(n2);;
        graph.addNode(n3);;
        graph.addNode(n4);;
        graph.connect(0, 1, 0);
        graph.connect(1, 2, 0);
        graph.connect(2, 3, 0);
        graph.connect(0, 3, 0);
        Graph_Algo algo = new Graph_Algo();
        algo.init(graph);
        assertFalse(algo.isConnected());

    }

    @Test
    void testIsConnected() {
    }

    @Test
    void shortestPathDist() {
    }

    @Test
    void shortestPath() {
    }

    @Test
    void TSP() {
    }

    @Test
    void copy() {
    }
}