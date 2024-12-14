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
class ReverseNodesInKGroups
{
    Node findKthNode(Node temp,int k)
    {
        int count=1;
        while(count!=k && temp!=null)
        {
            temp=temp.next;
            count++;
        }
        return temp;
    }
    Node reverse(Node head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        Node newHead=reverse(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    Node solution(Node head,int k)
    {
        Node prevNode=null;
        Node nextNode;
        Node temp=head;
        while(temp!=null)
        {
            Node kthNode=findKthNode(temp,k);
            if(kthNode==null)
            {
                if(prevNode!=null)
                prevNode.next=temp;
                break;
            }
            nextNode=kthNode.next;
            kthNode.next=null;
            Node newHead=reverse(temp);
            if(temp==head)
            head=kthNode;
            else
            prevNode.next=kthNode;
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
    public static void main(String args[])
    {
        int item;
        Scanner sc=new Scanner(System.in);
        LinkedList ob=new LinkedList();
        ReverseNodesInKGroups ob1=new ReverseNodesInKGroups();
        System.out.println("Enter the size of the linked list : ");
        int size=sc.nextInt();
        for(int i=1;i<=size;i++)
        {
            System.out.println("Enter the item :");
            item=sc.nextInt();
            ob.addNodes(item);
        }
        System.out.println("The entered linked list is : ");
        ob.printList(ob.head);
        System.out.println("Enter the value of K :");
        int k=sc.nextInt();
        Node newHead=ob1.solution(ob.head,k);
        System.out.println("The reversed in K groups linked list is:");
        ob.printList(newHead);
    }
}