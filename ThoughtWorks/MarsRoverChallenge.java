package ThoughtWorks;

import java.util.Scanner;

/*
 A squad of robotic rovers are to be landed by NASA on a plateau on Mars. 
 This plateau, which is curiously rectangular, must be navigated by the rovers so that 
 their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.
 A rover's position and location is represented by a combination of x and y co-ordinates 
 and a letter representing one of the four cardinal compass points. The plateau is divided 
 up into a grid to simplify navigation. An example position might be 0, 0, N, 
 which means the rover is in the bottom left corner and facing North.
 In order to control a rover, NASA sends a simple string of letters. 
 The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover 
 spin 90 degrees left or right respectively, without moving from its current spot. 
 'M' means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

INPUT:

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. 
Each rover has two lines of input. The first line gives the rover's position, 
and the second line is a series of instructions telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, 
corresponding to the x and y co-ordinates and the rover's orientation.

Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

OUTPUT:

The output for each rover should be its final co-ordinates and heading.

INPUT AND OUTPUT:

Test Input:
5 5
2
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM

Expected Output:
1 3 N
5 1 E
========== 
*/
class Rover
{
	int xPos;
	int yPos;
	int currDir;
	
	Rover(int xPos, int yPos, int currDir)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.currDir = currDir;
	}
	
	public void moveRover(Rover myRover)
	{
		
		if(myRover.currDir==0)
			myRover.yPos += 1;
		else if(myRover.currDir==1)
			myRover.xPos += 1;
		else if(myRover.currDir==2)
			myRover.yPos -= 1;
		else if(myRover.currDir==3)
			myRover.xPos -= 1;
		
	}
	
	public void moveLeftHeading(Rover myRover)
	{
		
		int temp = myRover.currDir;
		temp -= 1;
		if(temp<0)
			temp += 4;
		myRover.currDir = temp;
		
	}
	
	public void moveRightHeading(Rover myRover)
	{
		
		int temp = myRover.currDir;
		temp += 1;
		if(temp>3)
			temp -= 4;
		myRover.currDir = temp;
		
	}
}

class RoverControl
{
	/*
	 * This method converts the given direction character into 
	 * easily calculable and operationable direction num value:
	 * 
	 * N - 0
	 * E - 1
	 * S - 2
	 * W - 3
	 */
	public int convertDirectionToNum(String dir)
	{
		
		if(dir.equals("N"))
			return 0;
		else if(dir.equals("E"))
			return 1;
		else if(dir.equals("S"))
			return 2;
		else if(dir.equals("W"))
			return 3;
		
		return -1; //no direction
	}
	
	/*
	 * Reverse of what above method does*/
	public String convertDirectionToString(int dirNum)
	{
		
		String dirString = "";
		
		if(dirNum==0)
			return dirString + "N";
		else if(dirNum==1)
			return dirString + "E";
		else if(dirNum==2)
			return dirString + "S";
		else if(dirNum==3)
			return dirString + "W";
		
		return dirString;
	}
	
	/*
	 * This method takes two inputs:
	 * The rover object and command string on which rover should be moved
	 */
	public Rover runCommand(Rover myRover, String command)
	{
		
		for(int i = 0;i<command.length();i++)
		{
			char currentCommand = command.charAt(i);
			
			if(currentCommand=='M')
			{
				myRover.moveRover(myRover);
			}
			else if(currentCommand=='L')
			{
				myRover.moveLeftHeading(myRover);
			}
			else if(currentCommand=='R')
			{
				myRover.moveRightHeading(myRover);
			}
		}
		
		
		return myRover;
	}
	
}

public class MarsRoverChallenge 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		
		//x and y coordintes of plateu
		int xPlateu = input.nextInt();
		int yPlateu = input.nextInt();
		
		//number of rovers
		int n = input.nextInt();
		for(int i = 0;i<n;i++)
		{
			//inputs entered
			int xRoverPos = input.nextInt();
			int yRoverPos = input.nextInt();
			String dirRover = input.next();
			String command = input.next();
			
			//rover control activated
			RoverControl rc = new RoverControl();
			
			//convert the direction character to num value
			int dirRoverNum = rc.convertDirectionToNum(dirRover);
			
			//rover is activated and ready for command
			Rover myRover = new Rover(xRoverPos, yRoverPos, dirRoverNum);
			
			//Run the commands on the rover over plateu
			myRover = rc.runCommand(myRover, command);
			
			//Retrieve the direction in string format back
			dirRover = rc.convertDirectionToString(myRover.currDir);
			
			//print postion and heading of rover
			System.out.println(myRover.xPos+" "+myRover.yPos+" "+dirRover);
		}
		input.close();
	}
}
