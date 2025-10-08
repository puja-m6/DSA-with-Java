import java.util.*;
class CombinationSumII
{
    List<List<Integer>> combinationSums(int[] candidates,int target)
    {
        Arrays.sort(candidates);
        List<List<Integer>> finalList=new ArrayList<>();
        findCombinations(0,candidates,target,finalList,new ArrayList<>());
        return finalList;
    }
    void findCombinations(int index,int[] candidates,int target,List<List<Integer>> finalList,List<Integer> list)
    {
        if(target==0)
        {
            finalList.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<candidates.length;i++)
        {
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(target<candidates[i]) break;
            list.add(candidates[i]);
            findCombinations(i+1,candidates,target-candidates[i],finalList,list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String args[])
    {
        CombinationSumII ob=new CombinationSumII();
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
        List<List<Integer>> answer=ob.combinationSums(candidates,target);
        System.out.println(answer);
        sc.close();
    }
}