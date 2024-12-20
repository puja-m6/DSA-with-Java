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
class SortALinkedList
{
    Node findMiddle(Node head)
    {
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    Node mergeTwoLists(Node head1,Node head2)
    {
        if(head1==null)
        return head2;
        if(head2==null)
        return head1;
        Node temp1=head1;
        Node temp2=head2;
        Node dNode=new Node(-1);
        Node temp=dNode;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.data<temp2.data)
            {
                temp.next=temp1;
                temp=temp.next;
                temp1=temp1.next;
            }
            else
            {
                temp.next=temp2;
                temp=temp.next;
                temp2=temp2.next;
            }
        }
        if(temp1!=null)
        temp.next=temp1;
        if(temp2!=null)
        temp.next=temp2;
        return dNode.next;
    }
    Node solution(Node head)
    {
        if(head==null || head.next==null)
        return head;
        Node mid=findMiddle(head);
        Node leftHead=head;
        Node rightHead=mid.next;
        mid.next=null;
        leftHead=solution(leftHead);
        rightHead=solution(rightHead);
        head=mergeTwoLists(leftHead,rightHead);
        return head;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        LinkedList ob=new LinkedList();
        System.out.println("Enter the size of the linked list :");
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter an item :");
            int item=sc.nextInt();
            ob.addNodes(item);
        }
        System.out.println("Entered linked list is :");
        ob.printList(ob.head);
        SortALinkedList obj=new SortALinkedList();
        Node newHead=obj.solution(ob.head);
        System.out.println("The sorted list is :");
        ob.printList(newHead);
    }
}