import java.util.Scanner;

public class TicTacToe {
    public static char arr[][] = new char[4][4];
    //public static boolean gameCon = false;
    public static boolean checkWin(){
        for (int i=1; i<=3; i++){
            for(int j=1; j<=3; j++) {
                //CHECK ROWS
                if(arr[i][1] != '-' && arr[i][1] == arr[i][2] && arr[i][2] == arr[i][3]) {
                    return true;
                }
                //CHECK COLUMNS
                if(arr[1][j] != '-' && arr[1][j] == arr[2][j] && arr[2][j] == arr[3][j]) {
                    return true;
                }
                //CHECK DIAGNOLS
                if(arr[1][1] != '-' && arr[1][1] == arr[2][2] && arr[2][2] == arr[3][3]) {
                    return true;
                }
                if(arr[1][3] != '-' && arr[1][3] == arr[2][2] && arr[2][2] == arr[3][1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDraw() {
        for (int i=1; i<=3; i++) {
            for (int j=1; j<=3; j++) {
                if(arr[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void intitializeBoard() {
    for (int i=1; i<=3; i++) {
        for (int j=1; j<=3; j++) {
            arr[i][j] = '-';
            }
        }
    }
    
    public static void printBoard() {
        System.out.println("  1   2   3");
        for (int i=1; i<=3; i++) {
            System.out.print(i+" ");            
            for (int j=1; j<=3; j++) {                
                System.out.print(arr[i][j] + "   ");
            }
            
            System.out.println();
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            intitializeBoard();
            System.out.println();
            printBoard();
            System.out.println();
            char currentPlayer = 'X';
            boolean gameCon = false;
            
            while (!gameCon) {
                System.out.println("Player " + currentPlayer + " to move");
                System.out.print("Enter Row: ");
                int row = sc.nextInt();

                System.out.print("Enter Column: ");
                int col = sc.nextInt();
                System.out.println();

                if ((row >0 && row<=3) && (col >0 && col<=3)) {
                    arr[row][col] = currentPlayer;
                    printBoard();
                    if(checkWin()) {
                        System.out.println(currentPlayer + " Wins!");
                        gameCon = true;
                        // return;                  
                    }
                    if(checkDraw()) {
                        System.out.println("Game Draw!");
                        gameCon = true;
                        // return;
                    }
                    else if (currentPlayer == 'X') {
                        currentPlayer = 'O';
                    } else {
                        currentPlayer = 'X';
                    }
                } else {
                    System.out.println("Invalid move!");
                    System.out.println();
                }
            }
            System.out.println();
            System.out.print("Want to play again (Y/N): ");
            choice = sc.next();
        } while (choice.toUpperCase().equals("Y"));
    }
}    


