public class CheckAnagram {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] freq = new int[256];
        for (char ch : s1.toCharArray()) freq[ch]++;
        for (char ch : s2.toCharArray()) freq[ch]--;
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }
}