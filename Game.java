import java.util.*;


class Game {

	private boolean isDiagWin;
	private boolean isDraw;
	private boolean isComputer;

	private PlayerType playerTurn;
	private Board gameBoard;
	private String[][] boardCopy = new String[4][4];
	Random rand = new Random();

	public Game() {
		this.playerTurn = PlayerType.X;
		this.gameBoard = new Board();
		this.isDiagWin = false;
		this.isDraw = false;
		this.isComputer = false;
	}

	boolean isDraw(){
		if(gameBoard.checkDraw() == true){
			return true;
		}
		else{
		return false;
	}
	}

	boolean isDiagWin(){
		if(gameBoard.checkDiag() || gameBoard.checkRCWin()){
			return true;
		}
		else{
			return false;
		}
	}

	boolean isComputer(String b){

		if(gameBoard.computerGame(b) == true){
			return true;
		}
		else{
			return false;
		}
	}

	public void makeMove(String moveCoordinates, String b) {

		if(gameBoard.validCheck(moveCoordinates)){

			int q=2;
			int r=2;
			int x =(int)(moveCoordinates.charAt(0) -97);
			int y = (int)(moveCoordinates.charAt(1) - 49);

			if(gameBoard.validMove(x,y)){
				gameBoard.updatePosition(x +1, y +1, playerTurn.name());
				gameBoard.printBoard();
				changePlayer();

				if(isComputer(b)&& !isDiagWin()){
					while(!gameBoard.validMove(q,r)){
						q = rand.nextInt()%2+1;
						r = rand.nextInt()%2+1;
					}
					gameBoard.updatePosition(q+1, r+1, "O");
					gameBoard.printBoard();
					changePlayer();
				}
			}
			else{
				System.out.print("Sorry position already taken, try again:\n");
			}
		}
		else{
			System.out.print("Sorry an invalid format was entered, try again:\n");
		}

	}

	public void changePlayer() {

		PlayerType nextPlayer;

		if (this.playerTurn == PlayerType.X) {
			nextPlayer = PlayerType.O;
		}
		else {
			nextPlayer = PlayerType.X;
		}

		if(isDraw() == false && isDiagWin() == false){
			System.out.println("\n Player " + nextPlayer.name() + ",make your move!:");
			this.playerTurn = nextPlayer;
		}
	}

}

enum PlayerType {
	X, O
}
