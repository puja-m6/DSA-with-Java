import java.util.*;
class PrefixToInfix
{
    String solution(String s)
    {
        Stack<String> st=new Stack<>();
        int l=s.length();
        int i=l-1;
        String a,b;
        char c;
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
                st.push("("+a+c+b+")");
            }
            i--;
    }
    return st.pop();
}
public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    PrefixToInfix ob=new PrefixToInfix();
    System.out.println("Enter the expression : ");
    String s=sc.nextLine();
    System.out.println(ob.solution(s));
}
}