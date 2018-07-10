import java.util.*;

public class Oxo {
	Game game = new Game();
	Scanner scanner = new Scanner(System.in);
	Scanner scannertwo = new Scanner(System.in);

	Board check = new Board();
	Test test = new Test();

	public static void main(String[] args) {
		Oxo program = new Oxo();
		program.run(args);
	}

	void run(String[] args){

			if(args.length == 0){
				test();
			}

			if (scanner != null) {
				System.out.println("Hiya, welcome to Noughts and Crosses!");
				System.out.println("Do you want to play a game of tic tac toe? Y/N?");
				String startGame = scanner.nextLine();
					if(check.startGame(startGame)){

						System.out.println("Do you want to play against the computer? Y/N?");
						String b = scannertwo.nextLine();


							System.out.println("Player X to start, enter input as column row (e.g a1,b2)");
							check.printBoard();
							while(!game.isDraw() && !game.isDiagWin()){
								String playerInput = scanner.nextLine();

									game.makeMove(playerInput, b);

						}

							if(game.isDiagWin()){
								System.out.println(" Current player has won!!!!!!!");
							}
							else if(game.isDraw()){
								System.out.println("Its a draw!!!!!!");
							}
				}
				else{
					System.out.println("Ok thank you! Come  again!");
				}


		}
	}


	void test(){
		test.testValidity();
		test.testPosition();
		test.testValidMove();
		test.testInit();
	}
}
