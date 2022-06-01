package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.*;

public class Main{
	public static void main(String[] args) throws IOException
	{
		Graph g=new Graph(51);
		
		for(int n=0; n<51; n++)
		{
			Node node=new Node(n);
			g.addNode(node);
		}
		File file = new File("files/datosDelivery.txt"); 
		FileReader fr = new FileReader(file);
		BufferedReader input = new BufferedReader(fr);
		while (input.ready()) { 
			String line = input.readLine();
			String [] objInfo = line.split(",");
			g.addEdge(Integer.parseInt(objInfo[0]), Integer.parseInt(objInfo[1]));
			System.out.println("se anadió "+objInfo[0]+" "+objInfo[1]);
		}
		input.close();
		fr.close();
		g.print();
		FileReader fr2 = new FileReader(file);
		BufferedReader input2 = new BufferedReader(fr2);
		while (input2.ready()) { 
			String line = input2.readLine();
			String [] objInfo = line.split(",");
			//g.addEdge(Integer.parseInt(objInfo[0]), Integer.parseInt(objInfo[1]));
			g.setEdges(Integer.parseInt(objInfo[0]), Integer.parseInt(objInfo[1]));
			System.out.println("se anadió "+objInfo[0]+" "+objInfo[1]);
		}
		input2.close();
		fr.close();
		g.print2();
		
		g.dijkstra();
		
	}
}