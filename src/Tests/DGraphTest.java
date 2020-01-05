package Tests;

import dataStructure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Point3D;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DGraphTest {
    private Node n1;
    private Node n2;
    private Node n3;
    private Node n4;


    @BeforeEach
    public void setup(){
        Point3D rand = new Point3D(1, 1);
        Point3D rand1 = new Point3D(2, 2);
        Point3D rand2 = new Point3D(3, 3);
        Point3D rand3 = new Point3D(4,4 );
        n1 = new Node(rand);
        n2 = new Node(rand1);
        n3= new Node(rand2);
        n4 = new Node(rand3);

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
        graph.addNode(n4);
        node_data n =  graph.getNode(0);
        System.out.println(graph.getNode(0).getTag());
        n.setTag(32);
        System.out.println(graph.getNode(0).getTag());
        assertTrue(true);
    }

    @Test
    void connect() {
        DGraph graph = new DGraph();
        graph.addNode(n1);;
        graph.addNode(n2);;
        graph.addNode(n3);;
        graph.addNode(n4);;
        graph.connect(n1.getKey(), n2.getKey(), 0);
        graph.connect(n2.getKey(), n3.getKey(), 0);
        graph.connect(n3.getKey(), n4.getKey(), 0);
        graph.connect(n4.getKey(), n1.getKey(), 0);
        assertTrue(true);

    }

    @Test
    void getV() {
        DGraph graph = new DGraph();
        graph.addNode(n1);;
        graph.addNode(n2);;
        graph.addNode(n3);;
        graph.addNode(n4);;
        graph.connect(n1.getKey(), n2.getKey(), 0);
        graph.connect(n2.getKey(), n3.getKey(), 0);
        graph.connect(n3.getKey(), n4.getKey(), 0);
        graph.connect(n4.getKey(), n1.getKey(), 0);

        Collection<node_data> col = graph.getV();

        Iterator ite = col.iterator();
        while(ite.hasNext()){
            Node n = (Node)ite.next();
            Point3D loc = n.getLocation();
            System.out.println(loc);

        }





    }

    @Test
    void getE() {
        DGraph graph = new DGraph();
        graph.addNode(n1);;
        graph.addNode(n2);;
        graph.addNode(n3);;
        graph.addNode(n4);;
        graph.connect(0, 1, 0);
        graph.connect(1, 2, 0);
        graph.connect(2, 3, 0);
        graph.connect(3, 0, 0);
        Collection<edge_data> n1edge = graph.getE(0);

        Iterator<edge_data> ite1 = n1edge.iterator();

        while(ite1.hasNext()){
            Edge e1 = (Edge)ite1.next();
            System.out.println(e1.getSrc()+" to "+e1.getDest());
            n1edge = graph.getE(e1.getDest());
            ite1 = n1edge.iterator();



        }



    }

    @Test
    void removeNode() {
        DGraph graph = new DGraph();
        graph.addNode(n1);;
        graph.addNode(n2);;
        graph.addNode(n3);;
        graph.addNode(n4);;
        graph.connect(0, 1, 0);
        graph.connect(0, 2, 0);
        graph.connect(3, 0, 0);
        graph.connect(2, 3, 0);

        graph.removeNode(2);
        Collection<edge_data> n1edge = graph.getE(0);
        Collection<edge_data> n4edge = graph.getE(3);
        Iterator<edge_data> ite1 = n1edge.iterator();
        Iterator<edge_data> ite4 = n4edge.iterator();
        while(ite1.hasNext()){
            Edge e1 = (Edge)ite1.next();
            System.out.println(e1.getSrc()+" to "+e1.getDest());
        }
        while(ite4.hasNext()){
            Edge e4 =(Edge)ite4.next();
            System.out.println(e4.getSrc()+" to "+e4.getDest());

        }
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