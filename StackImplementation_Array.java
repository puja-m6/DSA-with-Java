import java.util.*;
class StackImplementation_Array
{
    int st[]=new int[10];
    int top=-1;
    void push(int item)
    {
        if(top>=10)
        System.out.println("Stack Overflow");
        else
        {
            top++;
            st[top]=item;
        }
    }
    int peek()
    {
        if(top==-1)
        return -99;
        else
        return st[top];
    }
    int pop()
    {
        if(top==-1)
        return -99;
        else
        {
            int item=st[top];
            top--;
            return item;
        }
    }
    int size()
    {
        return top+1;
    }
    public static void main(String args[])
    {
        int item;
        StackImplementation_Array ob=new StackImplementation_Array();
        Scanner sc=new Scanner(System.in);
        int n=0;
        do
        {
            System.out.println("Enter your choice : 1.push 2.pop 3.peek 4.size 5.quit");
            n=sc.nextInt();
            switch(n)
            {
                case 1:
                System.out.println("Enter element to push : ");
                item=sc.nextInt();
                ob.push(item);
                break;
                case 2:
                item=ob.pop();
                System.out.println("The deleted item is : "+item);
                break;
                case 3:
                item=ob.peek();
                System.out.println("The topmost item is : "+item);
                break;
                case 4:
                int k=ob.size();
                System.out.println("The size of the stack is : "+k);
                break;
                case 5:
                break;
            }
        }
        while(n!=5);
    }
}