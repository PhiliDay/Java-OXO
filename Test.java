import java.util.*;


class Test
{

  Board boardTest = new Board();
  Game gameTest = new Game();
  Scanner in = new Scanner(System.in);
  private int testNumber = 1;


void claim(boolean b){
  if(!b) throw new Error("Test " + testNumber + "fails");
  testNumber++;
}

void testValidity(){

  //Tests 1-7: Check input is correct
  claim(boardTest.validCheck("a1") == true);
  claim(boardTest.validCheck("a2") == true);
  claim(boardTest.validCheck("c3") == true);
  claim(boardTest.validCheck("c4") == false);
  claim(boardTest.validCheck("1a") == false);
  claim(boardTest.validCheck("nonsense") == false);
  claim(boardTest.validCheck("A1") == false);

  //Tests 8-13 :Check that you can only win with three X's or O's in a row
  claim(boardTest.checkThree("X", "X", "X") == true);
  claim(boardTest.checkThree("O", "O", "O") == true);
  claim(boardTest.checkThree("X", "O", "X") == false);
  claim(boardTest.checkThree("X", "x", "X") == false);
  claim(boardTest.checkThree("1", "1", "1") == false);
  claim(boardTest.checkThree("x", "x", "x") == false);

  //Tests 14 - 18: Entry to start game is correct
  claim(boardTest.startGame("Y") == true);
  claim(boardTest.startGame("Yes") == true);
  claim(boardTest.startGame("No") == false);
  claim(boardTest.startGame("N") == false);
  claim(boardTest.startGame("yep") == false);


}

void testPosition(){

  //Test 19: Win if column has three in a row
  boardTest.initializeBoard();
  boardTest.updatePosition(1, 1, "X");
  boardTest.updatePosition(1, 2, "X");
  boardTest.updatePosition(1, 3, "X");
  claim(boardTest.checkRCWin() == true);

  //Test 20: Win if row has three in a row
  boardTest.initializeBoard();
  boardTest.updatePosition(1, 1, "O");
  boardTest.updatePosition(2, 1, "O");
  boardTest.updatePosition(3, 1, "O");
  claim(boardTest.checkRCWin() == true);

  //Test 21: Win if diagonal has three in a row
  boardTest.initializeBoard();
  boardTest.updatePosition(1, 1, "X");
  boardTest.updatePosition(2, 2, "X");
  boardTest.updatePosition(3, 3, "X");
  claim(boardTest.checkDiag() == true);

  //Tests 22-24: A draw if all cells are occupied and no win
  boardTest.initializeBoard();
  boardTest.updatePosition(1, 1, "X");
  boardTest.updatePosition(1, 2, "O");
  boardTest.updatePosition(1, 3, "X");
  boardTest.updatePosition(2, 1, "O");
  boardTest.updatePosition(2, 2, "X");
  boardTest.updatePosition(2, 3, "O");
  boardTest.updatePosition(3, 1, "O");
  boardTest.updatePosition(3, 2, "X");
  boardTest.updatePosition(3, 3, "O");
  claim(boardTest.checkDiag() == false);
  claim(boardTest.checkRCWin() == false);
  claim(boardTest.checkDraw() == true);

  //Tests 25-27: Checks three in a row
  boardTest.initializeBoard();
  claim(boardTest.checkThree("O", "X", "O") == false);
  claim(boardTest.checkThree("X", "X", "X") == true);
  claim(boardTest.checkThree("O", "O", "O") == true);

}

void testValidMove(){

  //Tests 28-31: to see if you can put a value where there is a current value
  boardTest.initializeBoard();
  boardTest.updatePosition(1, 2, "X");
  boardTest.updatePosition(2, 3, "O");

  claim(boardTest.validMove(0, 0) == true);
  claim(boardTest.validMove(1, 1) == true);

  boardTest.initializeBoard();
  boardTest.updatePosition(1, 1, "X");
  boardTest.updatePosition(2, 2, "O");
  claim(boardTest.validMove(0, 0) == false);
  claim(boardTest.validMove(1, 1) == false);

}

void testInit(){

  //Tests 32-40: to see whether the board has any value within the cells
  boardTest.initializeBoard();
  claim(boardTest.validMove(0,0) == true);
  claim(boardTest.validMove(0,1) == true);
  claim(boardTest.validMove(0,2) == true);
  claim(boardTest.validMove(1,0) == true);
  claim(boardTest.validMove(1,1) == true);
  claim(boardTest.validMove(1,2) == true);
  claim(boardTest.validMove(2,0) == true);
  claim(boardTest.validMove(2,1) == true);
  claim(boardTest.validMove(2,2) == true);

}

}
