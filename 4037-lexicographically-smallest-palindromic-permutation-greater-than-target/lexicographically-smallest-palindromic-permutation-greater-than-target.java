import java.util.HashMap;
import java.util.TreeMap;


class Solution {
    String ans = "{";
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            arr[x - 'a']++;
        }
        String mid = "";
        TreeMap<Character, Integer> firstHalf = new TreeMap<>();
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                if (mid.equals("")) {
                    mid += (char) (i + 'a');
                    arr[i]--;
                } else {
                    return "";
                }
            }
            if (arr[i]==0 ) {
                continue;
            }
            firstHalf.put((char) (i + 'a'), arr[i] / 2);
        }
        StringBuilder first = new StringBuilder();
        s(first, mid, firstHalf, target);
        if (ans.equals("{")) {
            return "";
        } else {
            return ans;
        }
    }
    
    public void s(StringBuilder curr, String mid, TreeMap<Character, Integer> firstHalf, String target) {
        int i = curr.length();
        if (i >= target.length() / 2) {
            StringBuffer rev = new StringBuffer(curr);
            rev.reverse();
            String newString = curr + mid + rev.toString();
            if (newString.compareTo(target) > 0 && newString.compareTo(ans) < 0) {
                ans = newString;
            }
            return;
        }

        Character uppderbound = firstHalf.higherKey(target.charAt(i));
        if (uppderbound != null) {
            StringBuilder temp = new StringBuilder(curr).append(uppderbound);
            firstHalf.put(uppderbound, firstHalf.get(uppderbound) - 1);
            for (Character ch : firstHalf.keySet()) {
                int count = firstHalf.get(ch);
                for (int j = 0; j < count; j++) {
                    temp.append(ch);
                }
            }
            String newString = temp.toString() + mid + temp.reverse().toString();
            if (newString.compareTo(target) > 0 && newString.compareTo(ans) < 0) {
                ans = newString;
            }
            firstHalf.put(uppderbound, firstHalf.get(uppderbound) + 1);
        }

        Character x=target.charAt(i);
        if (!firstHalf.containsKey(x)) {
            return;
        }
        curr.append(x);
        firstHalf.put(x, firstHalf.get(x) - 1);
        if (firstHalf.get(x) == 0) {
            firstHalf.remove(x);
        }
        s(curr, mid, firstHalf, target);
    }
    
}