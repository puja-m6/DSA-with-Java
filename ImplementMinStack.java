import java.util.*;
class ImplementMinStack
{
    int min;
    Stack<Integer> st;
    ImplementMinStack(){
        st=new Stack<>();
        int min=0;
    }
    void push(int val)
    {
        if(st.isEmpty()==true)
        {
            st.push(val);
            min=val;
            return;
        }
        if(val<min)
        {
            st.push(2*val-min);
            min=val;
        }
        else
        {
            st.push(val);
        }
    }
    void pop()
    {
        if(st.isEmpty()==true)
        return;
        int x=st.pop();
        if(x<min)
        {
            min=2*min-x;
        }
    }
    int top()
    {
        if(st.isEmpty()==true)
        return -1;
        int x=st.peek();
        if(x<min)
        return min;
        return x;
    }
    int getMin()
    {
        return min;
    }
    public static void main(String args[])
    {
        int ch=1;
        Scanner sc=new Scanner(System.in);
        ImplementMinStack ob=new ImplementMinStack();
        while(ch>=1 && ch<=4){
            System.out.println("Enter your choice :1.push 2.pop 3.top 4.getMin 5.quit");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.println("Enter the element to push : ");
                ob.push(sc.nextInt());
                break;
                case 2:
                ob.pop();
                System.out.println("Element Popped");
                break;
                case 3:
                System.out.println("Element at the top is : "+ob.top());
                break;
                case 4:
                System.out.println("Minimum element is : "+ob.getMin());
                break;
                default:
                break;
            }
        }
    }
}