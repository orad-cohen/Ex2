package dataStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class DGraph implements graph{

	private int _id = 0;

	HashMap<Integer,node_data> NodeMap;
	HashMap<Integer,HashMap<Integer,edge_data>> EdgeMap;


	@Override
	public node_data getNode(int key) {
		return NodeMap.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		String key = src+":"+dest;
		return EdgeMap.get(key);
	}

	@Override
	public void addNode(node_data n) {
		Node _node = new Node(_id,n);
		NodeMap.put(_id++, _node);
		
	}

	@Override
	public void connect(int src, int dest, double w) {
		String key = src+":"+dest;

		
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
		Node n = (Node)NodeMap.get(key);

	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		String key = src+":"+dest;

		return removeEdge(key);
	}
	public edge_data removeEdge(String key){

		return EdgeMap.remove(key);
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
