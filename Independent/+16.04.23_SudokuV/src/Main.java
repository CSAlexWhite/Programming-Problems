/**
 * started April 23, 2016
 * completed April 23, 2016
 *
 * Write code to verify a Sudoku board
 */

import java.util.HashSet;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        int[][] board = new int[9][]; // we have a board here
        for(int i=0; i<9; i++) board[i] = new int[9];

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<9; i++){

            for(int j=0; j<9; j++){
                board[i][j] = sc.nextInt();
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println(verify(board));
    }

    public static boolean verify(int[][] board){

        assert board.length == 9 : "wrong size board";
        for(int i=0; i<9; i++) assert board[i].length == 9 : "wrong size board";

        HashSet<Integer> subset;

        for(int i=0; i<9; i++){

            subset = new HashSet<>();
            for(int j=0; j<9; j++)          // build
                subset.add(board[i][j]);

            for(int j=1; j<10; j++)         // verify
                if(!subset.contains(j))
                    return false;
        }

        for(int i=0; i<9; i++){

            subset = new HashSet<>();
            for(int j=0; j<9; j++)          // build
                subset.add(board[j][i]);

            for(int j=1; j<10; j++)         // verify
                if(!subset.contains(j))
                    return false;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                subset = new HashSet<>();
                for(int k=0; k<3; k++){     // build
                    for(int l=0; l<3; l++)
                        subset.add(board[k+i*3][l+j*3]);
                }

                for(int k=1; k<10; k++)     // verify
                    if(!subset.contains(k))
                        return false;
            }
        }

        return true;
    }
}

/**
 * TEST SET

 2 5 6 4 8 9 1 7 3
 3 7 4 6 1 5 9 8 2
 9 8 1 7 2 3 4 5 6
 5 9 3 2 7 4 8 6 1
 7 1 2 8 3 6 5 4 9
 4 6 8 5 9 1 3 2 7
 6 3 5 1 4 7 2 9 8
 1 2 7 9 5 8 6 3 4
 8 4 9 3 6 2 7 1 5

 */