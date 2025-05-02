import java.util.*;
class MinimumSizeSubarraySum
{
    int solution(int[] nums,int k)
    {
        int sum=0,i=0,len,minLen=0,n=nums.length;
        for(int j=0;j<n;j++)
        {
            sum+=nums[j];
            while(sum>=k)
            {
                len=j-i+1;
                if(minLen==0)
                minLen=len;
                minLen=Math.min(len,minLen);
                sum-=nums[i];
                i++;
            }
        }
        return minLen;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        MinimumSizeSubarraySum ob=new MinimumSizeSubarraySum();
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
        System.out.println("Number of subarrays with sum greater than or equal to "+k+" is "+ob.solution(nums,k));
        sc.close();
    }
}