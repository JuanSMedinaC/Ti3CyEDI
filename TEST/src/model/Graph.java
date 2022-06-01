package model;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {	
	private ArrayList<Node> nodes;
	private int[][] matrix;
	private boolean[] visited; 
	private int[] weights;
	private int[] prev;
	
	public Graph(int size)
	{
		matrix=new int[size][size];
		nodes=new ArrayList<>();
		for(int i=0; i<51; i++)
		{
			for(int n=0; n<51; n++)
			{
				matrix[i][n]=99;
			}
		}
		for(int i=0; i<51; i++)
		{
			matrix[i][i]=0;
			
		}
		visited= new boolean[size]; 
		weights= new int[size];
		prev= new int[size];
	}
	
	public void addNode(Node node)
	{
		nodes.add(node);
	}
	
	public void addEdge(int src, int dst)
	{
		matrix[src][dst]=1;
	}
	
	public void dijkstra()	{		
		for (int i=0; i < nodes.size();i++) {
			visited[i]=false;
			for (int j=0 ; j<nodes.get(0).getAdjacentNodes().size();j++) {
				if(nodes.get(0).getAdjacentNodes().get(j).getData()==i) {
					weights[i]=	1;				
				}
				else {
					weights[i]=99;
				}
				
			}
			
			prev[i]=nodes.get(0).getData();
			System.out.println(prev);
		}
		visited[0]=true;
		weights[0] = 0;
		
		for (int i = 0; i< nodes.size() ; i++) {
			int vertex = min(); 
			System.out.println(vertex);
			
			visited[vertex]=true;
			
			for (int k=0; k<nodes.size();k++) {
				if (visited[k]==false) {
					if((weights[vertex]+matrix[vertex][k])< weights[k]) {
						weights[k]= weights[vertex]+matrix[vertex][k];
						prev[k]= vertex;
					}
				}
			}
		}
		System.out.println("Costo minimo de 0 a 1: "+weights[1]);
		shortestPath(1);
	}
	
	public ArrayList<Integer> shortestPath(int dest) {
		ArrayList<Integer> a= new ArrayList<Integer>();
		Stack<Integer> path = new Stack<Integer>();


		int lst=-1;
		path.add(dest);
		lst=dest;
		while(lst!=0) {
			path.add(prev[lst]);
			lst=prev[lst];
			
			
		}
		
		while(path.size()>0) {
			a.add(path.pop());
			
		}
			
		
		
		for (int i = 0; i<a.size();i++) {
			System.out.println(a.get(i));
		}
		
		return a;
	}
	
	public int min() {
		int max= 99;
		int vertex=0;
		for (int j=0; j<nodes.size(); j++) {
			if(visited[j]==false && (weights[j]<=max)) {
				max=weights[j];
				vertex=j;
			}
		}
		return vertex;
	}
	
	public boolean checkEdge(int src, int dst)
	{
		if (matrix[src][dst]==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void setEdges(int src, int dst)
	{
		for(int i=0; i<51; i++)
		{
			if(nodes.get(i).getData()==src)
			{
				for(int n=0; n<51; n++)
				{
					if(nodes.get(n).getData()==dst)
					{
						nodes.get(i).addEdge(nodes.get(n));
					}
				}
			}
		}
	}
	
	public void print()
	{
		System.out.print("   ");
		for(int i=0; i<10; i++)
		{
			System.out.print(i+"  ");
		}
		for(int i=10; i<51; i++)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i=0; i<51; i++)
		{
			if(i<10)
			{
				System.out.print(i+"  ");
			}
			else
			{
				System.out.print(i+" ");
			}
			for(int n=0; n<51; n++)
			{
				System.out.print(matrix[i][n]+"  ");
			}
			System.out.println();
		}
	}
	
	public void print2()
	{
		for(int i=0; i<nodes.size(); i++)
		{
			System.out.println(nodes.get(i).toString());
		}
	}
	
}
