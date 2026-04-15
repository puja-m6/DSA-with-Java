import java.util.*;
public class MedianOfTwoSortedArrays {
    double solution(int[] nums1,int[] nums2){
        int n1=nums1.length;
        int n2=nums2.length;
        int n=n1+n2;
        if(n2<n1){
            return solution(nums2, nums1);
        }
        int half=(n1+n2)/2;
        int low=-1;
        int high=n1-1;
        int i,j,Aleft,Bleft,Aright,Bright;
        while(low<=high){
            i=(low+high)/2;
            j=half-i-2;
            Aleft=(i>=0)?nums1[i]:Integer.MIN_VALUE;
            Aright=(i+1<n1)?nums1[i+1]:Integer.MAX_VALUE;
            Bleft=(j>=0)?nums2[j]:Integer.MIN_VALUE;
            Bright=(j+1<n2)?nums2[j+1]:Integer.MAX_VALUE;
            if(Aleft<=Bright && Bleft<=Aright){
                if(n%2==0){
                    return (Math.max(Aleft,Bleft)+Math.min(Aright,Bright))/2.0;
                }
                else{
                    return Math.min(Aright,Bright);
                }
            }
            else if(Aleft>Bright){
                high=i-1;
            }
            else{
                low=i+1;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        MedianOfTwoSortedArrays ob=new MedianOfTwoSortedArrays();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the first array : ");
        int m=sc.nextInt();
        System.out.println("Enter the array elements : ");
        int nums1[]=new int[m];
        for(int i=0;i<m;i++){
            nums1[i]=sc.nextInt();
        }
        System.out.println("Enter the size of the second array : ");
        int n=sc.nextInt();
        System.out.println("Enter the array elements : ");
        int[] nums2=new int[n];
        for(int i=0;i<n;i++){
            nums2[i]=sc.nextInt();
        }
        System.out.println(ob.solution(nums1,nums2));
        sc.close();
    }
}
