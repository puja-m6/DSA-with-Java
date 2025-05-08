import java.util.*;
class MaximumSubarray
{
    int solution(int[] nums)
    {
        int n=nums.length;
        int sum=0,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(sum>max)
            {
                max=sum;
            }
            if(sum<0)
            {
                sum=0;
            }
        }
        return max;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        MaximumSubarray ob=new MaximumSubarray();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array elements :");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Sum of maximum subarray is :"+ob.solution(arr));
        sc.close();
    }
}