package algorithms;

import java.util.Iterator;
import java.util.List;

import dataStructure.*;

/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{

	private graph _graph;


	@Override
	public void init(graph g) {
		this._graph=g;
		
	}

	@Override
	public void init(String file_name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isConnected() {
		Iterator<node_data> SrcIte = _graph.getV().iterator();

		while(SrcIte.hasNext()){
			int count = 0;
			Iterator<node_data> DestIte = _graph.getV().iterator();
			int SrcKey = SrcIte.next().getKey();
			while (DestIte.hasNext()){
				int DestKey = DestIte.next().getKey();
				if(SrcKey==DestKey){
					continue;
				}
				else{
					count+=isConnected(SrcKey,DestKey,0);
				}
			}
			if(count==0){
				return false;
			}

		}


		return true;
	}

	public int isConnected(int src,int dest,int count){
		try{
			Iterator<edge_data> Emap = _graph.getE(src).iterator();
			while(Emap.hasNext()){
				edge_data edge = Emap.next();
				if((edge.getDest()==dest)){
					return 1;
				}
				else{
					count+=isConnected(edge.getDest(),dest,count);
				}

			}

			return count;
		}
		catch (Exception e){
			return  0;
		}


	}

	@Override
	// do this
	public double shortestPathDist(int src, int dest) {
		node_data n = _graph.getNode(src);
		n.setWeight(0);

		

		double answer = 0;

		return answer;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		node_data n = _graph.getNode(src);
		n.setWeight(0);

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return null;
	}

	public void RemoveTags(){
		Iterator<node_data> Nodes = _graph.getV().iterator();
		while(Nodes.hasNext()){
			Nodes.next().setTag(0);
		}

	}
	public void RemoveEdgeTags(int x){
		Iterator<edge_data> Edges = _graph.getE(x).iterator();
		while(Edges.hasNext()){
			Edges.next().setTag(0);
		}

	}


}
