package gui;

import algorithms.graph_algorithms;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;
import utils.Range;
import utils.StdDraw;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

public class DrawGraph {



    public void Draw(graph g){
        Iterator<node_data> nodes = g.getV().iterator();
        LinkedList<Point3D> NodeLocation = new LinkedList<>();
        LinkedList<Integer> NodeKey = new LinkedList<>();
        LinkedList<edge_data> NodeEdges = new LinkedList<>();
        double Max_x=0;
        double Min_x=0;
        double Max_y=0;
        double Min_y=0;
        while(nodes.hasNext()){
            node_data CurNode = nodes.next();
            Point3D loc = CurNode.getLocation();
            NodeLocation.add(loc);
            Max_x = Math.max(Max_x, loc.x());
            Max_y = Math.max(Max_y, loc.y());
            Min_x = Math.min(Min_x, loc.x());
            Min_y = Math.min(Min_y, loc.y());
            NodeKey.add(CurNode.getKey());
            if(g.getE(CurNode.getKey())!=null){
                Iterator<edge_data> EdgeIte = g.getE(CurNode.getKey()).iterator();
                while(EdgeIte.hasNext()){
                    NodeEdges.add(EdgeIte.next());
                }
            }
        }
        Range xx = new Range(Min_x, Max_x);
        Range yy = new Range(Min_y, Max_y);
        StdDraw.setCanvasSize(750, 750);
        StdDraw.setXscale(Min_x-5, Max_x+5);
        StdDraw.setYscale(Min_y-5,Max_y+5);

        StdDraw.setPenRadius(0.01);
        for(int i = 0; i<NodeLocation.size();i++){
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.point(NodeLocation.get(i).x(),NodeLocation.get(i).y());
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.text(NodeLocation.get(i).x(),NodeLocation.get(i).y()+0.2, ""+NodeKey.get(i));
        }

        double nx;
        double ny;

        for(int  i = 0; i<NodeEdges.size();i++){
            StdDraw.setPenColor(Color.red);
            StdDraw.setPenRadius();
            double x0 = g.getNode(NodeEdges.get(i).getSrc()).getLocation().x();
            double x1 = g.getNode(NodeEdges.get(i).getDest()).getLocation().x();
            double y0 = g.getNode(NodeEdges.get(i).getSrc()).getLocation().y();
            double y1 = g.getNode(NodeEdges.get(i).getDest()).getLocation().y();
            StdDraw.line(x0,y0,x1,y1);

            double midx =(x0+x1)/2;
            double midy = (y0+y1)/2;
            if(x0>x1){nx = x0-Math.abs(x0-x1)/10;}
            else{nx = x0+Math.abs(x0-x1)/10;}
            if(y0>midy){ny = y0-Math.abs(y0-y1)/10;}
            else{ny = y0+Math.abs(y0-y1)/10;}
            StdDraw.text(midx,midy,""+NodeEdges.get(i).getWeight());
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(Color.YELLOW);
            StdDraw.point(nx,ny);


        }

        StdDraw.pause(200000);










    }

}
