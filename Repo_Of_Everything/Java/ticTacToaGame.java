
import java.util.Scanner;

public class ticTacToaGame {

    public static void main(String[] args) {

        char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int[] nums = new int[9];
        boolean check = true;
        char choice;
        int num, round = 1;

        Scanner input = new Scanner(System.in);

        System.out.print("Who is first? Enter choice A or B?:- ");
        choice = input.next().toUpperCase().charAt(0);
        display(board);
        System.out.print("Player " + choice + " it is your turn: ");

        while (check) {
            num = input.nextByte();
            if (num < 1 || num > 9) {
                System.out.print("Incorrect input!try Again: ");
                continue;
            }
            if (board[num - 1] == 'X' || board[num - 1] == 'O') {
                System.out.print("You entered to an already occupied space!Try again: ");
                continue;

            } else {
                nums[num - 1] = num;
                if (choice == 'A') {
                    board[num - 1] = 'X';
                    display(board);

                    if (round >= 5) {
                        if (checkResult(board, choice) == 'A') {
                            System.out.print("Congrationalations player A has won the Game!");

                            break;
                        }
                    }
                    if (round == 9) {
                        System.out.println("Neither of you have won play again!");
                        break;
                    }
                    choice = 'B';
                    System.out.print("\nPlayer B's turn: ");

                } else if (choice == 'B') {
                    board[num - 1] = 'O';

                    display(board);
                    if (round >= 5) {
                        if (checkResult(board, choice) == 'B') {
                            System.out.print("Congrationalations player B has won the Game!");

                            break;
                        }
                    }
                    if (round == 9) {
                        System.out.println("Neither of you have won play again!");
                        break;
                    }
                    choice = 'A';
                    System.out.print("\nPlayer A's turn: ");

                } else {
                    System.out.print("Invalid input! try again!");
                }

                round++;
            }
        }
    }

    //method for printing the board
    static void display(char[] board) {
        for (int i = 0; i < 6; i++) {
            System.out.print("__");
        }
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            if (i % 3 == 2) {
                System.out.println(board[i] + "| ");
            } else {
                System.out.print(board[i] + " ");

            }

        }
        for (int i = 0; i < 6; i++) {
            System.out.print("--");
        }
        System.out.println();
    }

    static char checkResult(char[] board, char player) {

        if ((board[0] == board[1] && board[1] == board[2]) || (board[0] == board[3] && board[3] == board[6]) || (board[0] == board[4] && board[4] == board[8]) || (board[1] == board[4] && board[4] == board[7]) || (board[2] == board[5] && board[5] == board[8]) || (board[3] == board[4] && board[4] == board[5]) || (board[6] == board[7] && board[7] == board[8]) || (board[2] == board[4] && board[4] == board[6])) {
            return player;
        }

        return '0';

    }
}
