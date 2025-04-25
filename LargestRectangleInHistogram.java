import java.util.*;
class LargestRectangleInHistogram
{
    int solution(int[] heights)
    {
        int n=heights.length;
        int nse,pse,current,area,maxArea=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>heights[i])
            {
                current=heights[st.pop()];
                nse=i;
                pse=(st.isEmpty())?-1:st.peek();
                area=current*(nse-pse-1);
                maxArea=Math.max(maxArea,area);
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            current=heights[st.pop()];
            nse=n;
            pse=(st.isEmpty())?-1:st.peek();
            area=current*(nse-pse-1);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        LargestRectangleInHistogram ob=new LargestRectangleInHistogram();
        System.out.println("Enter the number of bars in the histogram :");
        int n=sc.nextInt();
        System.out.println("Enter the height of each bar :");
        int heights[]=new int[n];
        for(int i=0;i<n;i++)
        {
            heights[i]=sc.nextInt();
        }
        System.out.println("The area of the largest rectangle in the histogram is :"+ob.solution(heights));
    }
}