import java.util.*;

class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }
}
