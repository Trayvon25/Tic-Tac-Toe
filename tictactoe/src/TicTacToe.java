import java.util.*;

public class TicTacToe {
    static Scanner input;
    static String[] board;
    static String turn;
    static boolean letsPlay = true;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
      // populateEmptyBoard();

        System.out.println("Welcome to Tic Tac Toe.");
        System.out.println("--------------------------------");
       printBoard();
        System.out.println("X's will play first. Enter a slot number to place X in:");

        //while(letsPlay) {
            while (winner == null) {
                int numInput = input.nextInt();
                if (board[numInput-1].equals(String.valueOf(numInput))) {
                    board[numInput-1] = turn;
                    if (turn.equals("X")) {
                        turn = "O";
                    } else {
                        turn = "X";
                    }
                    printBoard();
                    winner = checkWinner();
                } else {
                    System.out.println("Slot already taken; re-enter slot number:");
                    continue;
                }
            }
            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("It's a draw! Thanks for playing.");
            } else {
                System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
            }
        }

        static String checkWinner() {
            for (int a = 0; a < 8; a++) {
                String line = null;
                switch (a) {
                    case 0:
                        line = board[0] + board[1] + board[2];
                        break;
                    case 1:
                        line = board[3] + board[4] + board[5];
                        break;
                    case 2:
                        line = board[6] + board[7] + board[8];
                        break;
                    case 3:
                        line = board[0] + board[3] + board[6];
                        break;
                    case 4:
                        line = board[1] + board[4] + board[7];
                        break;
                    case 5:
                        line = board[2] + board[5] + board[8];
                        break;
                    case 6:
                        line = board[0] + board[4] + board[8];
                        break;
                    case 7:
                        line = board[2] + board[4] + board[6];
                        break;
                }
                if (line.equals("XXX")) {
                    return "X";
                } else if (line.equals("OOO")) {
                    return "O";
                }
            }

            for (int a = 0; a < 9; a++) {
                if (Arrays.asList(board).contains(String.valueOf(a+1))) {
                    break;
                }
                else if (a == 8) return "draw";
            }

            System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
            return null;
        }

        static void printBoard() {
            System.out.println("-------------");
            System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
            System.out.println("|-----------|");
            System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
            System.out.println("|-----------|");
            System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
            System.out.println("-------------");
        }
/*
     System.out.print("Game Over!");
        System.out.println("would you like to play again? Yes or No");
        String playAgain  =input.next();
        if(playAgain == ("No")){
            letsPlay = false;
        } */
    }

