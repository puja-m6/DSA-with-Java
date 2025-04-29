import java.util.*;
class DuplicateNumbersXOR
{
    int solution(int[] nums)
    {
        int xor=0;
        int n=nums.length;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            if(!hs.add(nums[i]))
            {
                xor=xor^nums[i];
            }
        }
        return xor;
    }
    public static void main(String args[])
    {
        DuplicateNumbersXOR ob=new DuplicateNumbersXOR();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the array elements :");
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        System.out.println("The xor of duplicate elements are :"+ob.solution(nums));
    }
}