public class ToggleCase {
    public static String toggle(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) result.append(Character.toLowerCase(ch));
            else if (Character.isLowerCase(ch)) result.append(Character.toUpperCase(ch));
            else result.append(ch);
        }
        return result.toString();
    }
}