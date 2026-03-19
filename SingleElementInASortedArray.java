import java.util.*;
class SingleElementInASortedArray{
    public int SingleNonDuplicate(int nums[]){
        int n=nums.length;
        int start=1;
        int end=n-2;
        int mid;
        if(n==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }
        while(start<=end){
            mid=(start+end)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }
            else if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2==1 && nums[mid]==nums[mid-1])){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        SingleElementInASortedArray ob=new SingleElementInASortedArray();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n=sc.nextInt();
        System.out.println("Enter array elements : ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ans=ob.SingleNonDuplicate(arr);
        System.out.println("The single element is : "+ans);
    }
}