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
        System.out.println("NULL");
    }
}
class MergeTwoSortedLinkedLists
{
    Node solution(Node head1,Node head2)
    {
        Node dNode=new Node(-1);
        Node temp1=head1;
        Node temp2=head2;
        Node temp=dNode;
        if(temp1==null)
        return head2;
        if(temp2==null)
        return head1;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.data<temp2.data)
            {
                temp.next=temp1;
                temp=temp1;
                temp1=temp1.next;
            }
            else
            {
                temp.next=temp2;
                temp=temp2;
                temp2=temp2.next;
            }
        }
        if(temp2!=null)
        temp.next=temp2;
        if(temp1!=null)
        temp.next=temp1;
        return dNode.next;
    }
    public static void main(String args[])
    {
        int n1,n2,item;
        LinkedList ob1=new LinkedList();
        LinkedList ob2=new LinkedList();
        MergeTwoSortedLinkedLists obj=new MergeTwoSortedLinkedLists();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the first linked list : ");
        n1=sc.nextInt();
        for(int i=1;i<=n1;i++)
        {
            System.out.println("Enter items in ascending order:");
            item=sc.nextInt();
            ob1.addNodes(item);
        }
        System.out.println("Enter the size of the second linked list : ");
        n2=sc.nextInt();
        for(int i=1;i<=n2;i++)
        {
            System.out.println("Enter items in ascending order:");
            item=sc.nextInt();
            ob2.addNodes(item);
        }
        System.out.println("The first linked list is :");
        ob1.printList(ob1.head);
        System.out.println("The second linked list is :");
        ob2.printList(ob2.head);
        Node newHead=obj.solution(ob1.head,ob2.head);
        System.out.println("The merged linked list is:");
        ob1.printList(newHead);
    }
}