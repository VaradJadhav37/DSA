package Backtrcking;
import java.util.*;
public class CombSum {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> li= new ArrayList<>();

            helper(candidates,0,li,target,new ArrayList<>());
            return li;
        }
        static  Set<List<Integer>> s = new HashSet<>();
        public void helper(int[] arr,int idx,List<List<Integer>> li,int target,List <Integer> a)
        {
            if(target<0 || idx==arr.length){
                return;
            }
            if(target==0){
                if(!s.contains(a)){
                    li.add(new ArrayList<>(a));
                    s.add(a);
                }
                return;
            }
            a.add(arr[idx]);
            helper(arr,idx+1,li,target-arr[idx],a);
            helper(arr,idx,li,target-arr[idx],a);
            a.remove(a.size()-1);
            helper(arr,idx+1,li,target,a);
        }
    }

