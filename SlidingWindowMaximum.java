import java.util.*;
class SlidingWindowMaximum
{
    int[] solution(int[] nums,int k)
    {
        int n=nums.length;
        int[] arr=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            while(!dq.isEmpty() && dq.peekFirst()<=i-k)
            dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
            dq.removeLast();
            dq.addLast(i);
            if(i>=k-1)
            arr[i-k+1]=nums[dq.peekFirst()];
        }
        return arr;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        SlidingWindowMaximum ob=new SlidingWindowMaximum();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array elements :");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter the value of k :");
        int k=sc.nextInt();
        int[] ans=new int[n-k+1];
        ans=ob.solution(arr,k);
        for(int i=0;i<n-k+1;i++)
        {
            System.out.print(ans[i]+"\t");
        }
    }
}