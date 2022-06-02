package model;

import java.util.ArrayList;

public class Node {
	private int data;
	private ArrayList<Node> adjacentNodes;
	
	public Node(int data)
	{
		this.setData(data);
		adjacentNodes=new ArrayList<>();
	}
	
	public ArrayList<Node> getAdjacentNodes() {
		return adjacentNodes;
	}


	public void setAdjacentNodes(ArrayList<Node> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
	
	public void addEdge(Node node)
	{
		adjacentNodes.add(node);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public String toString()
	{
		String out="";
		out+=this.data+" -> ";
		for(int i=0; i<adjacentNodes.size(); i++)
		{
			out+="("+adjacentNodes.get(i).getData()+") ";
		}
		return out;
	}
	
}
