public class QueenSimulation
{
    public static void main (String[] args)
    {
        int n = 4;
        Queen q1 = new Queen(1, 1, n);
        Queen q2 = new Queen(1, 3, n);

        System.out.println(q2.conflict(q1));
    }
}
