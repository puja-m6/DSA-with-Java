import java.util.*;
class PostfixToInfix
{
    String solution(String s)
    {
        Stack<String> st=new Stack<>();
        int l=s.length();
        int i=0;
        String a,b;
        char c;
        while(i<l)
        {
            c=s.charAt(i);
            if((c>='A' && c<='Z')||(c>='a' && c<='z')||(c>='0' && c<='9'))
            {
                st.push(Character.toString(c));
            }
            else
            {
                b=st.pop();
                a=st.pop();
                st.push("("+a+c+b+")");
            }
            i++;
    }
    return st.pop();
}
public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    PostfixToInfix ob=new PostfixToInfix();
    System.out.println("Enter the expression : ");
    String s=sc.nextLine();
    System.out.println(ob.solution(s));
}
}