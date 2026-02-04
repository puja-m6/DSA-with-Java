package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution{
	public List<List<String>> solveNQueens(int n){
		List<List<String>> answer=new ArrayList<>();
		char[][] board=new char[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(board[i], '.');}
		int[] lowerDiagonal=new int[2*n-1];
		int[] upperDiagonal=new int[2*n-1];
		int[] leftRow=new int[n];
		solve(0,board,answer,lowerDiagonal,upperDiagonal,leftRow,n);
		return answer;
	}
	void solve(int col,char[][] board,List<List<String>> answer,int[] lowerDiagonal,int[] upperDiagonal,int[] leftRow,int n){
		if(col==n) {
			answer.add(construct(board));
			return;
		}
		for(int row=0;row<n;row++) {
			if(lowerDiagonal[row+col]==0 && upperDiagonal[n-1+col-row]==0 && leftRow[row]==0) {
				board[row][col]='Q';
				lowerDiagonal[row+col]=1;
				upperDiagonal[n-1+col-row]=1;
				leftRow[row]=1;
				solve(col+1,board,answer,lowerDiagonal,upperDiagonal,leftRow,n);
				board[row][col]='.';
				lowerDiagonal[row+col]=0;
				upperDiagonal[n-1+col-row]=0;
				leftRow[row]=0;
			}
		}
	}
	List<String> construct(char[][] board) {
		// TODO Auto-generated method stub
		List<String> res=new ArrayList<>();
		for(char[] row: board) {
			res.add(new String(row));
		}
		return res;
	}
}

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
