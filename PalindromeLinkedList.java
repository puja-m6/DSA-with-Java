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
class PalindromeLinkedList
{
    boolean solution(Node head)
    {
        Node newHead,second,first=head,fast=head,slow=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        newHead=reverse(slow.next);
        second=newHead;
        while(second!=null)
        {
            if(first.data!=second.data)
            {
                return false;
            }
            second=second.next;
            first=first.next;
        }
        second=reverse(newHead);
        return true;
    }
    Node reverse(Node head)
    {
        if(head==null || head.next==null)
        return head;
        Node prev=null;
        Node temp=head;
        Node front;
        while(temp!=null)
        {
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    public static void main(String args[])
    {
        int size,element;
        Scanner sc=new Scanner(System.in);
        LinkedList ob=new LinkedList();
        PalindromeLinkedList ob1=new PalindromeLinkedList();
        System.out.println("\nEnter the size of the linked list : ");
        size=sc.nextInt();
        System.out.println("Enter the elements : ");
        for(int i=0;i<size;i++)
        {
            element=sc.nextInt();
            ob.addNode(element);
        }
        System.out.println("The linked list : ");
        ob.printList(ob.head);
        boolean ret=ob1.solution(ob.head);
        if(ret==true)
        System.out.println("The linked list is a palindrome");
        else
        System.out.println("The linked list is not a palindrome");
    }
}