import java.util.*;
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data=data;
        this.next=null;
        this.prev=null;
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
        newNode.prev=temp;
    }
    void printList()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
}
class FindAllPairsWithGivenSumInDLL
{
    Node findTail(Node head)
    {
        Node tail=head;
        while(tail.next!=null)
        {
            tail=tail.next;
        }
        return tail;
    }
    ArrayList<ArrayList<Integer>> solution(Node head,int k)
    {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        if(head==null || head.next==null)
        return ans;
        Node left=head;
        Node right=findTail(head);
        while(left.data<right.data)
        {
            ArrayList<Integer> pair=new ArrayList<>();
            if(left.data+right.data<k)
            left=left.next;
            else if(left.data+right.data>k)
            right=right.prev;
            else
            {
                pair.add(left.data);
                pair.add(right.data);
                ans.add(pair);
                left=left.next;
                right=right.prev;
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        LinkedList ob=new LinkedList();
        FindAllPairsWithGivenSumInDLL ob1=new FindAllPairsWithGivenSumInDLL();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the linked list:");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            System.out.println("Enter elements :");
            int item=sc.nextInt();
            ob.addNodes(item);
        }
        System.out.println("Enter the sum :");
        int sum=sc.nextInt();
        ob.printList();
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        ret=ob1.solution(ob.head,sum);
        System.out.println("The pairs with given sum:");
        for(int i=0;i<ret.size();i++)
        {
            for(int j=0;j<ret.get(i).size();j++)
            {
                System.out.print(ret.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}