
import java.util.*;

public class tictactoe {
	// Initialize all of my variables for player input and array
    public static Scanner sc = new Scanner(System.in);
    public static char[][] gameBoard = new char[3][3];
    public static int x = 0, y = 0;
    public static char player = 'X';
    public static void main (String []args) {
    	
        boolean play = true;
        int moveNumber = 0;
        // While loop to check for boolean to continue playing
        while (play) {
            // Count each move made in game
        	moveNumber++;
            // Print game board using the array created
        	myBoard(gameBoard);
            // Grab user input for row
            inputRow();
            // Grab user input for column
            inputColumn();
            
            // While loop to check for a used element position
            while(gameBoard[x][y]=='X' || gameBoard[x][y]=='O'){
                System.out.println("This space is taken.....try again!");
                inputRow();
                inputColumn();
            }
            gameBoard[x][y] = player;
            
            //Check for win
            if (winChecker()){
                play = false;
                System.out.println("Gameover! Player " + player + " wins!");
            }
            
            //Statement to change players.
            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }
            
            //Check for draw by using a move counter and the max number of moves
            if (moveNumber >= 9){
                System.out.println("You both suck");
                break;
            }
        }

    }
    // Get player input for the row
    public static void inputRow(){
        System.out.print("Enter row for " + player + ": ");
        x = sc.nextInt();
    }
    // Get player input for the column
    public static void inputColumn(){
        System.out.print("Enter column for " + player + ": ");
        y = sc.nextInt();
    }
    // Method to create game board
    public static void myBoard(char[][]x) {
    	System.out.println("-------------");
    	
    	for (int i = 0; i < 3; i++) { 
    		System.out.print("| ");
    		for (int j = 0; j < 3; j++) {
    			System.out.print(gameBoard[i][j] + " | ");
    			
    		}
    		System.out.println();
    		System.out.println("-------------");
    	}
    }
    // Check board for wins
    public static boolean winChecker(){
        //check horizontal
        if(gameBoard[0][0] == player && gameBoard[0][1] == player && gameBoard[0][2] == player)
            return true;
        if(gameBoard[1][0] == player && gameBoard[1][1] == player && gameBoard[1][2] == player)
            return true;
        if(gameBoard[2][0] == player && gameBoard[2][1] == player && gameBoard[2][2] == player)
            return true;
        //check vertical
        if(gameBoard[0][0] == player && gameBoard[1][0] == player && gameBoard[2][0] == player)
            return true;
        if(gameBoard[0][1] == player && gameBoard[1][1] == player && gameBoard[2][1] == player)
            return true;
        if(gameBoard[0][2] == player && gameBoard[1][2] == player && gameBoard[2][2] == player)
            return true;
        //check diagonal
        if(gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player)
            return true;
        if (gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player)
            return true;
        return false;

    }

}