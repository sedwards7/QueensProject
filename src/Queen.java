public class Queen
{
    private int row, column, n;

    //sets Queen at 1,1 by default
    public Queen(){
        row = 1;
        column = 1;
        n = 3;
    }

    public Queen(int r, int c, int boardSize){
        row = r;
        column = c;
        n = boardSize;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public void setRow(int r){
        row = r;
    }

    public void setColumn(int c){
        column = c;
    }

    public void setBoth(int r, int c){
        row = r;
        column = c;
    }

    public boolean conflict(Queen con){
        int x = this.row;
        int y = this.column;

        if (x == con.getRow() || y == con.getRow() || checkDiagConflict(con))
            return true;
        else
            return false;

    }

    public boolean checkDiagConflict(Queen con){
        int x = this.row;
        int y = this.column;
        boolean answer = false;

        // check left diagonal
        while (x <= n && y <= n && x >= 1 && y >= 1){
            if (con.getRow() == x && con.getColumn() == y)
                answer = true;
            //check diagonal space to the left
            x--;
            y--;
        }
        x = this.row;
        y = this.column;
        //check right diagonal
        while (x <= n && y <= n && x >= 1 && y >= 1){
            if (con.getRow() == this.getRow() && con.getColumn() == this.getColumn())
                answer = true;
            //check diagonal space to the right
            x++;
            y--;
        }

        return answer;


    }

    @Override
    public String toString(){

        return "Row= " + row + ", Column= " + column;
    }
}
