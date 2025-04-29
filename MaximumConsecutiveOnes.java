import java.util.*;
class MaximumConsecutiveOnes
{
    int solution(int[] nums)
    {
        int n=nums.length;
        int count=0,maxCount=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                count=0;
            }
            else
            {
                count++;
                maxCount=Math.max(maxCount,count);
            }
        }
        return maxCount;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        MaximumConsecutiveOnes ob=new MaximumConsecutiveOnes();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        System.out.println("Enter the array elements :");
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        System.out.println("The maximum number of ones is :"+ob.solution(nums));
    }
}