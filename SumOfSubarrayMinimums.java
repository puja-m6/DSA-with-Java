import java.util.*;
class SumOfSubarrayMinimums
{
    int solution(int[] arr)
    {
        int n=arr.length;
        int total=0;
        int[] nse=findNSE(arr);
        int[] psee=findPSEE(arr);
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++)
        {
            int left=i-psee[i];
            int right=nse[i]-i;
            total=(int)(total+(left*right*1L*arr[i])%mod)%mod;
        }
        return total;
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
        SumOfSubarrayMinimums ob=new SumOfSubarrayMinimums();
        System.out.println("\n"+ob.solution(arr));
    }
}