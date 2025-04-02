import java.util.*;
class NextGreaterElement2
{
    public static void main(String args[])
    {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of array elements : ");
        n=sc.nextInt();
        int arr[]=new int[n];
        int nge[]=new int[n];
        System.out.println("Enter array elements : ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--)
        {
            while(st.isEmpty()==false && st.peek()<=arr[i%n])
            {
                st.pop();
            }
            if(i<n){
            if(st.isEmpty()==true)
            nge[i]=-1;
            else
            nge[i]=st.peek();
        }
        st.push(arr[i%n]);
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        for(int i=0;i<n;i++)
        {
            System.out.print(nge[i]+" \t");
        }
    }
}