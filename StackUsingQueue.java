import java.util.*;
class StackUsingQueue
{
    Queue<Integer> queue=new LinkedList<>();
    void push(int data)
    {
        int s=queue.size();
        queue.add(data);
        for(int i=1;i<=s;i++)
        {
            queue.add(queue.peek());
            queue.remove();
        }
    }
    int pop()
    {
        if(queue.peek()==null)
        {
            System.out.println("Stack is empty");
            return -99;
        }
        return queue.remove();
    }
    int peek()
    {
        if(queue.peek()==null)
        {
            System.out.println("Stack is empty");
            return -99;
        }
        return queue.peek();
    }
    int size()
    {
        return queue.size();
    }
    public static void main(String args[])
    {
        int item;
        StackUsingQueue ob=new StackUsingQueue();
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
        while(n>=1 && n<=4);
    }
}