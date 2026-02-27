package dsa;
import java.util.*;
public class KthPermutationSequence {
	String sequence(int n,int k) {
		String ans="";
		k=k-1;
		int fact=1;
		List<Integer> arr=new ArrayList<>();
		for(int i=1;i<n;i++) {
			fact=fact*i;
			arr.add(i);
		}
		arr.add(n);
		while(true) {
			ans=ans+arr.get(k/fact);
			arr.remove(k/fact);
			if(arr.size()==0) {
				break;
			}
			k=k%fact;
			fact=fact/arr.size();
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		KthPermutationSequence ob=new KthPermutationSequence();
		System.out.println("Enter the value of n : ");
		int n=sc.nextInt();
		System.out.println("Enter the value of K : ");
		int k=sc.nextInt();
		System.out.println(ob.sequence(n, k));
	}

}
