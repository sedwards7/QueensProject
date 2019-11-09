public class Queen
{
    private int row, column;

    //sets Queen at 1,1 by default
    public Queen(){
        row = 1;
        column = 1;
    }

    public Queen(int r, int c){
        row = r;
        column = c;
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

    @Override
    public String toString(){

        return "Row= " + row + ", Column= " + column;
    }
}
