/* RubikCubeView:
 * 	Class handling the format of and presentation of the the display of the GUI.
 *  Everything the user sees as well as event listeners for each interactive part of the display
 *  are handled here
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public final class RubikCubeView extends JFrame implements ActionListener{
	
	//Controller registered with the view to observe user events
    private RubikCubeController controller;
	
	
	//Operator buttons related to the different notations of a Rubik's Cube
	private final JButton L, LPrime, R, RPrime, U, UPrime, D, DPrime, F, FPrime, B, BPrime;
	
	//Useful constants
	private static final int BUTTON_GRID_PANEL_ROWS = 2, BUTTON_GRID_PANEL_COLUMNS = 6, WIDTH = 30, HEIGHT = 30,
							INITIAL_X = 200, INITIAL_Y = 200, OFFSET = 31, CUBELETS = 9, FACES = 6;
	
	//Array List to hold the different colored cublets for each face of the Rubik's Cube
	private ArrayList<ArrayList<Shape>> faces = new ArrayList<ArrayList<Shape>>(FACES);
	
	//Display panel for the actual Rubik's Cube
	private final JPanel cubeDisplayPanel = new cubeDisplayPanel();
	
	
	
	//default constructor
	public RubikCubeView() {
		
		//Set name for the java application
		super("Rubik Cube Scrambler");
		
		this.L = new JButton("L");
		this.LPrime = new JButton("L'");
		this.R = new JButton("R");
		this.RPrime = new JButton("R'");
		this.U = new JButton("U");
		this.UPrime = new JButton("U'");
		this.D = new JButton("D");
		this.DPrime = new JButton("D'");
		this.F = new JButton("F");
		this.FPrime = new JButton("F'");
		this.B = new JButton("B");
		this.BPrime = new JButton("B'");
		
		//Add all the cubelets to each face of the Rubik's Cube
		for(int i = 0; i < FACES; i++) 
			faces.add(new ArrayList<Shape>(CUBELETS));
		
		//add the white face to the Rubik's Cube
		int xCoord = INITIAL_X;
		int yCoord = INITIAL_Y;
		
		for(int i = 0; i < CUBELETS; i++) {
			faces.get(0).add(new Rectangle(xCoord,yCoord,WIDTH,HEIGHT,Color.WHITE));
			if(i == 2 || i == 5 || i == 8) {
				xCoord -= OFFSET*2;
				yCoord += OFFSET;
			} else
				xCoord += OFFSET;
		}
		
		//add the blue face to the Rubik's Cube
		xCoord = INITIAL_X;
		yCoord = INITIAL_Y-(OFFSET*3);
				
		for(int i = 0; i < CUBELETS; i++) {
			faces.get(1).add(new Rectangle(xCoord,yCoord,WIDTH,HEIGHT,Color.BLUE));
			if(i == 2 || i == 5 || i == 8) {
				xCoord -= OFFSET*2;
				yCoord += OFFSET;
			} else
				xCoord += OFFSET;
		}
				
		//add the green face to the Rubik's Cube
		 xCoord = INITIAL_X;
		 yCoord = INITIAL_Y+(OFFSET*3);
			
		for(int i = 0; i < CUBELETS; i++) {
			faces.get(2).add(new Rectangle(xCoord,yCoord,WIDTH,HEIGHT,Color.GREEN));
			if(i == 2 || i == 5 || i == 8) {
			xCoord -= OFFSET*2;
					yCoord += OFFSET;
			} else
				xCoord += OFFSET;
		}
		
		//add the orange face to the Rubik's Cube
		 xCoord = INITIAL_X-(OFFSET*3);
		 yCoord = INITIAL_Y;
				
		for(int i = 0; i < CUBELETS; i++) {
			faces.get(3).add(new Rectangle(xCoord,yCoord,WIDTH,HEIGHT,Color.ORANGE));
			if(i == 2 || i == 5 || i == 8) {
				xCoord -= OFFSET*2;
				yCoord += OFFSET;
			} else
				xCoord += OFFSET;
		}
		
		//add the red face to the Rubik's Cube
		 xCoord = INITIAL_X+(OFFSET*3);
		 yCoord = INITIAL_Y;
			
		for(int i = 0; i < CUBELETS; i++) {
			faces.get(4).add(new Rectangle(xCoord,yCoord,WIDTH,HEIGHT,Color.RED));
			if(i == 2 || i == 5 || i == 8) {
				xCoord -= OFFSET*2;
				yCoord += OFFSET;
			} else
				xCoord += OFFSET;
		}
		
		//add the yellow face to the Rubik's Cube
		 xCoord = INITIAL_X+(OFFSET*6);
		 yCoord = INITIAL_Y;
				
		for(int i = 0; i < CUBELETS; i++) {
			faces.get(5).add(new Rectangle(xCoord,yCoord,WIDTH,HEIGHT,Color.YELLOW));
			if(i == 2 || i == 5 || i == 8) {
				xCoord -= OFFSET*2;
				yCoord += OFFSET;
			} else
				xCoord += OFFSET;
		}
		
		//Panel for buttons allowing user to move each face of the cube
		JPanel mainButtonPanel = new JPanel(new GridLayout(BUTTON_GRID_PANEL_ROWS,BUTTON_GRID_PANEL_COLUMNS));
		//Panel for displaying the cube
		cubeDisplayPanel.setPreferredSize(new Dimension(400,400));
		
		//Add buttons to mainButtonPanel from left to right, top to bottom
		mainButtonPanel.add(this.F);
		mainButtonPanel.add(this.R);
		mainButtonPanel.add(this.U);
		mainButtonPanel.add(this.L);
		mainButtonPanel.add(this.B);
		mainButtonPanel.add(this.D);
		mainButtonPanel.add(this.FPrime);
		mainButtonPanel.add(this.RPrime);
		mainButtonPanel.add(this.UPrime);
		mainButtonPanel.add(this.LPrime);
		mainButtonPanel.add(this.BPrime);
		mainButtonPanel.add(this.DPrime);
		
		//Register each button as an observer for all GUI events
		this.L.addActionListener(this);
		this.LPrime.addActionListener(this);
		this.R.addActionListener(this);
		this.RPrime.addActionListener(this);
		this.U.addActionListener(this);
		this.UPrime.addActionListener(this);
		this.D.addActionListener(this);
		this.DPrime.addActionListener(this);
		this.F.addActionListener(this);
		this.FPrime.addActionListener(this);
		this.B.addActionListener(this);
		this.BPrime.addActionListener(this);
		
		//Add each panel (Buttons and cube display) to the whole frame
		this.add(mainButtonPanel, BorderLayout.SOUTH);
		this.add(cubeDisplayPanel, BorderLayout.NORTH);
        this.pack();
        //Program exists on close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the size of the frame
        this.setSize(600, 600);
        //Make the frame visible to the user
        this.setVisible(true);
		
	}
	
	//Register the controller as an observer for events
	public void registerObserver(RubikCubeController controller) {

        this.controller = controller;

    }

	//Function that returns the array list holding every cubelet of every face of the Rubik's Cube
	//to be updated
	public ArrayList<ArrayList<Shape>> getRubikCubeArray() {
		return faces;
	}
	
	//Repaint the Rubik Cube display based on how the user chooses to scramble the puzzle
	public void repaintScreen() {
		cubeDisplayPanel.repaint();
	}
	
	//Class for drawing the cubelets onto the screen
	class cubeDisplayPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int thickness = 3;
			Graphics2D shape = (Graphics2D) g.create();
			shape.setStroke(new BasicStroke(thickness));
			for(int i = 0; i < faces.size(); i++) {
				for(int j = 0; j < faces.get(0).size(); j++) {
					faces.get(i).get(j).paint(shape);
				}
			}
				
			
		}
	}
	/*Process the corresponding event depending on the button pressed by the user. Each button
	*corresponds to the following movements on a Rubik's cube:
	*F = 90 degree clockwise rotation of the front face
	*FPrime = 90 degree counterclockwise rotation of the front face
	*R = 90 degree clockwise rotation of the right face
	*RPrime = 90 degree counterclockwise rotation of the right face
	*L = 90 degree clockwise rotation of the left face
	*LPrime = 90 degree counterclockwise rotation of the left face
	*U = 90 degree clockwise rotation of the top face
	*UPrime = 90 degree counterclockwise rotation of the top face
	*D = 90 degree clockwise rotation of the bottom face
	*DPrime = 90 degree counterclockwise rotation of the bottom face
	*B = 90 degree clockwise rotation of the back face
	*BPrime = 90 degree counterclockwise rotation of the back face
	*/
	
	@Override
	public void actionPerformed(ActionEvent event) {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		
		Object source = event.getSource();
		if(source == this.F) 
			this.controller.processFEvent();
		else if(source == this.FPrime) 
			this.controller.processFPrimeEvent();
		else if(source == this.R)
			this.controller.processREvent();
		else if(source == this.RPrime)
			this.controller.processRPrimeEvent();
		else if(source == this.L)
			this.controller.processLEvent();
		else if(source == this.LPrime)
			this.controller.processLPrimeEvent();
		else if(source == this.U)
			this.controller.processUEvent();
		else if(source == this.UPrime)
			this.controller.processUPrimeEvent();
		else if(source == this.B)
			this.controller.processBEvent();
		else if(source == this.BPrime)
			this.controller.processBPrimeEvent();
		else if(source == this.D)
			this.controller.processDEvent();
		else if(source == this.DPrime)
			this.controller.processDPrimeEvent();

		
		this.setCursor(Cursor.getDefaultCursor());
		
		
	}

}
