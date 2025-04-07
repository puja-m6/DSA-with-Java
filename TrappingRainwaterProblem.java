import java.util.*;
class TrappingRainwaterProblem
{
    int solution(int[] height)
    {
        int n=height.length;
        int lMax=0,rMax=0,total=0;
        int l=0,r=n-1;
        while(l<r)
        {
            if(height[l]<=height[r])
            {
                if(lMax>height[l])
                total+=lMax-height[l];
                else
                lMax=height[l];
                l++;
            }
            else
            {
                if(rMax>height[r])
                total+=rMax-height[r];
                else
                rMax=height[r];
                r--;
            }
        }
        return total;
    }
    public static void main(String args[])
    {
        TrappingRainwaterProblem ob=new TrappingRainwaterProblem();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of buildings: ");
        int n=sc.nextInt();
        int[] height=new int[n];
        System.out.println("Enter the height of each building: ");
        for(int i=0;i<n;i++)
        {
            height[i]=sc.nextInt();
        }
        int trappedRainwater=ob.solution(height);
        System.out.println("Amount of trapped rainwater is: "+trappedRainwater+" units");
    }
}