import java.util.*;
class Solution
{
    String reverse(String s)
    {
        String ret="";
        char c;
        for(int i=s.length()-1;i>=0;i--)
        {
            c=s.charAt(i);
            if(c=='(')
            ret=ret+')';
            else if(c==')')
            ret=ret+'(';
            else
            ret=ret+c;
        }
        return ret;
    }
    int priority(char ch)
    {
        if(ch=='^')
        return 3;
        if(ch=='*' || ch=='/')
        return 2;
        if(ch=='+' || ch=='-')
        return 1;
        return -1;
    }
    String intopre(String s)
    {
        char c;
        s=reverse(s);
        int n=s.length();
        String ans="";
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<n)
        {
            c=s.charAt(i);
            if((c>='A'&&c<='Z')||(c>='a'&&c<='z')||(c>='0'&&c<='9'))
            {
                ans=ans+c;
            }
            else if(c=='(')
            {
                st.push(c);
            }
            else if(c==')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                {
                    ans=ans+st.pop();
                }
                st.pop();
            }
            else
            {
                if(c=='^')
                {
                    while(!st.isEmpty() && priority(c)<=priority(st.peek()))
                    ans=ans+st.pop();
                }
                else
                {
                    while(!st.isEmpty() && priority(c)<priority(st.peek()))
                    ans=ans+st.pop();
                }
                st.push(c);
            }
            i++;
        }
        while(!st.isEmpty())
        ans=ans+st.pop();
        ans=reverse(ans);
        return ans;
    }
}
class InfixToPrefix
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the expression : ");
        String exp=sc.nextLine();
        Solution ob=new Solution();
        System.out.println(ob.intopre(exp));
    }
}