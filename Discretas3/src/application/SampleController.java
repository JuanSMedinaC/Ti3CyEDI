package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Graph;
import model.Node;

public class SampleController {

    @FXML
    private AnchorPane backgroundImage;

    @FXML
    private ImageView background;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn12;

    @FXML
    private Button btn14;

    @FXML
    private Button btn13;

    @FXML
    private Button btn15;

    @FXML
    private Button btn16;

    @FXML
    private Button btn17;

    @FXML
    private Button btn18;

    @FXML
    private Button btn19;

    @FXML
    private Button btn20;

    @FXML
    private Button btn21;

    @FXML
    private Button btn22;

    @FXML
    private Button btn23;

    @FXML
    private Button btn24;

    @FXML
    private Button btn25;

    @FXML
    private Button btn26;

    @FXML
    private Button btn27;

    @FXML
    private Button btn28;

    @FXML
    private Button btn29;

    @FXML
    private Button btn30;

    @FXML
    private Button btn31;

    @FXML
    private Button btn32;

    @FXML
    private Button btn33;

    @FXML
    private Button btn34;

    @FXML
    private Button btn35;

    @FXML
    private Button btn36;

    @FXML
    private Button btn37;

    @FXML
    private Button btn38;

    @FXML
    private Button btn39;

    @FXML
    private Button btn40;

    @FXML
    private Button btn41;

    @FXML
    private Button btn42;

    @FXML
    private Button btn43;

    @FXML
    private Button btn44;

    @FXML
    private Button btn45;

    @FXML
    private Button btn46;

    @FXML
    private Button btn47;

    @FXML
    private Button btn48;

    @FXML
    private Button btn49;

    @FXML
    private Button btn50;

    @FXML
    private Button btn0;

    @FXML
    private Pane pane;

    @FXML
    private TextArea area;
    
    @FXML
    private TextField bfsTextField;

    @FXML
    private TextField dijkstraTextField;



    public void initialize() 
    {
    	area.setEditable(false);;
    	bfsTextField.setEditable(false);
    	dijkstraTextField.setEditable(false);
    	try {
    		Image image=null;
    		image= new Image(new FileInputStream("files/lyon-image.png"));
    		this.background.setImage(image);
    		background.resize(900, 600);
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println(e);
    	}
    	
    	
    	
    }
    
    public void shortestPath(ActionEvent e) throws IOException, NumberFormatException
    {
    	Button pressed=(Button) e.getSource();
    	int dest=Integer.parseInt(pressed.getText());
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
		}
		input.close();
		fr.close();
		FileReader fr2 = new FileReader(file);
		BufferedReader input2 = new BufferedReader(fr2);
		while (input2.ready()) { 
			String line = input2.readLine();
			String [] objInfo = line.split(",");
			//g.addEdge(Integer.parseInt(objInfo[0]), Integer.parseInt(objInfo[1]));
			g.setEdges(Integer.parseInt(objInfo[0]), Integer.parseInt(objInfo[1]));
		}
		input2.close();
		fr2.close();
		
    	bfsTextField.setText(g.BFS(dest)); 
    	dijkstraTextField.setText(g.shortestPath(dest));
    	System.out.println(g.BFS(dest));
    	System.out.println(g.shortestPath(dest));
    	
    }
    
    
}
