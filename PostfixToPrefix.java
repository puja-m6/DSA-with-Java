import java.util.*;
class PostfixToPrefix
{
    String solution(String s)
    {
        Stack<String> st=new Stack<>();
        int l=s.length();
        int i=0;
        char c;
        String a,b,str;
        while(i<l)
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
                str=c+b+a;
                st.push(str);
            }
            i++;
        }
        return st.pop();
    }
    public static void main(String args[])
    {
        PostfixToPrefix ob=new PostfixToPrefix();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the expression : ");
        String s=sc.nextLine();
        System.out.println(ob.solution(s));
    }
}