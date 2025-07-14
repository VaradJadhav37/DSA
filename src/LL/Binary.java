package LL;

public class Binary  {
    public int getDecimalValue(ListNode head) {
        int ans=0;
        while(head!=null){
            ans=ans<<1;
            if(head.val==1){
                ans+=1;
            }

            head=head.next;
        }
        return ans;
    }
}