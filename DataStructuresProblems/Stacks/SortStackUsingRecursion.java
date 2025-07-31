import java.util.*;

class SortStackUsingRecursion {
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack, x);
        }
    }

    private static void insertInSortedOrder(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, x);
            stack.push(temp);
        }
    }
}
