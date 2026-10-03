class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] intervals = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    intervals[stack.pop()] = i;
                }
            }
        }
        int max = 0;
        int interval = 0;
        for (int i = 0; i < intervals.length; i++) {
            int j = intervals[i];
            if (j != 0) {
                interval += j - i + 1;
                i = j;
            } else {
                max = Math.max(max, interval);
                interval = 0;
            }
        }
        max = Math.max(max, interval);
        return max;
    }
}