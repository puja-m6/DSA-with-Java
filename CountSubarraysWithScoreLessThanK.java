import java.util.*;
class CountSubarraysWithScoreLessThanK
{
    long solution(int[] nums,long k)
    {
        long sum=0,score,count=0;
        int i=0,j,len,n=nums.length;
        for(j=0;j<n;j++)
        {
            sum+=nums[j];
            len=j-i+1;
            score=sum*len*1L;
            while(score>=k && i<=j)
            {
                sum-=nums[i];
                i++;
                len=j-i+1;
                score=sum*len*1L;
            }
            count+=j-i+1;
        }
        return count;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        CountSubarraysWithScoreLessThanK ob=new CountSubarraysWithScoreLessThanK();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the array elements :");
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        System.out.println("Enter the value of K:");
        long k=sc.nextInt();
        System.out.println("Number of subarrays with score less than "+k+" is "+ob.solution(nums,k));
        sc.close();
    }
}