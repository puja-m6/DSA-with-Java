import java.util.*;
public class FindMissingAndRepeatedValues {
    int[] findMissingAndRepeatedValues(int[][] grid)
    {
        int n=grid.length;
        int m=n*n;
        long sumN=m*(m+1)/2;
        long sumNSquares=m*(m+1)*(2*m+1)/6;
        long sum=0,sumSquares=0;
        long val1,val2;
        int a,b;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                sum+=grid[i][j];
                sumSquares+=(grid[i][j]*grid[i][j]);
            }
        }
        val1=sum-sumN;
        val2=sumSquares-sumNSquares;
        val2=val2/val1;
        a=(int)((val1+val2)/2);
        b=(int)(a-val1);
        int[] ans={a,b};
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        FindMissingAndRepeatedValues ob=new FindMissingAndRepeatedValues();
        System.out.println("Enter the size of the square matrix: ");
        int n=sc.nextInt();
        int[][] grid=new int[n][n];
        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j]=sc.nextInt();
            }
        }
        int[] ans=ob.findMissingAndRepeatedValues(grid);
        System.out.println(ans[0]+" "+ans[1]);
        sc.close();
    }
}
