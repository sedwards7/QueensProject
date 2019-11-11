//Author: Sean Edwards
//Project: Queens Simulation

import java.util.Scanner;

public class QueenSimulation
{
    public static void main (String[] args)
    {
        int boardSize, row, column, solutions;
        Scanner scan = new Scanner(System.in);
        LinkedStack<Queen> queens = new LinkedStack<>();
        boolean moreSolutions = true;

        System.out.print("Please enter the size of the Board: ");
        boardSize = scan.nextInt();

        row = 1;
        column = 1;
        solutions = 0;

        //adds the starting queen
        queens.push(new Queen(row, column, boardSize));
        row++;

        //loops until we reach the last node to be checked
        while(moreSolutions)
        {

            while (queens.size() < boardSize && moreSolutions)
            {
                Queen temporary = new Queen(row, column, boardSize);
                if (conflictWithAllQueens(temporary, queens) || column > boardSize)
                {
                    //determines if this is the last node that could have been checked
                    if ((queens.peek().getRow() == 1 && queens.peek().getColumn() == boardSize))
                        moreSolutions = false;
                    //checks if this was the last queen of the row
                    else if (column >= boardSize)
                    {
                        column = queens.peek().getColumn();
                        queens.pop();
                        row--;
                    }
                    column++;
                } else //if there are no conflicts push the queen onto the stack
                {
                    queens.push(temporary);
                    row++;//move on to the next row
                    column = 1;//back to the first column
                }
            }
            //ensures there are still solutions left before we reset
            if(!(queens.peek().getRow() == 1 && queens.peek().getColumn() == boardSize))
            {
                printQueens(queens);
                System.out.println("Solution found!");
                column = queens.peek().getColumn() + 1;//moves column to the next space
                queens.pop();
                row--;//row on the last row
                solutions++;
            }
            else{
                moreSolutions = false;//ends the loop if we run into it here somehow
            }
        }
        System.out.println("Number of solutions: " + solutions);

    }
    //checks conflict with all queens on the stack
    private static boolean conflictWithAllQueens(Queen check, LinkedStack<Queen> qs){
        boolean answer = false;
        for (int i = 0; i < qs.size(); i ++){
            if(check.conflict(qs.itemAt(i)))
                answer = true;
        }
        return answer;
    }
    //prints info for all queens on the stack
    private static void printQueens(LinkedStack<Queen> qs){
        int count = 1;
        for(int i = qs.size()-1; i >= 0; i--){
           System.out.print("Queen " + (count) + ": " + qs.itemAt(i).toString() + " ");
           System.out.println();
           count++;
        }
    }
}
