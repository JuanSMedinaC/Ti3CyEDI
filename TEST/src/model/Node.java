package model;

import java.util.ArrayList;


public class Node {
	private int data;
	private ArrayList<Node> adjacentNodes;
	private Color color;
	private int dist;
	private Node pre;
	
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


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public int getDist() {
		return dist;
	}


	public void setDist(int dist) {
		this.dist = dist;
	}


	public Node getPre() {
		return pre;
	}


	public void setPre(Node pre) {
		this.pre = pre;
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