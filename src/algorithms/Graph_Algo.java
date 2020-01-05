package algorithms;

import dataStructure.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import utils.Point3D;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{

	private graph _graph;


	public Graph_Algo(){

	}
	public Graph_Algo(graph g){
		init(g);
	}


	@Override
	public void init(graph g) {
		this._graph=g;
		
	}

	@Override
	public void init(String file_name) {
		graph g = new DGraph();
		JSONParser parser = new JSONParser();
		try{
			Reader reader = new FileReader(file_name);
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			JSONArray NodeKey = (JSONArray)jsonObject.get("NodeKey");
			JSONArray NodeLoc =  (JSONArray)jsonObject.get("NodeLoc");
			JSONArray NodeWeight =  (JSONArray)jsonObject.get("NodeWeight");
			JSONArray NodeTag = (JSONArray)jsonObject.get("NodeTag");
			JSONArray NodeInfo = (JSONArray)jsonObject.get("NodeInfo");
			JSONArray EdgeSrc =  (JSONArray)jsonObject.get("EdgeSrc");
			JSONArray EdgeDest = (JSONArray)jsonObject.get("EdgeDest");
			JSONArray EdgeWeight = (JSONArray)jsonObject.get("EdgeWeight");
			JSONArray EdgeTag = (JSONArray)jsonObject.get("EdgeTag");
			JSONArray EdgeInfo = (JSONArray)jsonObject.get("EdgeInfo");
			Iterator<Integer> NodeIte= NodeKey.iterator();

			int i = 0;
			double weight;
			int tag;
			int key;
			while (NodeIte.hasNext()){
				NodeIte.next();
				weight = Double.parseDouble(NodeWeight.get(i).toString());
				tag = Integer.parseInt(NodeTag.get(i).toString());
				key = Integer.parseInt(NodeKey.get(i).toString());
				Node N = new Node(key,(String)NodeLoc.get(i),weight,tag,(String)NodeInfo.get(i));
				g.addNode(N);
				i++;
			}
			i=0;
			int src;
			int dest;
			int nextsrc=Integer.parseInt(EdgeSrc.get(i).toString());
			int CurEdge = 0;
			while (i<EdgeSrc.size()){

				src =Integer.parseInt(EdgeSrc.get(i).toString());
				if(nextsrc==src){
					weight = Double.parseDouble(EdgeWeight.get(i).toString());
					dest = Integer.parseInt(EdgeDest.get(i).toString());
					g.connect(src,dest,weight);
					CurEdge++;
					i++;
				}
				else{
					Iterator<edge_data> Ite = g.getE(nextsrc).iterator();
					while(CurEdge>0){
						edge_data Current = Ite.next();
						tag = Integer.parseInt(EdgeTag.get(i-CurEdge).toString());
						Current.setTag(tag);
						Current.setInfo((String)EdgeInfo.get(i-CurEdge));
						CurEdge--;
					}

				}

				nextsrc=src;
			}

			init(g);



		}
		catch (Exception e){
			e.printStackTrace();

		}
		
	}

	@Override
	public void save(String file_name) {
		JSONObject Obj = new JSONObject();
		JSONArray NodeKey = new JSONArray();
		JSONArray NodeLoc = new JSONArray();
		JSONArray NodeWeight = new JSONArray();
		JSONArray NodeTag = new JSONArray();
		JSONArray NodeInfo = new JSONArray();
		JSONArray EdgeSrc = new JSONArray();
		JSONArray EdgeDest = new JSONArray();
		JSONArray EdgeWeight = new JSONArray();
		JSONArray EdgeTag = new JSONArray();
		JSONArray EdgeInfo = new JSONArray();
		Iterator<node_data> IteNode = _graph.getV().iterator();
		while(IteNode.hasNext()){
			node_data next = IteNode.next();
			NodeKey.add(next.getKey());
			NodeLoc.add(next.getLocation().toString());
			NodeWeight.add(next.getWeight());
			NodeTag.add(next.getTag());
			NodeInfo.add(next.getInfo());
			if(_graph.getE(next.getKey())!=null){
				Iterator<edge_data> IteEdge = _graph.getE(next.getKey()).iterator();
				while (IteEdge.hasNext()){
					edge_data nextedge = IteEdge.next();
					EdgeSrc.add(nextedge.getSrc());
					EdgeDest.add(nextedge.getDest());
					EdgeWeight.add(nextedge.getWeight());
					EdgeTag.add(nextedge.getTag());
					EdgeInfo.add(nextedge.getInfo());

				}
			}
		}
		Obj.put("NodeKey", NodeKey);
		Obj.put("NodeLoc",NodeLoc);
		Obj.put("NodeWeight",NodeWeight);
		Obj.put("NodeTag",NodeTag);
		Obj.put("NodeInfo",NodeInfo);
		Obj.put("EdgeSrc",EdgeSrc);
		Obj.put("EdgeDest",EdgeDest);
		Obj.put("EdgeWeight",EdgeWeight);
		Obj.put("EdgeTag",EdgeTag);
		Obj.put("EdgeInfo", EdgeInfo);

		try (FileWriter file = new FileWriter(file_name)) {
			file.write(Obj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public boolean isConnected() {
		Iterator<node_data> SrcIte = _graph.getV().iterator();

		while(SrcIte.hasNext()){
			if(!isConnected(SrcIte.next().getKey())){
				return false;	}

		}


		return true;
	}

	public boolean isConnected(int src){
		try{
				Stack<node_data> NodeStack = new Stack<>();
				node_data source=_graph.getNode(src);
				NodeStack.push(source);

				source.setTag(0);
				String srcchar = ""+src;
				source.setInfo(srcchar);
				try{
					Iterator<edge_data> iterator= _graph.getE(NodeStack.peek().getKey()).iterator();
					}
				catch (Exception e){
					return _graph.getV().size()==1;
				}

				Iterator<edge_data> edges = _graph.getE(NodeStack.peek().getKey()).iterator();
				edge_data nextedge= edges.next();

					while(!NodeStack.empty()){

						if(_graph.getE(NodeStack.peek().getKey())==null){
							NodeStack.pop();
							//get iterator for current edges
						}
						else if(!edges.hasNext()){
							NodeStack.pop();

							//get iterator for current edges
						}


						if(_graph.getNode(nextedge.getDest()).getInfo()=="CTL"){
							return true;
						}

						else if(_graph.getNode(nextedge.getDest()).getInfo()!=srcchar){
							NodeStack.push(_graph.getNode(nextedge.getDest()));
							_graph.getNode(NodeStack.peek().getKey()).setInfo(srcchar);
							source.setTag(source.getTag()+1);
							edges = _graph.getE(NodeStack.peek().getKey()).iterator();
							nextedge = edges.next();


						}


					}
			if(_graph.getV().size()-1==source.getTag()){
				source.setInfo("CTL");//set info as connected to all.
				return true;
			}
			else{
				return false;
			}

				}
				catch (Exception e){

					return false;
				}

	}

	public double shortestPathDist(int src, int dest) {
		try {
			Stack<node_data> nodeStack = new Stack<>();

			node_data start = _graph.getNode(src);
			start.setWeight(0);
			nodeStack.push(start);
			Iterator<edge_data> edge = _graph.getE(nodeStack.peek().getKey()).iterator();
			edge_data nextedge;
			node_data p1;
			node_data p2;
			while (!nodeStack.empty()) {

				if(_graph.getE(nodeStack.peek().getKey())==null||nodeStack.peek().getKey()==dest){
					nodeStack.pop();
					edge = _graph.getE(nodeStack.peek().getKey()).iterator();
					continue;
				}
				nextedge = edge.next();
				p1 = nodeStack.peek();
				p2 = _graph.getNode(nextedge.getDest());

				if(p2.getWeight()>(p1.getWeight()+Distance(p1.getLocation(),p2.getLocation()))){
					p2.setWeight(p1.getWeight()+Distance(p1.getLocation(),p2.getLocation()));
					nodeStack.push(p2);
					if(_graph.getE(nodeStack.peek().getKey())==null){
						nodeStack.pop();
						edge = _graph.getE(nodeStack.peek().getKey()).iterator();
					}
					else{
						edge = _graph.getE(nodeStack.peek().getKey()).iterator();
					}


				}
				else if(edge.hasNext()){
					continue;
				}

				else{
					nodeStack.pop();
					if(nodeStack.empty()){
						continue;
					}
					else{
						edge = _graph.getE(nodeStack.peek().getKey()).iterator();
					}


				}


			}
			return _graph.getNode(dest).getWeight();
		}
		catch (Exception e){
			e.printStackTrace();
			return Double.POSITIVE_INFINITY;}
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		Stack<node_data> NodeStack = new Stack<>();
		String sourcekey = ""+ targets.get(0);
		NodeStack.push(_graph.getNode( targets.get(0)));
		NodeStack.peek().setInfo("TV");
		targets.remove(0);
		Iterator<edge_data> EdgIte = _graph.getE(NodeStack.peek().getKey()).iterator();
		edge_data CurEdge = EdgIte.next();
		while(!targets.isEmpty()){

			if(targets.contains(NodeStack.peek().getKey())){
				if(_graph.getE(NodeStack.peek().getKey())==null){
					return null;
				}
				NodeStack.peek().setInfo("TV");
				targets.remove(Integer.valueOf(NodeStack.peek().getKey()));

			}
			String s =_graph.getNode(CurEdge.getDest()).getInfo();
			if(s.equals(sourcekey)){
				if(EdgIte.hasNext()){
					CurEdge = EdgIte.next();
				}
				else{
					if(NodeStack.peek().getInfo()=="TV"){
						return null;
					}

					NodeStack.pop();
					EdgIte = _graph.getE(NodeStack.peek().getKey()).iterator();
				}
			}
			else if(s.equals("TV")){
				if(EdgIte.hasNext()){
					CurEdge = EdgIte.next();
				}
				else{
					NodeStack.pop();
					EdgIte = _graph.getE(NodeStack.peek().getKey()).iterator();
				}

			}
			else{
				NodeStack.push(_graph.getNode(CurEdge.getDest()));
				NodeStack.peek().setInfo(""+sourcekey);
				if(_graph.getE(NodeStack.peek().getKey())==null){
					NodeStack.pop();
				}
				else{
					EdgIte = _graph.getE(NodeStack.peek().getKey()).iterator();
				}

			}}
		return NodeStack;}



	@Override
	public graph copy() {
		save("forCopy");
		Graph_Algo Copy = new Graph_Algo();
		Copy.init("forCopy");


		return Copy._graph;
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
	public double Distance(Point3D p1, Point3D p2){
		return  p1.distance3D(p2);
	}


}
