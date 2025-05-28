import java.util.*;
class NextPermutation
{
    void solution(int[] nums)
    {
        int index=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]>nums[i+1])
            {
                index=i;
                break;
            }
        }
        if(index==-1)
        {
            reverse(nums,0,n-1);
            return;
        }
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]>nums[index])
            {
                swap(nums[i],nums[index]);
                break;
            }
        }
        reverse(nums,index+1,n-1);
    }
    void reverse(int[] nums,int start,int end)
    {
        int temp;
        while(start<=end)
        {
            temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    void swap(int a,int b)
    {
        int c;
        c=a;
        a=b;
        b=c;
    }
    public static void main(String args[])
    {
        int n;
        NextPermutation ob=new NextPermutation();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array :");
        n=sc.nextInt();
        int nums[]=new int[n];
        System.out.println("Enter the array elements :");
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        System.out.println("The entered arrray :");
        for(int i=0;i<n;i++)
        {
            System.out.print(nums[i]+"\t");
        }
        System.out.println("/nNext Permutation:");
        ob.solution(nums);
        for(int i=0;i<n;i++)
        {
            System.out.print(nums[i]+"\t");
        }
        sc.close();
    }
}