import java.util.*;
class SortColors
{
    void solution(int[] nums)
    {
        int n=nums.length;
        int low=0,mid=0,temp;
        int high=n-1;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
            else
            {
                temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        SortColors ob=new SortColors();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the colors : 0:Red 1:White 2:Blue ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Array before sorting :");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println("\nArray after sorting :");
        ob.solution(arr);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+"\t");
        }
        sc.close();
    }
}