//Author: Sean Edwards
//Projects:Queens Simulation

public class Queen
{
    /**
     * Invariant of the Queen class:
     *  1. The row and column of the Queen must be a location on the board.
     *  2.  The board size must be larger than 3 in order to solve the problem
     *      for this project
     */
    private int row, column, n;

    /**
     * Sets Queen to row 1, column 1 by default
     * Sets board size to 4
     */
    public Queen(){
        row = 1;
        column = 1;
        n = 4;
    }

    /**
     *
     * @param r -row
     * @param c -column
     * @param boardSize -board size is n*n
     */
    public Queen(int r, int c, int boardSize){
        row = r;
        column = c;
        n = boardSize;
    }

    /**
     * Gets the row
     * @return -row number
     */
    public int getRow(){
        return row;
    }

    /**
     * Gets the column
     * @return -column number
     */
    public int getColumn(){
        return column;
    }

    /**
     * Sets the row
     * @param r
     */
    public void setRow(int r){
        row = r;
    }

    /**
     * Sets the column
     * @param c
     */
    public void setColumn(int c){
        column = c;
    }

    public void setBoth(int r, int c){
        row = r;
        column = c;
    }

    /**
     * Determines if there is a conflict with another Queen
     * -checks if the Queen is in the same row and column in this method
     * -uses separate method to check diagonal
     * @param con -Queen that is to be checked
     * @return -boolean returning true if there IS a conflict
     */
    public boolean conflict(Queen con){
        int x = this.row;
        int y = this.column;
        //check if they have same row or column or if they have a diagonal conflict
        if (x == con.getRow() || y == con.getColumn() || checkDiagConflict(con))
            return true;
        else
            return false;

    }

    /**
     * Determines if there is a diagonal conflict with another Queen
     * @param check -Queen to be checked
     * @return -boolean returning true if there IS a conflict
     */
    public boolean checkDiagConflict(Queen check){
        int x = this.row;
        int y = this.column;
        boolean answer = false;

        // check left diagonal
        while (x <= n && y <= n && x >= 1 && y >= 1){
            if (check.getRow() == x && check.getColumn() == y)
                answer = true;
            //check diagonal space to the left
            x--;
            y--;
        }
        x = this.row;
        y = this.column;
        //check right diagonal
        while (x <= n && y <= n && x >= 1 && y >= 1){
            if (check.getRow() == x && check.getColumn() == y)
                answer = true;
            //check diagonal space to the right
            x--;
            y++;
        }
        return answer;
    }

    /**
     * @return -output of data in string form
     */
    @Override
    public String toString(){

        return "Row= " + row + ", Column= " + column;
    }
}
