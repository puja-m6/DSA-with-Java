import java.util.*;
class Node
{
    Node next;
    int data;
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
class Add1ToALinkedListNumber
{
    Node solution(Node head)
    {
        int carry=helper(head);
        if(carry==1)
        {
            Node newNode=new Node(1);
            newNode.next=head;
            head=newNode;
        }
        return head;
    }
    int helper(Node temp)
    {
        if(temp==null)
        return 1;
        int carry=helper(temp.next);
        temp.data+=carry;
        if(temp.data<10)
        return 0;
        else
        {
            temp.data=0;
            return 1;
        }
    }
    public static void main(String args[])
    {
        int element,size;
        LinkedList ob=new LinkedList();
        Add1ToALinkedListNumber ob1=new Add1ToALinkedListNumber();
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the size of the linked list : ");
        size=sc.nextInt();
        for(int i=0;i<size;i++)
        {
            element=sc.nextInt();
            ob.addNode(element);
        }
        System.out.println("The original linked list : ");
        ob.printList(ob.head);
        Node ret=ob1.solution(ob.head);
        System.out.println("The updated linked list : ");
        ob.printList(ret);
    }
}