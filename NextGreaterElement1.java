import java.util.*;
class NextGreaterElement1
{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        n=sc.nextInt();
        System.out.println("Enter array elements : ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int nge[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
                while(st.isEmpty()==false && st.peek()<=arr[i])
                {
                    st.pop();
                }
                if(st.isEmpty()==true)
                nge[i]=-1;
                else
                nge[i]=st.peek();
            st.push(arr[i]);
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        for(int i=0;i<n;i++)
        {
            System.out.print(nge[i]+"\t");
        }
    }
}