Design report

Tic Tac Toe is coded in the JAVA language and runs on Spark.
Tic Tac Toe has three classes: Game, Board and Player.
Below are the classes with it´s functions and main variables .


Game
private Board b;
private int movesLeft;
private Player player1;
private Player player2;

public Game()
public boolean playTurn()
public boolean isWinner()
public boolean gameOver()
public char[] getBoard()
public int getMovesLeft()
public String drawBoard()


Board

private char[] board;
private final int sizeOfBoard = 9;
public Board()
private void setBoard()
public char[] getBoard()
public boolean isWinner()
public boolean isGameOver()
public String toString()
public char getField()
public boolean setField()
public boolean isFieldEmpty()

Player

private boolean myTurn;
private char mySymbol;
public Player()
public char getSymbol()
