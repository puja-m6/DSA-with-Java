import java.util.*;
class RearrangeArrayElementsBySign
{
    int[] solution(int[] nums)
    {
        int pos=0,neg=1;
        int n=nums.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
                arr[pos]=nums[i];
                pos+=2;
            }
            else
            {
                arr[neg]=nums[i];
                neg+=2;
            }
        }
        return arr;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        RearrangeArrayElementsBySign ob=new RearrangeArrayElementsBySign();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array elements :");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int[] rearranged=ob.solution(arr);
        System.out.println("The rearranged array elements :");
        for(int i=0;i<n;i++)
        {
            System.out.print(rearranged[i]+"\t");
        }
        sc.close();
    }
}