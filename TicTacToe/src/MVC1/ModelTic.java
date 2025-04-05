package MVC1;

public class ModelTic {

	private char[][] board;
	private char Player;
	static int i = 0;
	public ModelTic()
	{
		board = new char[3][3];
		Player = 'X';
	}
	public boolean Move(int col , int row)  
	{
		
		if(board[row][col] =='\0')
		{
			board[row][col] =Player;
			return true;
		}
		
			return false;
		
		
	}
	public void Switchplayer()
	{
		if(Player =='X') Player ='O';
		else
			Player='X';
			
	}
	public boolean checkWin()
	{
		for(int i = 0 ; i < 3 ; i++)
		{
			if(board[0][i]==Player &&board[1][i]==Player &&board[2][i]==Player) return true;
			if(board[i][0]==Player && board[i][1]==Player &&board[i][2]==Player) return true;
		}
		if(board[0][0]==Player && board[1][1]==Player && board[2][2]==Player) return true;
		if(board[0][2]==Player && board[1][1]==Player && board[2][0]==Player) return true;
		i++;
		return false;
	}
	public char getPlayer() {
		return Player;
	}
	
	public void resetGame()
	{
		board = new char[3][3];
		Player = 'X';
	}
	
	
}
