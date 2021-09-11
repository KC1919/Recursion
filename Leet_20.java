/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.


Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]


Example 2:

Input: n = 1
Output: ["()"]

*/

import java.util.*;
class Leet_20 {
    public List<String> generateParenthesis(int n) 
    {
        List<String>list=new ArrayList<>();
        helper(n,n,list,"");
        return list;
    }
    
    void helper(int op, int cp, List<String>list, String asf)
    {
        if(op>cp)   //at any point if the number of closing paranthesis used exceeds the no. of opening paranthesis
            return;   //means the combination formed will no be balanced, so we return without making any further calls.
        
        if(op==0 && cp==0)  //if all the opening and closing paranthesis have been used,
        {                   //means the valid combination would have been formed, so we add it to the list
            list.add(asf);
            return;
        }
        
        if(op!=0 && cp!=0)    //if we have both opening and closing paranthesis left
        {                     //then we have 2 choices, either we can choose the next paranthesis     
            helper(op-1,cp,list,asf+"(");  //as the opening paranthesis
            helper(op,cp-1,list,asf+")");  //or as tyhe closing paranthesis
        }
        else if(op==0)    //if all the opening paranthesis have been used
        { 
            helper(op,cp-1,list,asf+")"); //then we have only one choice, to choose the closing paranthesis
        }
        else   //if the closing paranthesis have exhausted
        { 
            helper(op-1,cp,list,asf+"(");  //then we can only choose the opening paranthesis
        }
    }
}