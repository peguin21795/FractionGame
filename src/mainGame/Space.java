package mainGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Space extends JPanel implements KeyListener
{
	private int rows;
	private int cols;
	private SpaceCell[][] board;
	private Player ship;
	private Laser laser;
	private final static int BOARD_WIDTH = 500;
	private final static int BOARD_HEIGHT = 500;
	private int cellWidth;
	private int cellHeight;
	private int currentProblem;
	private SpaceTarget hitTarget;
	private MissionControl control;
	private ArrayList<Problem> problems;
	private ArrayList<SpaceTarget> targets;
	private int numOfHits;
	private boolean playerShot = false;
	private StatusPanel status;
	
	public Space(MissionControl ms, Problem firstProblem, StatusPanel s)
	{
		JTextArea topBanner = new JTextArea("    WE  ARE  UNDER  ATTACK  FROM  THE  FEROCIOUS  FRACTION  FLEET!!"
										+ "\n\n           They have come for our Jalapeno's and SouthPark videos!!"
										+ "	\n\n            To save the world you must use the right and left arrows on"
										+ "	\n\n       your keyboard to move your ship under the number that should be where"
										+ "	\n\n       the question mark is in the answer. Once you're under the right number,"
										+ "\n\n                          PRESS THE SPACE BAR AND SHOOT IT!!");
		topBanner.setEditable(false);
		topBanner.setBackground(Color.blue);
		topBanner.setForeground(Color.yellow);
		topBanner.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		JOptionPane.showMessageDialog(this,topBanner, "How To Play The Game",-1);
		JTextArea secondBanner = new JTextArea("                                   BUT WAIT!! "
										+ "\n\n  These Fraction Fighters are sneaky, and sometimes they come in pairs!!"
										+ "\n\n This means that sometimes there will be two question marks in the answer."
										+ "\n\n          YOU HAVE TO SHOOT BOTH ANSWERS TO MOVE ON!!"
										+ "\n\n           Get your fingers ready and click ok to start, Good Luck!!");
		secondBanner.setEditable(false);
		secondBanner.setBackground(Color.MAGENTA);
		secondBanner.setForeground(Color.GREEN);
		secondBanner.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		JOptionPane.showMessageDialog(this, secondBanner, "How To Play The Game",-1);
		status = s;
		problems = new ArrayList<Problem>();
		currentProblem = 0;
		control = ms;
		//Add the first problem to the problem set
		problems.add(firstProblem);
		//Generate the rest of the problem set
		generateProblems();
		targets = control.generateTargets(problems.get(currentProblem));
		System.out.println(targets.get(0));
		rows = 10;
		cols = 12;
		ship = new Player(9, 5);
		numOfHits = 0;
		hitTarget = new SpaceTarget();
		initCells();
		addKeyListener(this);
		Dimension d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
		setPreferredSize(d);
		setVisible(true);
	}
	
	

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//Calculate the size of each space cell
		cellWidth = BOARD_WIDTH/cols;
		cellHeight = BOARD_HEIGHT/rows;
				
		//Draw all the space cells
		for(int i = 0; i < rows; i++)
		{
			for(SpaceCell b : board[i])
			{
				b.draw(g, cellWidth, cellHeight);
			}
		}
		
		//Draw the player
		board[ship.getRow()][ship.getCol()].drawPlayer(g, cellWidth, cellHeight);
		
		//Draw the targets
		for(SpaceTarget s : targets)
		{
			if(problems.get(currentProblem).getOperation().equals("divide") && problems.get(currentProblem).getLevel() == 2)
			{
				board[s.getRow()][s.getCol()].drawTarget(g, cellWidth, cellHeight, s.getTargetFloat());
			}
			else
			{
				board[s.getRow()][s.getCol()].drawTarget(g, cellWidth, cellHeight, s.getTargetNumber());
			}
		}
		
		//Draw laser if necessary
		if(playerShot)
		{
			laser = new Laser(ship, this);
			SpaceTarget temp = new SpaceTarget(-1, -1, 0);
			for (SpaceTarget t : targets)
			{
				if (t.getCol() == ship.getCol())
				{
					temp = t;
				}
			}
			int distance = ship.getDistanceToTarget(temp);
			//loop until shot has hit target, using distance to target as a bound
			for(int i = 0; i < distance; i++)
			{
				board[laser.getRow()][laser.getCol()].drawLaser(g, cellWidth, cellHeight);
				laser.updateLocation();
			}
			
			if(problems.get(currentProblem).getTwoPartProblem())
			{
				if(temp.equals(targets.get(0)) && numOfHits == 0)
				{
					System.out.println("-------------1----------------");
					control.setShowCorrectNumFlag(true);
					control.updateDisplay(problems.get(currentProblem));
					numOfHits++;
					hitTarget = targets.get(0);
					//System.out.println("1 " + control.isShowCorrectNumFlag() + " " + control.isShowCorrectWholeFlag());
				}
				else if(temp.equals(targets.get(1)) && numOfHits == 0)
				{
					System.out.println("-------------2----------------");
					control.setShowCorrectWholeFlag(true);
					control.updateDisplay(problems.get(currentProblem));
					numOfHits++;
					hitTarget = targets.get(1);
					//System.out.println("2 " + control.isShowCorrectNumFlag() + " " + control.isShowCorrectWholeFlag());
				}
				else if (temp.equals(targets.get(0)) && numOfHits == 1 && hitTarget.equals(targets.get(1)))
				{
					System.out.println("-------------3----------------");
					control.setShowCorrectNumFlag(false);
					control.setShowCorrectWholeFlag(false);
					status.updateFeedBackPanel(problems.get(currentProblem).getStatusLevel());
					currentProblem++;
					if(currentProblem == 60){
						JOptionPane.showMessageDialog(this, "Congatulations!! YOU WON!!!");
						System.exit(0);
					}
					targets = control.generateTargets(problems.get(currentProblem));
					control.updateDisplay(problems.get(currentProblem));
					numOfHits = 0;
					//System.out.println("3 " + control.isShowCorrectNumFlag() + " " + control.isShowCorrectWholeFlag());
				}
				else if (temp.equals(targets.get(1)) && numOfHits == 1 && hitTarget.equals(targets.get(0)))
				{
					System.out.println("-------------4----------------");
					control.setShowCorrectNumFlag(false);
					control.setShowCorrectWholeFlag(false);
					status.updateFeedBackPanel(problems.get(currentProblem).getStatusLevel());
					currentProblem++;
					if(currentProblem == 60){
						JOptionPane.showMessageDialog(this, "Congatulations!! YOU WON!!!");
						System.exit(0);
					}
					targets = control.generateTargets(problems.get(currentProblem));
					control.updateDisplay(problems.get(currentProblem));
					numOfHits = 0;
					//System.out.println("4 " + control.isShowCorrectNumFlag() + " " + control.isShowCorrectWholeFlag());
				}
			}
			
			else if(temp.equals(targets.get(0)))
			{
				//System.out.println("HIT!!");
				status.updateFeedBackPanel(problems.get(currentProblem).getStatusLevel());
				currentProblem++;
				targets = control.generateTargets(problems.get(currentProblem));
				control.updateDisplay(problems.get(currentProblem));
			}
		}		
		
	}
	
	public void initCells()
	{
		board = new SpaceCell[rows][cols];
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++ )
			{
				board[i][j] = new SpaceCell(i, j, null);
			}
		}
	}
	
	public SpaceCell getCellAt(int r, int c)
	{
		return board[r][c];
	}

	public int getCellWidth() {
		return cellWidth;
	}

	public int getCellHeight() {
		return cellHeight;
	}

	public void setPlayerShot(boolean playerShot) {
		this.playerShot = playerShot;
	}
	
	//Randomly generate the game problem set
	public void generateProblems() 
	{	
		for(int i = 1; i < 60; i++)
		{
			//Problems 1-5 are division level 1
			if(i < 5)
			{
				Problem temp = new Problem("divide", 1, 0);
				problems.add(temp);
			}
			//Problems 6-10 are factoring level 1
			else if(i < 10)
			{
				Problem temp = new Problem("factor", 1, 1);
				problems.add(temp);
			}
			//Problems 11-15 are addition level 1
			else if(i < 15)
			{
				Problem temp = new Problem("add", 1, 2);
				problems.add(temp);
			}
			//Problems 16-20 are subtraction level 1
			else if(i < 20)
			{
				Problem temp = new Problem("subtract", 1, 3);
				problems.add(temp);
			}
			//Problems 20-25 are division level 2
			else if(i < 25)
			{
				Problem temp = new Problem("divide", 2, 4);
				problems.add(temp);
			}
			//Problems 26-30 are factoring level 2
			else if(i < 30)
			{
				Problem temp = new Problem("factor", 2, 5);
				problems.add(temp);
			}
			//Problems 31-35 are addition level 2
			else if(i < 35)
			{
				Problem temp = new Problem("add", 2, 6);
				problems.add(temp);
			}
			//Problems 36-40 are subtraction level 2
			else if(i < 40)
			{
				Problem temp = new Problem("subtract", 2, 7);
				problems.add(temp);
			}
			//Problems 41-45 are division level 3
			else if(i < 45)
			{
				Problem temp = new Problem("divide", 3, 8);
				problems.add(temp);
			}
			//Problems 46-50 are factoring level 3
			else if(i < 50)
			{
				Problem temp = new Problem("factor", 3, 9);
				problems.add(temp);
			}
			//Problems 51-55 are addition level 3
			else if(i < 55)
			{
				Problem temp = new Problem("add", 3, 10);
				problems.add(temp);
			}
			//Problems 56-60 are subtraction level 3
			else if(i < 60)
			{
				Problem temp = new Problem("subtract", 3, 11);
				problems.add(temp);
			}
		}
		
		for (Problem p: problems)
		{
			System.out.println(p);
		}
	}

	public void keyPressed(KeyEvent e)
	{
		//The player should shoot if the space key is pressed
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			setPlayerShot(true);
			this.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			setPlayerShot(false);
			ship.move('L', this);
			this.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			setPlayerShot(false);
			ship.move('R', this);
			this.repaint();
		}
		
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int getRows() {
		return rows;
	}
	
	public int getCols()
	{
		return cols;
	}


	public ArrayList<Problem> getProblems() {
		return problems;
	}
	
	public Player getShip() {
		return ship;
	}



	public void setShip(Player ship) {
		this.ship = ship;
	}
	
	public void storyLinePanel(){
		JPanel area = new JPanel();
		JLabel topBanner = new JLabel("WE ARE UNDER ATTACK FROM PHANTOM FRACTION FLEET"
				+ "\nTo save the world you must use the right and left"
				+ "\narrows to move under the number that should be where"
				+ "\nquestion mark is in the answer and press the space bar to shoot!",SwingConstants.CENTER);
	}
	
}
