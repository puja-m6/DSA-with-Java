import java.util.*;
class Node{
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
        Node newNode = new Node(data);
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
class MiddleOfTheLinkedList
{
    Node solution(Node head)
    {
        //Tortoise and Hare Algorithm
        if(head.next==null)
        return head;
        int flag=0;
        Node fast=head;
        Node slow=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(fast.next==null)
            flag=1;
        }
        if(flag==1)
        return slow;
        else
        return slow.next;
    }
    public static void main(String args[])
    {
        int size,element;
        LinkedList ob=new LinkedList();
        MiddleOfTheLinkedList ob1=new MiddleOfTheLinkedList();
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the size of the linked list : ");
        size=sc.nextInt();
        System.out.println("Enter the array elements : ");
        for(int i=0;i<size;i++)
        {
            element=sc.nextInt();
            ob.addNode(element);
        }
        System.out.println("The linked list is : ");
        ob.printList(ob.head);
        System.out.println("The middle element is : "+(ob1.solution(ob.head)).data);
    }
}