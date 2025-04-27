import java.util.*;
class KthLargestElementInAnArray
{
    int solution(int[] array,int k)
    {
        int n=array.length;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<n;i++)
        {
            minHeap.add(array[i]);
            if(minHeap.size()>k)
            minHeap.poll();
        }
        return minHeap.peek();
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        KthLargestElementInAnArray ob=new KthLargestElementInAnArray();
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int[] array=new int[n];
        System.out.println("Enter array elements :");
        for(int i=0;i<n;i++)
        {
            array[i]=sc.nextInt();
        }
        System.out.println("Enter the value of k :");
        int k=sc.nextInt();
        System.out.println("The "+k+"th element is :"+ob.solution(array,k));
    }
}