package dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RatInAMaze {
	List<String> solution(int[][] maze){
		int rows=maze.length;
		int columns=maze[0].length;
		int[] di= {1,0,0,-1};
		int[] dj= {0,-1,1,0};
		List<String> res=new ArrayList<>();
		int[][] visited=new int[rows][columns];
		if(maze[0][0]==1) {
			visited[0][0]=1;
			path(0,0,"",maze,visited,rows,columns,res,di,dj);
		}
		return res;
		}
	void path(int i,int j,String s,int[][] maze,int[][] visited,int rows,int columns,List<String> res,int[] di,int[] dj) {
		if(i==rows-1 && j==columns-1) {
			res.add(s);
			return;
		}
		String dir="DLRU";
		for(int ind=0;ind<4;ind++) {
			int nexti=i+di[ind];
			int nextj=j+dj[ind];
			if(nexti>=0 && nextj>=0 && nexti<rows && nextj<columns && visited[nexti][nextj]==0 && maze[nexti][nextj]==1) {
				visited[nexti][nextj]=1;
				path(nexti,nextj,s+dir.charAt(ind),maze,visited,rows,columns,res,di,dj);
				visited[nexti][nextj]=0;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		RatInAMaze ob=new RatInAMaze();
		System.out.println("Enter the rows and columns : ");
		int n=sc.nextInt();
		int[][] maze=new int[n][n];
		System.out.println("Enter the array elements :");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				maze[i][j]=sc.nextInt();
			}
		}
		List<String> res=ob.solution(maze);
		System.out.println(res);
	}

}
