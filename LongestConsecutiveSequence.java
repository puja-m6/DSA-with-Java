import java.util.*;
class LongestConsecutiveSequence
{
    int solution(int[] nums)
    {
        int currentNum,streak,maxStreak=0;
        HashSet<Integer> hs=new HashSet<>();
        for(int num:nums)
        {
            hs.add(num);
        }
        for(int num:hs)
        {
            if(!hs.contains(num-1))
            {
                currentNum=num;
                streak=1;
                while(hs.contains(currentNum+1))
                {
                    streak++;
                    currentNum++;
                }
                maxStreak=Math.max(streak,maxStreak);
            }
        }
        return maxStreak;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        LongestConsecutiveSequence ob=new LongestConsecutiveSequence();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the array elements :");
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        System.out.println("Length of the longest consecutive sequence is "+ob.solution(nums));
        sc.close();
    }
}