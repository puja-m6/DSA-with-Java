import java.util.*;
class MaximalRectangle
{
    int solution(char[][] matrix)
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] prefixSum=prefixSum(matrix);
        int maxArea=0;
        for(int i=0;i<n;i++)
        {
            maxArea=Math.max(maxArea,largestRectangleInHistogram(prefixSum[i]));
        }
        return maxArea;
    }
    int[][] prefixSum(char[][] matrix)
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] array=new int[n][m];
        int c,sum;
        for(int j=0;j<m;j++)
        {
            sum=0;
            for(int i=0;i<n;i++)
            {
                c=(int)matrix[i][j]-48;
                sum+=c;
                if(c==0)
                sum=0;
                array[i][j]=sum;
            }
        }
        return array;
    }
    int largestRectangleInHistogram(int[] arr)
    {
        int n=arr.length;
        int pse,nse,current,area,maxArea=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            {
                current=arr[st.pop()];
                nse=i;
                pse=(st.isEmpty())?-1:st.peek();
                area=current*(nse-pse-1);
                maxArea=Math.max(area,maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            current=arr[st.pop()];
            nse=n;
            pse=(st.isEmpty())?-1:st.peek();
            area=current*(nse-pse-1);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        MaximalRectangle ob=new MaximalRectangle();
        System.out.println("Enter the number of rows :");
        int n=sc.nextInt();
        System.out.println("Enter the number of columns :");
        int m=sc.nextInt();
        char matrix[][]=new char[n][m];
        System.out.println("Enter array elements :");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                matrix[i][j]=sc.next().charAt(0);
            }
        }
        System.out.println("The area of the maximal rectangle is :"+ob.solution(matrix));
    }
}