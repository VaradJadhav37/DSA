package Backtrcking;

class Sudoku {
    public boolean isSafe(char[][] board,int row,int col,char i){
        for(int j=0;j<board.length;j++)
        {
            if(board[row][j]==i)
                return false;
            if(board[j][col]==i)
                return false;
        }
        int sr=row-row%3;
        int sc=col-col%3;
        for(int j=0;j<3;j++){
            for(int k=0;k<3;k++)
            {
                if(board[sr+j][sc+k]==i)
                    return false;
            }
        }
        return true;

    }
    public boolean helper(char[][] board,int row,int col){
        if(row==board.length)
            return true;
        int nrow=0;
        int ncol=0;
        if(col!=board.length-1){
            nrow=row;
            ncol=col+1;
        }
        else{
            nrow=row+1;
            ncol=0;
        }
        if(board[row][col]!='.')
        {
            if(helper(board,nrow,ncol)){
                return true;
            }
        }
        else{
            for(int i=1;i<=9;i++){
                char c=(char)(i+'0');
                if(isSafe(board,row,col,c)){
                    board[row][col]=(char)(i+'0');
                    if(helper(board,nrow,ncol)){
                        return true;
                    }
                    else{
                        board[row][col]='.';
                    }
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}