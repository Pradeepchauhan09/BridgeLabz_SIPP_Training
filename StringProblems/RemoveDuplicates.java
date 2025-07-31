public class RemoveDuplicates {
    public static String remove(String str) {
        String result = "";
        for (char ch : str.toCharArray()) {
            if (result.indexOf(ch) == -1) result += ch;
        }
        return result;
    }
}