import java.util.*;
class SpiralMatrix
{
    List<Integer> solution(int[][] matrix)
    {
        List<Integer> list=new ArrayList<Integer>();
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0,right=n-1,top=0,bottom=m-1;
        while(left<=right && top<=bottom)
        {
            for(int i=left;i<=right;i++)
            {
                list.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++)
            {
                list.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--)
                {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        SpiralMatrix ob=new SpiralMatrix();
        System.out.println("Enter the number of rows in the matrix :");
        int m=sc.nextInt();
        System.out.println("Enter the number of columns in the matrix :");
        int n=sc.nextInt();
        int[][] matrix=new int[m][n];
        System.out.println("Enter the elements of the matrix :");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("The matrix is :");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        List<Integer> answer=ob.solution(matrix);
        System.out.println("Elements in spiral order :");
        for(int item : answer)
        {
            System.out.print(item+"\t");
        }
        sc.close();
    }
}