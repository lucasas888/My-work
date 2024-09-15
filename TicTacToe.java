//create a tic tac toe game


import java.util.Scanner; 
import java.util.Arrays;
import java.util.ArrayList;



public class TicTacToe
{
	public static Scanner input = new Scanner(System.in);
	
	public static void main (String [] args)
	{
		Board board = new Board();
		
		Player playerOne = new Player();
		Player playerTwo = new Player();
		
		runStart(playerOne, playerTwo);
		
		rollDice(playerOne, playerTwo);
		
		runGame(playerOne, playerTwo, board);

		
	}
	
	public static void runStart(Player playerOne, Player playerTwo)
	{
		System.out.println("\nWelcome, i see you two would like to play a game of TicTacToe!");
		System.out.println("Please enter your names so i can decide who would given the first move :)\n");
		
		System.out.print("\nFirst Player's name: ");
		playerOne.setName(input.nextLine());
		
		System.out.print("\nSecond Player's name: ");
		playerTwo.setName(input.nextLine());
		
	}

	public static void rollDice(Player playerOne, Player playerTwo)
	{
		int k = (int)(Math.random() * 2);
		
		boolean oneMove;
		boolean twoMove;
		if(k == 0)
		{
			playerOne.setPlaceholder('O');
			playerTwo.setPlaceholder('X');
			
			twoMove = false;
			oneMove = true;
		}
		else
		{
			playerOne.setPlaceholder('X');
			playerTwo.setPlaceholder('O');
			
			twoMove = true;
			oneMove = false;
		}
		
		playerOne.setMove(oneMove);
		playerTwo.setMove(twoMove);
		
	}
	
	public static void runGame(Player playerOne, Player playerTwo, Board board)
	{
		System.out.printf("%n%s will be: '%c'", playerOne.getName(), playerOne.getPlaceholder());
		System.out.printf("%n%s will be: '%c'%n", playerTwo.getName(), playerTwo.getPlaceholder());
		System.out.println("\n'O' will make the first move");
		
		
		while(board.checkDraw() == false && board.checkWin(playerOne) == false && board.checkWin(playerTwo) == false)
		{
			if(playerOne.getMove() == true)
			{
				System.out.printf("%s, please enter a number (1 - 9) where you would like to place your piece: ", playerOne.getName());
				int move = input.nextInt();
				input.nextLine();
				while(board.makeMove(move, playerOne) == false)
				{
					System.out.print("Invalid move, please enter a number again: ");
					move = input.nextInt();
					input.nextLine();
				}
				System.out.println("Move accepted");
				playerOne.setMove(false);
				playerTwo.setMove(true);
			}
				
			else if(playerTwo.getMove() == true)
			{
				System.out.printf("%s, please enter a number (1 - 9) where you would like to place your piece: ", playerTwo.getName());
				int move = input.nextInt();
				input.nextLine();
				while(board.makeMove(move, playerTwo) == false)
				{
					System.out.print("Invalid move, please enter a number again: ");
					move = input.nextInt();
					input.nextLine();
				}
				System.out.println("Move accepted");
				playerOne.setMove(true);
				playerTwo.setMove(false);
			}
			
			System.out.println("\nThe current board: \n");
			board.printBoard();
			
		}
		
		
		
		if(board.checkWin(playerOne) == true)
		{

			System.out.printf("%nCongratulations %s, you have won this round of TicTacToe%n", playerOne.getName());	
		}
		
		else if(board.checkWin(playerTwo) == true)
		{
			System.out.printf("%nCongratulations %s, you have won this round of TicTacToe%n", playerTwo.getName());
		}
		
		else if(board.checkDraw() == true)
		{
			System.out.println("\nIt appears we have came to a draw, there are no more possible moves\n");
		}
		
		promptRestart(playerOne, playerTwo, board);
	}
	
		
		
	
	public static void promptRestart(Player playerOne, Player playerTwo, Board board)
	{
		System.out.println("We have reached the end of the game, type /restart to play another round or type any other character to end the program\n");
		
		String userInput = input.nextLine();

		
		if(userInput.equals("/restart"))
		{
			rollDice(playerOne, playerTwo);
			board.resetBoard();
			
			runGame(playerOne, playerTwo, board);
		}
		else
		{
			System.out.println("Thank you for playing, see you again soon!");
		}
		
			
	}
		
}

class Board
{
	private static char [][] symbol = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
	
	public Board()
	{
	 
	}
	
	public Board(char [][] symbol)
	{
		for(int i = 0; i < symbol.length; i++)
		{
			for(int j = 0; j < symbol[i].length; j++)
			{
				this.symbol[i][j] = symbol[i][j];
			}
		}
	}
	
	public Board(Board copy)
	{
		for(int i = 0; i < symbol.length; i++)
		{
			for(int j = 0; j < symbol[i].length; j++)
			{
				copy.symbol[i][j] = symbol[i][j];
			}
		}
	}
	
	private void fillSquareOne(char placeholder)
	{
		symbol[0][0] = placeholder;
	}
	
	private void fillSquareTwo(char placeholder)
	{
		symbol[0][1] = placeholder;
	}
	
