import java.util.*;
class AsteroidsCollision
{
    int[] solution(int[] asteroids)
    {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(asteroids[i]>0)
            {
                st.push(asteroids[i]);
            }
            else
            {
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(asteroids[i]))
                {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i]))
                {
                    st.pop();
                }
                else if(st.isEmpty() || st.peek()<0)
                {
                    st.push(asteroids[i]);
                }
            }
        }
        int s=st.size();
        int k=s-1;
        int[] arr=new int[s];
        for(int i=0;i<s;i++)
        {
            arr[k]=st.pop();
            k--;
        }
        return arr;
    }
    public static void main(String args[])
    {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of asteroids : ");
        n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter sizes of the asteroids : ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Remaining asteroids : ");
        AsteroidsCollision ob=new AsteroidsCollision();
        int[] asteroids=ob.solution(arr);
        int k=asteroids.length;
        for(int i=0;i<k;i++)
        {
            System.out.print(asteroids[i]+"\t");
        }
    }
}