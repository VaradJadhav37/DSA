package Heaps;
import java.util.*;
public class Weakest
 {
    public class Info implements Comparable<Info>{
        int idx,s;
        Info(int i,int s){
            this.idx=i;
            this.s=s;
        }
        @Override
        public int compareTo(Info a){
            if(a.s==this.s){
                return this.idx-a.idx;
            }
            else{
                return this.s-a.s;
            }
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Info> pq=new PriorityQueue<>();
        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[i].length;j++){
                sum+=mat[i][j];
            }
            pq.add(new Info(i,sum));
        }
        int[] res =new int[k];
        for(int i=0;i<k;i++)
        {
            Info curr=pq.remove();
            res[i]=curr.idx;
        }
        return res;
    }
}

