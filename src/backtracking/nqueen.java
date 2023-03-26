package backtracking;

public class nqueen {
    public static void main(String[] args) {
        boolean b[][] = {
                {false,false,false},
                {false,false,false},
                {false,false,false},
        };
        //System.out.println(b.length);
        System.out.println(issafe(b,0,0));
        //display(b);
    }

    public static int queens(boolean b[][], int row)
    {
        if(row == b.length)
        {
            display(b);
            return 1;
        }
        int count=0;
        for(int col = 0; col < b.length; col++)
        {
            if(issafe(b,row,col))
            {
                b[row][col] = true;
                count += queens(b,row+1);
                b[row][col] = false;
            }
        }
        return count;
    }

    private static void display(boolean[][] b) {
        for (boolean[] row : b)
        {
                for (boolean element : row)
                {
                    if(element)
                    {
                        System.out.print("Q ");
                    }
                    else
                    {
                        System.out.print("X ");
                    }
                }
            System.out.println();
        }
    }

    private static boolean issafe(boolean[][] b, int row, int col) {
        //check for the upper side
        for (int j = 0; j<row;j++)
        {
            if(b[j][col])
            {
                return false;
            }
        }
        //check for left diagonal
        int maxleft = Math.min(row,col);
        for (int j = 1; j<=maxleft; j++)
        {
            if (b[row-j][col-j]){
                return false;
            }
        }
        //check for right
        int maxright = Math.min(row,b.length - col - 1);

        for (int j=1; j<=maxright;j++)
        {
            if (b[row-j][col+j])
            {
                return false;
            }
        }
        return true;
    }
}
