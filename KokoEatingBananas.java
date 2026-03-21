import java.util.*;
class KokoEatingBananas{
    public int minEatingSpeed(int[] piles,int h){
        int start=0;
        int end=piles.length-1;
        int mid;
        boolean ans;
        while(start<=end){
            mid=start+(end-start)/2;
            ans=canEat(piles,h,mid);
            if(ans==true){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
    public boolean canEat(int[] piles,int h,int k){
        int t=0;
        for(int i=0;i<piles.length;i++){
            t+=(piles[i]+(k-1))/k;
        }
        return t<=h;
    }
    public static void main(String args[]){
        KokoEatingBananas ob=new KokoEatingBananas();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of piles : ");
        int n=sc.nextInt();
        System.out.println("Enter the number of bananas in each pile : ");
        int piles[]=new int[n];
        for(int i=0;i<n;i++){
            piles[i]=sc.nextInt();
        }
        System.out.println("How many hours later will the guards come ? : ");
        int h=sc.nextInt();
        sc.close();
        System.out.println("Koko needs to eat "+ob.minEatingSpeed(piles, h)+" bananas per hour");
    }
}
