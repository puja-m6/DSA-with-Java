import java.util.*;
class RotateArray
{
    void solution(int[] nums,int k)
    {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-k);
        reverse(nums,n-k,n);
        reverse(nums,0,n);
    }
    void reverse(int[] nums,int start,int end)
    {
        end--;
        int temp;
        while(start<end)
        {
            temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        RotateArray ob=new RotateArray();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the array elements :");
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        System.out.println("Enter the value of K(for right rotation):");
        int k=sc.nextInt();
        System.out.println("The array before rotation is ");
        for(int i=0;i<n;i++)
        {
            System.out.print(nums[i]+"\t");
        }
        ob.solution(nums,k);
        System.out.println();
        System.out.println("The array after rotation is ");
        for(int i=0;i<n;i++)
        {
            System.out.print(nums[i]+"\t");
        }
    }
}