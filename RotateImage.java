import java.util.*;
class RotateImage
{
    void solution(int[][] matrix)
    {
        int temp,n=matrix.length;
        for(int i=0;i<=n-2;i++)
        {
            for(int j=i+1;j<=n-1;j++)
            {
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++)
        {
            int start=0;
            int end=n-1;
            while(start<=end)
            {
                temp=matrix[i][start];
                matrix[i][start]=matrix[i][end];
                matrix[i][end]=temp;
                start++;
                end--;
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        RotateImage ob=new RotateImage();
        System.out.println("Enter the dimension of the matrix :");
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        System.out.println("Enter array elements :");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("Matrix before rotation :");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("Matrix after rotation :");
        ob.solution(matrix);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        sc.close();
    }
}