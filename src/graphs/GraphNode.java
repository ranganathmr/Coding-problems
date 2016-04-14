package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphNode<T> {

	private T data;
	private Set<GraphNode<T>> neighbours;
	private boolean visited;
	
	
	public GraphNode(T data){
		this.data = data;
		neighbours = new HashSet<GraphNode<T>>();
		visited = false;
	}
	
	public void addNeighbour(GraphNode<T> neighbour) {
		neighbours.add(neighbour);
	}
	
	public void visit(){
		this.visited = true;
	}

	public T getData() {
		return data;
	}

	public Set<GraphNode<T>> getNeighbours() {
		return neighbours;
	}

	public boolean isVisited() {
		return visited;
	}
	
	public GraphNode<T> deepCopy() {
		return deepCopyInternal(this, new HashMap<GraphNode<T>, GraphNode<T>>());
	}
	
	private GraphNode<T> deepCopyInternal(GraphNode<T> node, Map<GraphNode<T>, GraphNode<T>> map){
		if(map.containsKey(node)) {
			return map.get(node);
		}
		GraphNode<T> newNode = new GraphNode<T>(node.getData());
		map.put(node, newNode);
		for(GraphNode<T> neighbor: node.getNeighbours()) {
			node.addNeighbour(deepCopyInternal(neighbor, map));
		}
		return newNode;
	}
	
	public void print() {
		printInternal(deepCopy());
	}
	
	private void printInternal(GraphNode<T> node){
		if(node.isVisited()){
			return;
		}
		System.out.println(node.getData());
		node.visit();
		for(GraphNode<T> neighbor: node.getNeighbours()) {
			printInternal(neighbor);
		}
	}
}
