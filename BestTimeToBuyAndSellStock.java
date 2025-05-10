import java.util.*;
class BestTimeToBuyAndSellStock
{
    int solution(int[] prices)
    {
        int minimal=prices[0],maxProfit=0,cost,n=prices.length;
        for(int i=1;i<n;i++)
        {
            cost=prices[i]-minimal;
            maxProfit=Math.max(maxProfit,cost);
            minimal=Math.min(minimal,prices[i]);
        }
        return maxProfit;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        BestTimeToBuyAndSellStock ob=new BestTimeToBuyAndSellStock();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array elements :");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Maximum Profit :"+ob.solution(arr));
        sc.close();
    }
}