import java.util.*;
class MajorityElement
{
    int solution(int[] nums)
    {
        int n=nums.length;
        int count=0,element=-1;
        for(int i=0;i<n;i++)
        {
            if(count==0)
            {
                element=nums[i];
                count=1;
            }
            else if(nums[i]==element)
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return element;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        MajorityElement ob=new MajorityElement();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array elements :");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("The majority element :"+ob.solution(arr));
        sc.close();
    }
}