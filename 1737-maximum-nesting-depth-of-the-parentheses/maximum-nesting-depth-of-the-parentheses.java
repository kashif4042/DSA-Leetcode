class Solution {
    public int maxDepth(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int depth = 0;

            for (int j = 0; j <= i; j++) {
                char ch = s.charAt(j);
                if (ch == '(') {
                    depth++;
                } else if (ch == ')') {
                    depth--;
                }
            }

            answer = Math.max(answer, depth);
        }

        return answer;
    }
}