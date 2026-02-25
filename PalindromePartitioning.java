package dsa;

import java.util.ArrayList;
import java.util.*;

public class PalindromePartitioning {
	List<List<String>> palPartitioning(String s){
		List<List<String>> res=new ArrayList<>();
		List<String> path=new ArrayList<>();
		func(0,s,res,path);
		return res;
		
	}
	void func(int index,String s,List<List<String>> res,List<String> path) {
		if(index==s.length()) {
			res.add(new ArrayList<String>(path));
			return;
		}
		for(int i=index;i<s.length();i++) {
			if(isPalindrome(s,index,i)) {
				path.add(s.substring(index,i+1));
				func(i+1,s,res,path);
				path.remove(path.size()-1);
			}
		}
	}
	boolean isPalindrome(String s,int start,int end) {
		while(start<=end) {
			if(s.charAt(start++)!=s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PalindromePartitioning ob=new PalindromePartitioning();
		System.out.println("Enter a string : ");
		String s=sc.next();
		List<List<String>> res=ob.palPartitioning(s);
		for(List<String> pals : res) {
			System.out.println(pals);
		}
	}

}
