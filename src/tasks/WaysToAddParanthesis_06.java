//leetcode : https://leetcode.com/problems/different-ways-to-add-parentheses/description/
package tasks;

import java.util.*;
public class WaysToAddParanthesis_06 {

    public Map<String,List<Integer>> dp = new HashMap<>();         //memoization

    public List<Integer> diffWaysToCompute(String expression) {
        if(dp.containsKey(expression)){
            return dp.get(expression);
        }
        List<Integer> result  = new ArrayList<>();
        boolean isNumber = true;

        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*'){
                isNumber = false;

                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);


                for(int l:leftResults){
                    for(int r:rightResults){
                        switch(ch){
                            case '+':
                                result.add(l + r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                        }
                    }
                }
            }
        }

        if(isNumber){
            result.add(Integer.parseInt(expression));
        }
        return result;
    }

    public static void main(String[] args) {
        WaysToAddParanthesis_06 obj = new WaysToAddParanthesis_06();
        System.out.println(obj.diffWaysToCompute("2-1-1"));
    }
}