	private void fillSquareThree(char placeholder)
	{
		symbol[0][2] = placeholder;
	}
	
	private void fillSquareFour(char placeholder)
	{
		symbol[1][0] = placeholder;
	}
	
	private void fillSquareFive(char placeholder)
	{
		symbol[1][1] = placeholder;
	}
	
	private void fillSquareSix(char placeholder)
	{
		symbol[1][2] = placeholder;
	}
	
	private void fillSquareSeven(char placeholder)
	{
		symbol[2][0] = placeholder;
	}
	
	private void fillSquareEight(char placeholder)
	{
		symbol[2][1] = placeholder;
	}
	
	private void fillSquareNine(char placeholder)
	{
		symbol[2][2] = placeholder;
	}
	
	public static void resetBoard()
	{
		for(int i = 0; i < symbol.length; i++)
		{
			for(int j = 0; j < symbol[i].length; j++)
			{
				symbol[i][j] = '-';
			}
		}
	}
	
	public void printBoard()
	{
		for(int i = 0; i < symbol.length; i++)
		{
			for(int j = 0; j < symbol[i].length; j++)
			{
				System.out.print(symbol[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
	}
	
	public boolean checkDraw()
	{
		int counter = 0;
		for(int i = 0; i < symbol.length; i++)
		{
			for(int j = 0; j < symbol[i].length; j++)
			{
				if(symbol[i][j] != '-')
					counter ++;
			}
		}
		
		if(counter == 9)
			return true;
		else
			return false;
	}
	
	public boolean checkWin(Player player)
	{
		char placeholder = player.getPlaceholder();
		
		if (symbol[0][0] == placeholder && symbol[0][1] == placeholder && symbol[0][2] == placeholder)
			return true;
				
		else if (symbol[1][0] == placeholder && symbol[1][1] == placeholder && symbol[1][2] == placeholder)
			return true;
				
		else if (symbol[2][0] == placeholder && symbol[2][1] == placeholder && symbol[2][2] == placeholder)
			return true;
				
		else if (symbol[0][0] == placeholder && symbol[1][0] == placeholder && symbol[2][0] == placeholder) 
			return true;
				
		else if (symbol[0][1] == placeholder && symbol[1][1] == placeholder && symbol[2][1] == placeholder)
			return true;			

		else if (symbol[0][2] == placeholder && symbol[1][2] == placeholder && symbol[2][2] == placeholder)
			return true;

		else if (symbol[0][0] == placeholder && symbol[1][1] == placeholder && symbol[2][2] == placeholder) 
			return true;

		else if (symbol[0][2] == placeholder && symbol[1][1] == placeholder && symbol[2][0] == placeholder) 
			return true;
			
		else
			return false;
		
	}
		
	public boolean makeMove(int move, Player player)
	{
		switch(move)
		{
			case 1:
				if(symbol[0][0] == '-')
				{
					fillSquareOne(player.getPlaceholder());
					return true;
				}
				else
					return false;
				
				
			case 2:
				if(symbol[0][1] == '-')
				{
					fillSquareTwo(player.getPlaceholder());
					return true;
				}
				else
					return false;
				
				
			case 3:
				if(symbol[0][2] == '-')
				{
					fillSquareThree(player.getPlaceholder());
					return true;
				}
				else
					return false;
			
				
			case 4:
				if(symbol[1][0] == '-')
				{
					fillSquareFour(player.getPlaceholder());
					return true;
				}
				else
					return false;
			
				
			case 5:
				if(symbol[1][1] == '-')
				{
					fillSquareFive(player.getPlaceholder());
					return true;
				}
				else
					return false;
			
				
			case 6:
				if(symbol[1][2] == '-')
				{
					fillSquareSix(player.getPlaceholder());
					return true;
				}
				else
					return false;
	
				
			case 7:
				if(symbol[2][0] == '-')
				{
					fillSquareSeven(player.getPlaceholder());
					return true;
				}
				else
					return false;
			
				
			case 8:
				if(symbol[2][1] == '-')
				{
					fillSquareEight(player.getPlaceholder());
					return true;
				}
				else
					return false;
	
				
			case 9:
				if(symbol[2][2] == '-')
				{
					fillSquareNine(player.getPlaceholder());
					return true;
				}
				else
					return false;

			
			default:
				return false;
		}
	}

}


class Player
{
	private boolean move;
	private char placeholder;
	private String name;

	
	public Player ()
	{
		
	}
	
	public Player(String name,char placeholder, boolean move)
	{
		this.move = move;
		this.placeholder = placeholder;
		this.name = name;
	}
	
	public Player(Player copy)
	{
		this(copy.name, copy.placeholder, copy.move);
	}
	
	public void setInfo(String name,char placeholder, boolean move)
	{
		this.move = move;
		this.placeholder = placeholder;
		this.name = name;
	}
	
	public void setMove(boolean move)
	{
		this.move = move;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPlaceholder(char placeholder)
	{
		this.placeholder = placeholder;
	}
	
	public String getName()
	{
		return name;
	}
	
	public char getPlaceholder()
	{
		return placeholder;
	}
	
	public boolean getMove()
	{
		return move;
	}
	
}