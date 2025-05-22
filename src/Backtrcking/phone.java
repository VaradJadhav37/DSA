package Backtrcking;
import java.util.*;
public class phone{
    static String[] ph = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> s=new LinkedList<>();
        helper(digits,s,"",0);
        return s;
    }
    public void helper(String digits, List<String> s,String str,int idx)
    {
        if(idx==digits.length())
        {
            if(str!="")
                s.add(str);
            return;
        }

        char ch=digits.charAt(idx);
        String st=ph[(int)(ch-'2')];
        for(int i=0;i<st.length();i++){
            helper(digits,s,str+st.charAt(i),idx+1);
            // str=str.substring(0,i);
        }
    }
}
