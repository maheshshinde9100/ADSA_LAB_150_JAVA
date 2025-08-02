import java.util.*;
class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        return divideAndConquer(s);
    }
    public String divideAndConquer(String str){
        if(str.length() <2 ){
            return "";
        }
        Set<Character> set = new HashSet<>();
        for(Character c: str.toCharArray()){
            set.add(c);
        }
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(!set.contains(Character.toLowerCase(c)) || !set.contains(Character.toUpperCase(c))){
                String left = divideAndConquer(str.substring(0,i));
                String right = divideAndConquer(str.substring(i+1));

                return left.length()>=right.length()? left : right;
            }
        }
        return str;
    }
  public static void main(String[] args){
    LongestNiceSubstring obj = new LongestNiceSubstring();
//  Input: s = "YazaAay"
//  Output: "aAa"
System.out.println(obj.longestNiceSubstring("YazaAay"));
    
  }
}
