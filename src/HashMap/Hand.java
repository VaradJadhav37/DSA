package HashMap;
import java.util.*;
public class Hand  {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            tm.put(hand[i],tm.getOrDefault(hand[i],0)+1);
        }
        while (!tm.isEmpty()) {
            int first = tm.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int curr = first + i;
                if (!tm.containsKey(curr)) return false;

                tm.put(curr, tm.get(curr) - 1);
                if (tm.get(curr) == 0) {
                    tm.remove(curr);
                }
            }
        }
        return true;
    }
}
