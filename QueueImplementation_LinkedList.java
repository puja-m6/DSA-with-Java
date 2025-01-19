import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
class QueueImplementation_LinkedList
{
    int currSize=0;
    Node start;
    Node end;
    void push(int data)
    {
        Node newNode=new Node(data);
        if(start==null && end==null)
        {
            start=newNode;
            end=newNode;
            currSize++;
            return;
        }
        end.next=newNode;
        end=newNode;
        currSize++;
    }
    int pop()
    {
        if(start==null)
        {
            System.out.println("Queue is empty");
            return -99;
        }
        Node item=start;
        start=start.next;
        currSize--;
        if(start==null)
        end=null;
        return item.data;
    }
    int top()
    {
        if(start==null)
        {
            System.out.println("Queue is empty");
            return -99;
        }
        return start.data;
    }
    int size()
    {
        return currSize;
    }
    public static void main(String args[])
    {
        int n=1,item;
        QueueImplementation_LinkedList ob=new QueueImplementation_LinkedList();
        Scanner sc=new Scanner(System.in);
        while(n>=1 && n<=4)
        {
            System.out.println("Enter your choice 1.push 2.pop 3.top 4.size 5.quit");
            n=sc.nextInt();
            switch(n)
            {
                case 1:
                System.out.println("Enter element to enter : ");
                item=sc.nextInt();
                ob.push(item);
                break;
                case 2:
                item=ob.pop();
                System.out.println("The deleted item is : "+item);
                break;
                case 3:
                item=ob.top();
                System.out.println("The topmost item is : "+item);
                break;
                case 4:
                System.out.println("The size of the queue is :"+ob.size());
                break;
                default:
                System.out.println("End");
            }
        }
    }
}
