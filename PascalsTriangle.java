import java.util.*;
class PascalsTriangle
{
    List<Integer> generateRows(int rowIndex)
    {
        List<Integer> row=new ArrayList<>();
        int val=1;
        row.add(val);
        for(int i=1;i<=rowIndex;i++)
        {
            val=(int)(val*1L*(rowIndex-i+1)/i);
            row.add(val);
        }
        return  row;
    }
    List<List<Integer>> solution(int numRows)
    {
        List<List<Integer>> rows=new ArrayList<>();
        for(int i=1;i<=numRows;i++)
        {
            rows.add(generateRows(i-1));
        }
        return rows;
    }
    public static void main(String args[])
    {
        PascalsTriangle ob=new PascalsTriangle();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the row number :");
        int numRows=sc.nextInt();
        System.out.println("The pascals triangle :\n"+ob.solution(numRows));
        sc.close();
    }
}