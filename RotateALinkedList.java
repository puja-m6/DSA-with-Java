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
    Node head=null;
    void addNodes(int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        temp=temp.next;
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
        System.out.println("NULL");
    }
}
class RotateALinkedList
{
    Node findNode(Node head,int k)
    {
        Node temp=head;
        int count=1;
        while(count!=k)
        {
            temp=temp.next;
            count++;
        }
        return temp;
    }
    Node solution(Node head,int k)
    {
        if(head==null)
        return head;
        int length=1;
        Node tail=head;
        while(tail.next!=null)
        {
            tail=tail.next;
            length++;
        }
        if(k%length==0)
        return head;
        k=k%length;
        tail.next=head;
        Node newTail=findNode(head,length-k);
        head=newTail.next;
        newTail.next=null;
        return head;
    }
    public static void main(String args[])
    {
        int size,item;
        Scanner sc=new Scanner(System.in);
        LinkedList ob=new LinkedList();
        RotateALinkedList ob1=new RotateALinkedList();
        System.out.println("Enter the size of the linked list : ");
        size=sc.nextInt();
        for(int i=1;i<=size;i++)
        {
            System.out.println("Enter item :");
            item=sc.nextInt();
            ob.addNodes(item);
        }
        System.out.println("The entered Linked List is :");
        ob.printList(ob.head);
        System.out.println("By how many nodes you wish to rotate the Linked List :");
        int k=sc.nextInt();
        Node newHead=ob1.solution(ob.head,k);
        System.out.println("The rotated list is : ");
        ob.printList(newHead);
    }
}