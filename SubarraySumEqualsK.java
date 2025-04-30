import java.util.*;
class SubarraySumEqualsK
{
    int solution(int[] nums,int k)
    {
        int sum=0,rem,count=0;
        HashMap<Integer,Integer> prefixSumCount=new HashMap<>();
        for(int num:nums)
        {
            sum+=num;
            if(sum==k)
            count++;
            rem=sum-k;
            if(prefixSumCount.containsKey(rem))
            {
                count+=prefixSumCount.get(rem);
            }
            prefixSumCount.put(sum,prefixSumCount.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        SubarraySumEqualsK ob=new SubarraySumEqualsK();
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
        System.out.println("Number of subarrays with sum "+k+" is "+ob.solution(nums,k));
        sc.close();
    }
}