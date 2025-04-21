import java.util.*;
class SumOfSubarrayRanges
{
    long solution(int[] arr)
    {
        int n=arr.length;
        long minTotal=0,maxTotal=0;
        int[] nse=findNSE(arr);
        int[] nge=findNGE(arr);
        int[] psee=findPSEE(arr);
        int[] pgee=findPGEE(arr);
        int left,right;
        for(int i=0;i<n;i++)
        {
            left=i-psee[i];
            right=nse[i]-i;
            minTotal=minTotal+(left*right*1L*arr[i]);
            left=i-pgee[i];
            right=nge[i]-i;
            maxTotal=maxTotal+(left*right*1L*arr[i]);
        }
        return maxTotal-minTotal;
    }
    int[] findNSE(int[] arr)
    {
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                nse[i]=st.peek();;
            }
            else
            {
                nse[i]=n;
            }
            st.push(i);
        }
        return nse;
    }
    int[] findNGE(int[] arr)
    {
        int n=arr.length;
        int[] nge=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]<=arr[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                nge[i]=st.peek();;
            }
            else
            {
                nge[i]=n;
            }
            st.push(i);
        }
        return nge;
    }
    int[] findPSEE(int[] arr)
    {
        int n=arr.length;
        int[] psee=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                psee[i]=st.peek();;
            }
            else
            {
                psee[i]=-1;
            }
            st.push(i);
        }
        return psee;
    }
    int[] findPGEE(int[] arr)
    {
        int n=arr.length;
        int[] pgee=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]<arr[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                pgee[i]=st.peek();;
            }
            else
            {
                pgee[i]=-1;
            }
            st.push(i);
        }
        return pgee;
    }
    public static void main(String args[])
    {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter array elements : ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        SumOfSubarrayRanges ob=new SumOfSubarrayRanges();
        System.out.println("\n"+ob.solution(arr));
        sc.close();
    }
}