package Tests;

import dataStructure.DGraph;
import dataStructure.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Point3D;

import static org.junit.jupiter.api.Assertions.*;

class DGraphTest {
    private Node n1;
    private Node n2;
    private Node n3;
    private Node n4;


    @BeforeEach
    void setup(){
        Point3D rand = new Point3D(1, 1);
        Point3D rand1 = new Point3D(2, 2);
        Point3D rand2 = new Point3D(3, 3);
        Point3D rand3 = new Point3D(4,4 );
        Node n1 = new Node(rand);
        Node n2 = new Node(rand1);
        Node n3= new Node(rand2);
        Node n4 = new Node(rand3);

    }


    @Test
    void getNode() {
    }

    @Test
    void getEdge() {
    }

    @Test
    void addNode() {
        DGraph graph = new DGraph();
        graph.addNode(n1);;
        graph.addNode(n2);;
        graph.addNode(n3);;
        graph.addNode(n4);;
        assertTrue(true);
    }

    @Test
    void connect() {
    }

    @Test
    void getV() {
    }

    @Test
    void getE() {
    }

    @Test
    void removeNode() {
    }

    @Test
    void removeEdge() {
    }

    @Test
    void nodeSize() {
    }

    @Test
    void edgeSize() {
    }

    @Test
    void getMC() {
    }
}