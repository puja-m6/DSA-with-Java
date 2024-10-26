import java.util.*;
class Node
{
    int data;
    Node next;
    Node(Node next)
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
        Node newNode=new Node();
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
class ReverseLinkedList_RecursiveApproach
{
    Node solution(Node head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        Node newHead=solution(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    public static void main(String args[])
    {
        Node ReversedListHead;
        int size,element;
        LinkedList ob=new LinkedList();
        ReverseLinkedList_RecursiveApproach ob1=new ReverseLinkedList_RecursiveApproach();
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the size of the linked list : ");
        size=sc.nextInt();
        System.out.println("Enter the elements : ");
        for(int i=0;i<size;i++)
        {
            element=sc.nextInt();
            ob.addNode(element);
        }
        System.out.println("The original linked list : ");
        ob.printList(ob.head);
        System.out.println("The reversed linked list : ");
        ob.printList(ob1.solution(ob.head));
    }
}