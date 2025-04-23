import java.util.*;
class OnlineStockSpan
{
    Stack<AbstractMap.SimpleEntry<Integer,Integer>> st=new Stack<>();
    int ind;
    OnlineStockSpan()
    {
        ind=-1;
        st.clear();
    }
    int next(int price)
    {
        int ans;
        ind++;
        while(!st.isEmpty() && st.peek().getKey()<=price)
        {
            st.pop();
        }
        if(!st.isEmpty())
        {
            ans=ind-st.peek().getValue();
        }
        else
        {
            ans=ind-(-1);
        }
        st.push(new AbstractMap.SimpleEntry<>(price,ind));
        return ans;
    }
    public static void main(String args[])
    {
        int ans;
        ArrayList<Integer> arr=new ArrayList<>();
        OnlineStockSpan ob=new OnlineStockSpan();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the daily price quotes or enter -99 if you wish to quit: ");
        int price=sc.nextInt();;
        do
        {
            ans=ob.next(price);
            arr.add(ans);
            price=sc.nextInt();
        }
        while(price!=-99);
        for(int i : arr)
        System.out.print(i+"\t");
    }
}