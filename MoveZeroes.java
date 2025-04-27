import java.util.*;
class MoveZeroes
{
    void solution(int[] nums)
    {
        int n=nums.length;
        int temp,j=-1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                j=i;
                break;
            }
        }
        if(j==-1)
        {
            return;
        }
        for(int i=j+1;i<n;i++)
        {
            if(nums[i]!=0)
            {
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        MoveZeroes ob=new MoveZeroes();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter array elements :");
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        System.out.println("Array before moving zeroes :");
        for(int i=0;i<n;i++)
        {
            System.out.print(nums[i]+"\t");
        }
        System.out.println();
        ob.solution(nums);
        System.out.println("Array after moving zeroes :");
        for(int i=0;i<n;i++)
        {
            System.out.print(nums[i]+"\t");
        }
    }
}