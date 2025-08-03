package tasks;
import java.util.*;

/*Q. Insert operators between digits to match a target value
* input: "123",6
* output: ["1+2+3","1*2*3"]
 */
public class ExpressionAddOperators_07 {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void dfs(String num, int target, int index, long calc, long prevOperand, String path, List<String> result) {
        if (index == num.length()) {
            if (calc == target) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Skipping numbers with leading zero
            if (i != index && num.charAt(index) == '0') break;

            String currentStr = num.substring(index, i + 1);
            long current = Long.parseLong(currentStr);

            if (index == 0) {
                // First number, just pass it onn
                dfs(num, target, i + 1, current, current, currentStr, result);
            } else {
                // Addition
                dfs(num, target, i + 1, calc + current, current, path + "+" + currentStr, result);

                // Subtraction
                dfs(num, target, i + 1, calc - current, -current, path + "-" + currentStr, result);

                // Multiplication
                dfs(num, target, i + 1, calc - prevOperand + prevOperand * current, prevOperand * current, path + "*" + currentStr, result);
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators_07 obj = new ExpressionAddOperators_07();
        System.out.println(obj.addOperators("123", 6));  // Output: ["1+2+3", "1*2*3"]
        System.out.println(obj.addOperators("232", 8));  // Output: ["2*3+2", "2+3*2"]
    }
}
