import java.util.*;
class MissingNumber
{
    int solution(int[] nums)
    {
        int n=nums.length;
        int xor1=0,xor2=0;
        for(int i=0;i<n;i++)
        {
            xor1=xor1^i;
            xor2=xor2^nums[i];
        }
        xor1=xor1^n;
        return xor1^xor2;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        MissingNumber ob=new MissingNumber();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int nums[]=new int[n];
        System.out.println("Enter the array elements :");
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        System.out.println("The missing number is :"+ob.solution(nums));
    }
}