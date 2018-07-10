import java.io.*;

class Board {

	private String[][] board;
	
	public Board() {

		this.board = new String[][] {
			{"-", "1", "2", "3"},
			{"a", " ", " ", " "},
			{"b", " ", " ", " "},
			{"c", " ", " ", " "}
		};
	}

	public void updatePosition(int x, int y, String value) {
		this.board[x][y] = value;
	}

	public void initializeBoard() {
		for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
						this.board[i+1][j+1] = " ";
				}
		}
	}

	public void printBoard() {
		String[][] board = this.board;
		System.out.println();
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (x == board[y].length - 1) {
					System.out.println(board[x][y]);
				}
				else {
					System.out.print(board[x][y] + "|");
				}
			}
		}
	}

	public boolean validMove(int x, int y){
		if(board[x+1][y+1] == " "){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean checkDraw(){
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if(board[x][y] == " " && !checkRCWin() && !checkDiag()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkThree(String a, String b, String c){
		if(a == "X" || a == "O"){
			if(a == b && b == c){
				return true;
			}
		}
		else{
			return false;
		}
		return false;
	}

		public boolean checkRCWin(){
			for (int y = 0; y < board.length; y++) {
				if(checkThree(board[1][1],board[1][2],board[1][3])){
					return true;
				}
				if(checkThree(board[2][1],board[2][2],board[2][3])){
					return true;
				}
				if(checkThree(board[3][1],board[3][2],board[3][3])){
					return true;
				}
				for (int x = 0; x < board[y].length; x++) {
					if(checkThree(board[1][1],board[2][1],board[3][1])){
						return true;
					}
					if(checkThree(board[1][2],board[2][2],board[3][2])){
						return true;
					}
					if(checkThree(board[1][3],board[2][3],board[3][3])){
						return true;
					}

			}
		}
		return false;
		}

	public boolean checkDiag(){
		if(board[1][1] == "X" && board[2][2] == "X" && board[3][3] == "X"){
			return true;
		}
		if(board[3][1] == "X" && board[2][2] == "X" && board[1][3] == "X"){
			return true;
		}
		if(board[1][1] == "O" && board[2][2] == "O" && board[3][3] == "O"){
			return true;
		}
		if(board[3][1] == "O" && board[2][2] == "O" && board[1][3] == "O"){
			return true;
		}
	 	return false;
	}

	public boolean validCheck(String s){

		if(s.matches("a1") || s.matches("a2") ||
			 s.matches("a3") || s.matches("b1") ||
			 s.matches("b2") || s.matches("b3") ||
			 s.matches("c1") || s.matches("c2") ||
			 s.matches("c3")){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean startGame(String s){
		if(s.matches("Y") || s.matches("Yes")){
			return true;
		}
		else{
			if(s.matches("N") || s.matches("No"))
				return false;
		}
		return false;
	}

	public boolean computerGame(String a){
		if(a.matches("Y") || a.matches("Yes")){
			return true;
		}
		else{
			if(a.matches("N") || a.matches("No"))
				return false;
		}
		return false;
		}
	 }
