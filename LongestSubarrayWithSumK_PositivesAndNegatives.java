import java.util.*;
class LongestSubarrayWithSumK_PositivesAndNegatives
{
    int solution(int[] nums,int k)
    {
        int n=nums.length;
        int sum=0,rem,len,maxLen=0;
        HashMap<Integer,Integer> prefixSumMap=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(sum==k)
            {
                maxLen=Math.max(maxLen,i+1);
            }
            rem=sum-k;
            if(prefixSumMap.containsKey(rem))
            {
                len=i-prefixSumMap.get(rem);
                maxLen=Math.max(len,maxLen);
            }
            if(!prefixSumMap.containsKey(sum))
            {
                prefixSumMap.put(sum,i);
            }
        }
        return maxLen;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        LongestSubarrayWithSumK_PositivesAndNegatives ob=new LongestSubarrayWithSumK_PositivesAndNegatives();
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