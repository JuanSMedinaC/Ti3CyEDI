package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {	
	ArrayList<Node> nodes;
	int[][] matrix;
	Node[][] predecesors;
	private boolean[] visit;//dijkstra
	private int[] weights;	//dijkstra
	private int[] prev;		//dijkstra
	
	public Graph(int size) throws IOException
	{
		visit=new boolean[size];
		weights=new int[size];
		prev=new int[size];
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
		
		predecesors=new Node[51][51];
		for(int i=0; i<51; i++)
		{
			for(int n=0; n<51; n++)
			{
				predecesors[i][n]=null;
			}
		}
		
	}
	
	public void addNode(Node node)
	{
		nodes.add(node);
	}
	
	public void addEdge(int src, int dst)
	{
		matrix[src][dst]=1;
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
	
	/*
	 * dado que no hay pesos en el grafo porque el tiempo de recorrida entre cada nodo es practicamente igual para todas las calles, 
	 * la matriz resultante del algoritmo será una matriz en la que estarán los nodos intermediarios para llegar de un nodo a otro.
	 */
	public void floyd() 
	{
		for(int i=0; i<predecesors.length; i++)
		{
			System.out.println("i: "+i);
			for(int k=0; k<predecesors.length; k++)
			{
				System.out.println("k: "+k);
				for(int j=0; j<predecesors.length; j++)
				{
					System.out.println("j: "+j);
					if(matrix[i][j]>matrix[i][k]+matrix[k][j])
					{
						System.out.println(matrix[i][j]+" > "+(matrix[i][k] + matrix[k][j]));
						predecesors[i][j]=nodes.get(k);
					}
				}
			}
		}
	}
	
	
	public void print3()
	{
		for(int i=0; i<51; i++)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		for(int k=0; k<predecesors.length; k++)
		{
			for(int j=0; j<predecesors.length; j++)
			{
				if(predecesors[k][j]!=null)
				{
					System.out.print(predecesors[k][j].getData()+"  ");
				}
				else
				{
					System.out.print("-"+" ");
				}
			}
			System.out.println();
		}
	}
	
	public String BFS(int dest)
	{
		String out="";
		int[] pre=new int[nodes.size()];
		int[] dist=new int[nodes.size()];
		boolean[] visited=new boolean[nodes.size()];
		//BFS
		for(int i=0; i<nodes.size(); i++)
		{
			visited[i]=false;
			dist[i]=Integer.MAX_VALUE;
			pre[i]=-1;
		}
		Queue<Integer> q=new LinkedList<>();
		visited[0]=true;
		dist[0]=0;
		q.add(0);
		boolean stop=false;
		while(true)
		{
			
			int u=q.remove();
			for(int i=0; i<nodes.size(); i++)
			{
				
				if(matrix[u][i]==1)  
				{
					if(visited[i]==false)
					{
						visited[i]=true;
						dist[i]=dist[u]+1;
						pre[i]=u;
						q.add(i);
						
						if(i==dest)
						{
							stop=true;
							
							break;
						}
					}
					
				}
			}
			if(q.isEmpty() || stop==true)
			{
				break;
			}
		}
		
		ArrayList<Integer> path=new ArrayList<>();
		int inter=dest;
		path.add(inter);

		while(pre[inter]!=-1)
		{
			path.add(pre[inter]);
			inter=pre[inter];
		}
		
		for(int i=0; i<path.size(); i++)
		{
			if(i==path.size()-1)
			{
				out+="("+path.get(path.size()-1-i)+")";
			}
			else
			{
				out+="("+path.get(path.size()-1-i) + ")->";
			}
		
		}
		System.out.println(dist[dest]);
		return out;
	}
	
	public void dijkstra()	{		
		for (int i=0; i < nodes.size();i++) {
			visit[i]=false;
			for (int j=0 ; j<nodes.get(0).getAdjacentNodes().size();j++) {
				if(nodes.get(0).getAdjacentNodes().get(j).getData()==i) {
					weights[i]=	1;				
				}
				else {
					weights[i]=99;
				}
				
			}
			
			prev[i]=nodes.get(0).getData();
		}
		visit[0]=true;
		weights[0] = 0;
		
		for (int i = 0; i< nodes.size() ; i++) {
			int vertex = min(); 
			//System.out.println(vertex);
			
			visit[vertex]=true;
			
			for (int k=0; k<nodes.size();k++) {
				if (visit[k]==false) {
					if((weights[vertex]+matrix[vertex][k])< weights[k]) {
						weights[k]= weights[vertex]+matrix[vertex][k];
						prev[k]= vertex;
					}
				}
			}
		}
	}
	
	
	
	public String shortestPath(int dest) {
		String out="";
		dijkstra();
		Stack<Integer> path = new Stack<Integer>();


		int lst=-1;
		path.add(dest);
		lst=dest;
		while(lst!=0) {
			path.add(prev[lst]);
			lst=prev[lst];
			
			
		}
		
		while(path.size()>0) {
			if(path.size()==1)
			{
				out+="("+path.pop()+")";
			}
			else
			{
				out+="("+path.pop()+")->";
			}
			
		}
			
		
		
		return out;
	}
	
	
	
	public int min() {
		int max= 99;
		int vertex=0;
		for (int j=0; j<nodes.size(); j++) {
			if(visit[j]==false && (weights[j]<=max)) {
				max=weights[j];
				vertex=j;
			}
		}
		return vertex;
	}
	
}
