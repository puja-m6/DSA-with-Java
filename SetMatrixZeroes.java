import java.util.*;
class SetMatrixZeroes
{
    void solution(int[][] matrix)
    {
        int col0=1;
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    if(j!=0)
                    {
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
                    else
                    {
                        col0=0;
                    }
                }
            }
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(matrix[i][j]!=0)
                {
                    if(matrix[0][j]==0 || matrix[i][0]==0)
                    {
                        matrix[i][j]=0;
                    }
                }
            }
        }
        if(matrix[0][0]==0)
        {
            for(int i=1;i<n;i++)
            {
                matrix[0][i]=0;
            }
        }
        if(col0==0)
        {
            for(int i=0;i<m;i++)
            {
                matrix[i][0]=0;
            }
        }
    }
    public static void main(String[] args) {
        int m,n;
        Scanner sc=new Scanner(System.in);
        SetMatrixZeroes ob=new SetMatrixZeroes();
        System.out.println("Enter the number of rows :");
        m=sc.nextInt();
        System.out.println("Enter the number of columns :");
        n=sc.nextInt();
        int[][] matrix=new int[m][n];
        System.out.println("Enter matrix elements (either 0 or 1):");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("Entered matrix is :");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("After updating :");
        ob.solution(matrix);
        for(int i=0;i<m;i++)
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