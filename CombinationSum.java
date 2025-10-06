import java.util.*;
class CombinationSum {
    List<List<Integer>> solution(int[] candidates,int target)
    {
        List<List<Integer>> answer=new ArrayList<>();
        findCombinations(0,candidates,target,answer,new ArrayList<>());
        return answer;
    }
    void findCombinations(int index,int[] candidates,int target,List<List<Integer>> answer,List<Integer> list)
    {
        if(index==candidates.length)
        {
            if(target==0)
            {
                answer.add(new ArrayList<>(list));
            }
            return;
        }
        if(target>=candidates[index])
        {
            list.add(candidates[index]);
            findCombinations(index,candidates,target-candidates[index],answer,list);
            list.remove(list.size()-1);
        }
        findCombinations(index+1,candidates,target,answer,list);
    }
    public static void main(String args[])
    {
        CombinationSum ob=new CombinationSum();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array :");
        int n=sc.nextInt();
        int candidates[]=new int[n];
        System.out.println("Enter the array elements :");
        for(int i=0;i<n;i++)
        {
            candidates[i]=sc.nextInt();
        }
        System.out.println("Enter the target value:");
        int target=sc.nextInt();
        List<List<Integer>> answer=ob.solution(candidates,target);
        System.out.println(answer);
        sc.close();
    }
}
