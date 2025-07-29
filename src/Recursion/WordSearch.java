package Recursion;

public class WordSearch {
    public boolean helper(char[][] board, String word,int n,int m,int idx,int i,int j){
        if(idx==word.length()){
            return true;
        }
        if(i<0 || j<0 || i==n || j==m || board[i][j]!=word.charAt(idx)){
            return false;
        }
        char temp=board[i][j];
        board[i][j]='*';
        boolean top=helper(board,word,n,m,idx+1,i-1,j);
        boolean d=helper(board,word,n,m,idx+1,i+1,j);
        boolean l=helper(board,word,n,m,idx+1,i,j-1);
        boolean r=helper(board,word,n,m,idx+1,i,j+1);
        board[i][j]=temp;
        return top || d || l || r;

    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean ans=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    ans=helper(board,word,n,m,0,i,j);
                    if(ans){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}