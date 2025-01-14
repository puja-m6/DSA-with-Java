import java.util.*;
class QueueImplementation_Array
{
    int start=-1;
    int end=-1;
    int queue[]=new int[10];
    int currSize=0;
    void push(int data)
    {
        if(currSize==10)
        {
            System.out.println("Queue Overflow");
            return;
        }
        if(start==-1 && end==-1)
        {
            start=0;
            end=0;
        }
        else
        {
            end=(end+1)%10;
        }
        queue[end]=data;
        currSize++;
    }
    int pop()
    {
        if(currSize==0)
        {
            System.out.println("Queue Underflow");
            return -99;
        }
        int item=queue[start];
        if(currSize==1)
        {
            start=-1;
            end=-1;
        }
        else
        {
            start=(start+1)%10;
        }
        currSize-=1;
        return item;
    }
    int top()
    {
        if(currSize==0)
        {
        System.out.println("Queue Underflow");
        return -99;
        }
        return queue[start];
    }
    int size()
    {
        return currSize;
    }
    public static void main(String args[])
    {
        int n=1,item;
        QueueImplementation_Array ob=new QueueImplementation_Array();
        Scanner sc=new Scanner(System.in);
        while(n>=1 && n<=4)
        {
            System.out.println("Enter your choice 1.push 2.pop 3.top 4.size 5.quit");
            n=sc.nextInt();
            switch(n)
            {
                case 1:
                System.out.println("Enter element to enter : ");
                item=sc.nextInt();
                ob.push(item);
                break;
                case 2:
                item=ob.pop();
                System.out.println("The deleted item is : "+item);
                break;
                case 3:
                item=ob.top();
                System.out.println("The topmost item is : "+item);
                break;
                case 4:
                System.out.println("The size of the queue is :"+ob.size());
                break;
                default:
                System.out.println("End");
            }
        }
    }
}