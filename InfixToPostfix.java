import java.util.*;
class InfixToPostfix
{
    int priority(char c)
    {
        if(c=='^')
        return 3;
        if(c=='*' || c=='/')
        return 2;
        if(c=='+' || c=='-')
        return 1;
        return -1;
    }
    String solution(String s)
    {
        String ans="";
        Stack<Character> st=new Stack<>();
        char c;
        for(int i=0;i<s.length();i++)
        {
            c=s.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9'))
            ans+=c;
            else if(c=='(')
            st.add(c);
            else if(c==')')
            {
                while(st.isEmpty()==false && st.peek()!='(')
                {
                    ans+=st.peek();
                    st.pop();
                }
                st.pop();
            }
            else
            {
                while(st.isEmpty()==false && priority(c)<priority(st.peek()))
                {
                    ans+=st.peek();
                    st.pop();
                }
                st.push(c);
            }
        }
        while(st.isEmpty()==false)
        {
            ans+=st.peek();
            st.pop();
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        InfixToPostfix ob=new InfixToPostfix();
        System.out.println("Enter a string:");
        String s=sc.nextLine();
        String ans=ob.solution(s);
        System.out.println("The postfix expression is : "+ans);
    }
}