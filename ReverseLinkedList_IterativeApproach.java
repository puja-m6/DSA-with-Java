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
class ReverseLinkedList_IterativeApproach
{
    Node solution(Node head)
    {
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
        Node ReversedListHead;
        int size,element;
        LinkedList ob=new LinkedList();
        ReverseLinkedList_IterativeApproach ob1=new ReverseLinkedList_IterativeApproach();
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the number of elements you want to enter : ");
        size=sc.nextInt();
        System.out.println("Enter the elements : ");
        for(int i=0;i<size;i++)
        {
            element=sc.nextInt();
            ob.addNode(element);
        }
        System.out.println("The original linked list : ");
        ob.printList(ob.head);
        ReversedListHead=ob1.solution(ob.head);
        System.out.println("The reversed linked list : ");
        ob.printList(ReversedListHead);
    }
}