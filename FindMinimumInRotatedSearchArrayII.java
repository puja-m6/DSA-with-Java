import java.util.*;
public class FindMinimumInRotatedSearchArrayII{
    public int findMin(int[] nums) {
       int start=0;
       int end=nums.length-1;
       int mid;
       while(start<end){
        mid=(start+end)/2;
        if(nums[mid]>nums[end]){
            start=mid+1;
        }
        else if(nums[mid]<nums[end]){
            end=mid;
        }
        else{
            end--;
        }
       }
       return nums[start];
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        FindMinimumInRotatedSearchArrayII ob=new FindMinimumInRotatedSearchArrayII();
        System.out.println("Enter the size of the array : ");
        int n=sc.nextInt();
        System.out.println("Enter array elements : ");
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println("Minimum element is : "+ob.findMin(arr));
        sc.close();
    }
}