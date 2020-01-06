# Class: DGraph.


getNode(int key): return the node_data by the node_id.

getEdge(int source, int destination): Return the data of the edge (src,dest), null if none.

addNode(node_data node): add a new node to the graph with the given node_data.

connect(int source, int destination, double weight): Connect an edge with weight w between node src to node dest.

getV(): This method return a pointer (shallow copy) for the  collection representing all the nodes in the graph.

getE():This method return a pointer (shallow copy) for the collection representing all the edges getting out of the given node (all the edges starting (source) at the given node).

removeNode(int key): Delete the node (with the given ID) from the graph and removes all edges which starts or ends at this node.

removeEdge(int source, int destination): Delete the edge from the graph. 

nodeSize(): returns node size.

edgeSize(): return amount of all edges.

getMC(): returns the mode counter.

# Class: Graph_Algo.

init(graph g): This method will initiate a graph_algo object by the given graph g.

init(String file_name): This method will initiate a graph_algo object from a given text file.

save(String file_name): This method will save a graph_algo object as a text file.

isConnect(): Checks if graph has a strong connection between all nodes

shortestPathDist(int source, int destination): This method is based on the algorithm of Dijkastra. the method will calculate the shortest path from the given int source to the given int destination by considering the smallest weight.

shortestPath(int source, int destination): This method will return a list of node_data that represent the shortest path from the given int source node to the given int destination node.

TSP(List targets): This method finds a relativly short route between all nodes in list.

copy(): returns a deep copy of the graph algo

# Class: DrawGraph

init(String name): will init from file using the Graph_Algo init

Draw(): This method will draw a graph using the java class StdDraw.

Edges ande nodes will draw the edges and nodes 
