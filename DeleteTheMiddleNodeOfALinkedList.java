import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        next=null;
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
        return;
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
class DeleteTheMiddleNodeOfALinkedList
{
    Node solution(Node head)
    {
        Node slow=head;
        Node fast=head;
        while(fast.next.next!=null && fast.next.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node temp=slow.next;
        slow.next=slow.next.next;
        temp.next=null;
        return head;
    }
    public static void main(String args[])
    {
        int n,element;
        DeleteTheMiddleNodeOfALinkedList ob1=new DeleteTheMiddleNodeOfALinkedList();
        LinkedList ob=new LinkedList();
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the number of nodes : ");
        n=sc.nextInt();
        System.out.println("Enter the elements : ");
        for(int i=0;i<n;i++)
        {
            element=sc.nextInt();
            ob.addNode(element);
        }
        System.out.println("The original linked list : ");
        ob.printList(ob.head);
        System.out.println("The linked list after deletion of the middle node : ");
        ob.printList(ob1.solution(ob.head));
    }
}