import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {

        boolean appRunning = true;
        boolean inGame = false;
        try (Scanner scanner = new Scanner(System.in)) {
            while (appRunning) {
                System.out.print("Input command: ");
                String command = scanner.nextLine();
                String mode = "";
                String player1 = "";
                String player2 = "";
                // use the split function split function basically split the input and store
                // them in arrays (the user have to input command between given cases below)
                if (command.split(" ").length == 1)
                    mode = command.split(" ")[0];
                if (command.split(" ").length == 3) {
                    mode = command.split(" ")[0];
                    player1 = command.split(" ")[1];
                    player2 = command.split(" ")[2];
                }
                
                // bad input function check wheather the input is valid or not.//if the user
                // enters any string
                // other than easy medium hard and user it will print that the input is a bad
                // parameters
                boolean badInput = false;
                switch (mode) {
                    case "start":
                        inGame = true;
                        for (String player : new String[] { player1, player2 }) {
                            // analyze players
                            switch (player) {
                                    // three levels of game
                                case "easy":
                                case "medium":
                                case "hard":
                                case "user":
                                    inGame = true;
                                    break;
                                default:
                                    badInput = true;
                                    inGame = false;
                            }
                        }
                        break;
                    case "exit":
                        appRunning = false;
                        badInput = false;
                        break;
                    default:
                        badInput = true;
                        inGame = false;
                }
                if (badInput) {
                    System.out.println("Bad parameters! Give command again");
                    inGame = false;
                }

                // create matrix representation of the game board
                char[][] board = new char[3][3];
                for (char[] row : board) {
                    Arrays.fill(row, ' ');
                }
                // print the board at the present time
                if (inGame)
                    display(board);

                while (inGame) {
                    switch (player1) {
                        case "user":
                            playerMove(board, 1);
                            break;
                        case "easy":
                            easyMove(board, 1);
                            break;
                        case "medium":
                            mediumMove(board, 1);
                            break;
                        case "hard":
                            hardMove(board, 1);
                            break;
                    }
                    display(board);
                    inGame = gameState(board);
                    if (!inGame)
                        break;
                    switch (player2) {
                        case "user":
                            playerMove(board, 2);
                            break;
                        case "easy":
                            easyMove(board, 2);
                            break;
                        case "medium":
                            mediumMove(board, 2);
                            break;
                        case "hard":
                            hardMove(board, 2);
                            break;
                    }
                    display(board);
                    inGame = gameState(board);
                }
            }
        }

    }

    private static void playerMove(char[][] board, int player) {
        try (Scanner scanner = new Scanner(System.in)) {
            // player's move
            boolean validMove = false;
            int move1, move2;
            int index1, index2;

            while (!validMove) {
                System.out.print("Enter the coordinates: ");
                if (scanner.hasNextInt()) {
                    move1 = scanner.nextInt();
                } else {
                    scanner.nextLine();
                    System.out.println("You should enter numbers (Should be from 1-3)!");
                    continue;
                }
                if (scanner.hasNextInt()) {
                    move2 = scanner.nextInt();
                } else {
                    scanner.nextLine();
                    System.out.println("You should enter numbers (Should be from 1-3)!");
                    continue;
                }
            }
        }
    }

    private static boolean gameState(char[][] board) {
        return true;
    }

    private static void mediumMove(char[][] board, int player) {
    }

    private static void easyMove(char[][] board, int player) {
    }

    private static void hardMove(char[][] board, int player) {

    }

    private static void display(char[][] stato) {
        System.out.println("---------");
        System.out.println("| " + stato[0][0] + ' ' + stato[0][1] + ' ' + stato[0][2] + " |");
        System.out.println("| " + stato[1][0] + ' ' + stato[1][1] + ' ' + stato[1][2] + " |");
        System.out.println("| " + stato[2][0] + ' ' + stato[2][1] + ' ' + stato[2][2] + " |");
        System.out.println("---------");

    }

}
