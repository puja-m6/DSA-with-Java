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
class mergeKSortedLists
{
    Node mergeLists(Node head1,Node head2)
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
        if(temp1!=null)
        temp.next=temp1;
        if(temp2!=null)
        temp.next=temp2;
        return dNode.next;
    }
    Node solution(Node[] lists)
    {
        if(lists.length==0)
        return null;
        Node head=lists[0];
        for(int i=1;i<lists.length;i++)
        head=mergeLists(head,lists[i]);
        return head;
    }
    public static void main(String args[])
    {
        int k,item;
        System.out.println("Enter the value of K :");
        Scanner sc=new Scanner(System.in);
        k=sc.nextInt();
        LinkedList[] ob=new LinkedList[k];
        Node[] lists=new Node[k];
        for(int i=0;i<k;i++)
        {
            ob[i]=new LinkedList();
            System.out.println("Enter the size of the "+(i+1)+"th list :");
            int n1=sc.nextInt();
            System.out.println("Enter items in the "+(i+1)+"th list :");
            for(int j=1;j<=n1;j++)
            {
                item=sc.nextInt();
                ob[i].addNodes(item);
            }
            System.out.println("The entered list is :");
            ob[i].printList(ob[i].head);
            lists[i]=ob[i].head;
        }
        mergeKSortedLists obj=new mergeKSortedLists();
        Node newHead=obj.solution(lists);
        System.out.println("The merged list is :");
        ob[0].printList(newHead);
    }
}