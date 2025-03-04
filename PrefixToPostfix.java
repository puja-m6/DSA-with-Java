import java.util.*;
class PrefixToPostfix
{
    String solution(String s)
    {
        Stack<String> st=new Stack<>();
        int l=s.length();
        int i=l-1;
        char c;
        String a,b,str;
        while(i>=0)
        {
            c=s.charAt(i);
            if((c>='A' && c<='Z')||(c>='a' && c<='z')||(c>='0' && c<='9'))
            {
                st.push(Character.toString(c));
            }
            else
            {
                a=st.pop();
                b=st.pop();
                str=a+b+c;
                st.push(str);
            }
            i--;
        }
        return st.pop();
    }
    public static void main(String args[])
    {
        PrefixToPostfix ob=new PrefixToPostfix();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the expression : ");
        String s=sc.nextLine();
        System.out.println(ob.solution(s));
    }
}