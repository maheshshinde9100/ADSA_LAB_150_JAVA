package DivideAndConquer;

public class LongestNiceSubstring_14 {

    public static String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(Character.toLowerCase(c)) != -1 &&
                    s.indexOf(Character.toUpperCase(c)) != -1) {
                continue; // both cases exist, continue
            }

            // split and recurse
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));
            return (left.length() >= right.length()) ? left : right;
        }

        return s; // if no split point found, entire string is nice
    }

    public static void main(String[] args) {
        String input = "YazaAay";
        String result = longestNiceSubstring(input);
        System.out.println("Longest Nice Substring: " + result);  // Output: "aAa"
    }
}
