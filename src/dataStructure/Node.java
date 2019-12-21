package dataStructure;

import utils.Point3D;

import java.util.Iterator;
import java.util.LinkedList;

public class Node implements node_data {
    private int key;
    private Point3D loc;
    private double weight;
    private int tag;
    private String info;


    public Node(int _id ,node_data n){
        this.key=_id;
        this.loc=n.getLocation();
        this.weight=n.getWeight();
        this.tag=n.getTag();
        this.info=n.getInfo();

    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public Point3D getLocation() {
        return this.loc;
    }

    @Override
    public void setLocation(Point3D p) {
        this.loc = p;

    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight=w;

    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;

    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag=t;

    }



}
