class Solution {
    String s;
    int i;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        i = 0;

        Set<String> result = parse();

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    Set<String> parse() {
        Set<String> result = new HashSet<>();

        while (i < s.length() && s.charAt(i) != '}') {
            Set<String> current;

            if (s.charAt(i) == '{') {
                i++;
                current = parse();
                i++;
            } else if (s.charAt(i) == ',') {
                i++;
                current = parse();
                result.addAll(current);
                return result;
            } else {
                current = new HashSet<>();
                current.add(String.valueOf(s.charAt(i)));
                i++;
            }

            if (result.isEmpty()) {
                result.addAll(current);
            } else {

                Set<String> next = new HashSet<>();

                for (String a : result) {
                    for (String b : current) {
                        next.add(a + b);
                    }
                }

                result = next;
            }

        } 
        return result;
    }
}