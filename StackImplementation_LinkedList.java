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
class LinkedList
{
    int count=0;
    Node top=null;
    void push(int data)
    {
        Node newNode=new Node(data);
        newNode.next=top;
        top=newNode;
        count++;
    }
    int pop()
    {
        if(top==null)
        {
            System.out.println("Stack Underflow");
            return -99;
        }
        Node item=top;
        top=top.next;
        item.next=null;
        count--;
        return item.data;
    }
    int peek()
    {
        if(top==null)
        {
            System.out.println("Stack Underflow");
            return -99;
        }
        return top.data;
    }
    int size()
    {
        return count;
    }
}
class StackImplementation_LinkedList
{
    public static void main(String args[])
    {
        int n=0;
        int item;
        LinkedList ob=new LinkedList();
        Scanner sc=new Scanner(System.in);
        do
        {
            System.out.println("Enter your choice : 1.push 2.pop 3.peek 4.size and any other number to quit");
            n=sc.nextInt();
            switch(n)
            {
                case 1:
                System.out.println("Enter data to push :");
                item=sc.nextInt();
                ob.push(item);
                break;
                case 2:
                System.out.println("The deleted item is : "+ob.pop());
                break;
                case 3:
                System.out.println("The top most item is : "+ob.peek());
                break;
                case 4:
                System.out.println("The size of the stack is : "+ob.size());
                break;
                default:
                System.out.println("End");
            }
        }
        while(n>=1 && n<=4);
    }
}