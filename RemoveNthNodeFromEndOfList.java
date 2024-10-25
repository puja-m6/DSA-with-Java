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
    Node head;
    void addNode(int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
    }
    void printList(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
}
class RemoveNthNodeFromEndOfList
{
    Node solution(Node head,int n)
    {
        Node fast=head;
        Node slow=head;
        while(n!=0)
        {
            n--;
            fast=fast.next;
            if(fast==null)
            {
                head=head.next;
                slow.next=null;
                return head;
            }
        }
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        Node delNode=slow.next;
        slow.next=slow.next.next;
        delNode.next=null;
        return head;
    }
    public static void main(String args[])
    {
        LinkedList ob=new LinkedList();
        RemoveNthNodeFromEndOfList ob1=new RemoveNthNodeFromEndOfList();
        Node head,returnedHead;
        int num,element,n;
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the number of elements you want to enter");
        num=sc.nextInt();
        System.out.println("Enter the elements : ");
        for(int i=0;i<num;i++)
        {
            element=sc.nextInt();
            ob.addNode(element);
        }
        head=ob.head;
        System.out.println("The linked list is : ");
        ob.printList(head);
        System.out.println("Enter the node from end you wish to delete : ");
        n=sc.nextInt();
        System.out.println("The linked list after deletion of nth node : ");
        returnedHead=ob1.solution(head,n);
        ob.printList(returnedHead);
    }
}
