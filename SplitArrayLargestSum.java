import java.util.*;
class SplitArrayLargestSum{
    int solution(int[] nums,int k){
        int low=Integer.MIN_VALUE;
        long high=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            high+=nums[i];
            if(nums[i]>low){
                low=nums[i];
            }
        }
        while(low<=high){
            int mid=(int)(low+high)/2;
            if(noOfSubarrays(nums,mid)>k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    int noOfSubarrays(int[] nums,int mid){
        int count=1;
        long subArraySum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(subArraySum+nums[i]<=mid){
                subArraySum+=nums[i];
            }
            else{
                count++;
                subArraySum=nums[i];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SplitArrayLargestSum ob=new SplitArrayLargestSum();
        System.out.println("Enter the size of the array : ");
        int n=sc.nextInt();
        System.out.println("Enter the array elements : ");
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("Enter the value of K : ");
        int k=sc.nextInt();
        System.out.println(ob.solution(nums,k));
        sc.close();
    }
}
