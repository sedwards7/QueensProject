import java.util.Scanner;

public class QueenSimulation
{
    public static void main (String[] args)
    {
        int boardSize, row, column, solutions;
        Scanner scan = new Scanner(System.in);
        LinkedStack<Queen> queens = new LinkedStack<>();
        Queen checkLastPopped;
        boolean moreSolutions = true;

        System.out.print("Please enter the size of the Board: ");
        boardSize = scan.nextInt();

        row = 1;
        column = 1;
        solutions = 0;


        queens.push(new Queen(row, column, boardSize));
        row++;


        while(moreSolutions)
        {
            while (queens.size() < boardSize && moreSolutions)
            {
                Queen temporary = new Queen(row, column, boardSize);
                if (conflictWithAllQueens(temporary, queens) || column > boardSize)
                {
                    if ((queens.peek().getRow() == 1 && queens.peek().getColumn() == boardSize))
                        moreSolutions = false;
                    else if (column >= boardSize)
                    {
                        column = queens.peek().getColumn();
                        queens.pop();
                        row--;
                    }
                    column++;
                } else
                {
                    queens.push(temporary);
                    row++;
                    column = 1;
                }
            }

            if(!(queens.peek().getRow() == 1 && queens.peek().getColumn() == boardSize))
            {
                printQueens(queens);
                System.out.println("Solution found!");
                column = queens.peek().getColumn() + 1;
                queens.pop();
                row--;
                solutions++;
            }
            else{
                moreSolutions = false;
            }
        }
        System.out.println("Number of solutions: " + solutions);

    }

    public static boolean conflictWithAllQueens(Queen check, LinkedStack<Queen> qs){
        boolean answer = false;
        for (int i = 0; i < qs.size(); i ++){
            if(check.conflict(qs.itemAt(i)))
                answer = true;
        }
        return answer;
    }

    public static void printQueens(LinkedStack<Queen> qs){
        int count = 1;
        for(int i = qs.size()-1; i >= 0; i--){
           System.out.print("Queen " + (count) + ": " + qs.itemAt(i).toString() + " ");
           System.out.println();
           count++;
        }
    }
}
