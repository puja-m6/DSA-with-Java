import java.util.*;
class LongestSubarrayWithSumK_Positives
{
    int solution(int[] nums,int k)
    {
        int  len,sum=0,maxLen=0,i=0,n=nums.length;
        for(int j=0;j<n;j++)
        {
            sum+=nums[j];
            while(sum>k && i<=j)
            {
                sum-=nums[i];
                i++;
            }
            if(sum==k)
            {
                len=j-i+1;
                maxLen=Math.max(len,maxLen);
            }
        }
        return maxLen;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        LongestSubarrayWithSumK_Positives ob=new LongestSubarrayWithSumK_Positives();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the array elements :");
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        System.out.println("Enter the value of K:");
        int k=sc.nextInt();
        System.out.println("Length of the longest subarray with sum "+k+" is "+ob.solution(nums,k));
    }
}