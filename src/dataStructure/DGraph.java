package dataStructure;

import java.util.*;

public class DGraph implements graph{

	private int _id = 0;

	HashMap<Integer,node_data> NodeMap = new HashMap<>();
	HashMap<Integer,HashMap<Integer,edge_data>> EdgeMap = new HashMap<>();
	HashMap<Integer, LinkedList<Integer>> Connected = new HashMap<>();

	@Override
	public node_data getNode(int key) {
		return NodeMap.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		try {
			return EdgeMap.get(src).get(dest);
		}
		catch(Exception e){
			return null;
		}



	}

	@Override
	public void addNode(node_data n) {
		Node _node = new Node(_id,n);
		NodeMap.put(_id++, _node);
		
	}

	@Override
	public void connect(int src, int dest, double w) {
		if(Connected.get(src)==null){
			Connected.put(src, new LinkedList<>());
		}
		if(Connected.get(dest)==null){
			Connected.put(dest, new LinkedList<>());
		}
		if(EdgeMap.get(src)==null){
			EdgeMap.put(src, new HashMap<>());
		}
		Edge x = new Edge(src,dest,w);
		Connected.get(src).add(dest);
		Connected.get(dest).add(src);
		EdgeMap.get(src).put(dest, x);
	}

	@Override
	public Collection<node_data> getV() {


		return NodeMap.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {

		return EdgeMap.get(node_id).values();
	}

	@Override
	public node_data removeNode(int key) {
		Connected.get(2);
		Iterator<Integer> Ite = Connected.get(key).iterator();
		while (Ite.hasNext()){
			int next = Ite.next();
			if(removeEdge(key, next)==null){
				removeEdge(next,key);
			}


		}
		return NodeMap.remove(key);






	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		Connected.get(src).remove(dest);
		edge_data tmp = EdgeMap.get(src).remove(dest);

		return tmp;
	}


	@Override
	public int nodeSize() {

		return NodeMap.size();
	}

	@Override
	public int edgeSize() {

		return EdgeMap.size();
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}
