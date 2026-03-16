package dsa;

import java.util.Scanner;

public class SearchInRotatedSortedArray {
	public int search(int[] nums,int target) {
		int end=nums.length-1;
		int start=0;
		int mid;
		while(start<=end) {
			mid=(start+end)/2;
			if(target==nums[mid]) {
				return mid;
			}
			if(nums[start]<=nums[mid]) {
				if(nums[start]<=target && target<nums[mid]) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}
			else {
				if(nums[mid]<target && target<=nums[end]) {
					start=mid+1;
				}
				else {
					end=mid-1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInRotatedSortedArray ob=new SearchInRotatedSortedArray();
		System.out.println("Enter the number of elements :");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("Enter the array elements in rotated sorted order:");
		int nums[]=new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		System.out.println("Enter the target :");
		int target=sc.nextInt();
		int ans=ob.search(nums,target);
		if(ans!=-1) {
			System.out.println("Element found at : "+ans);
		}
		else {
			System.out.println("Element not found");
		}
	}

}
