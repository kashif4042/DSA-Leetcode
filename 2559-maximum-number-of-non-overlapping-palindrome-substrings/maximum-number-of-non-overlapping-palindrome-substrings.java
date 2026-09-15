class Solution {

    public int maxPalindromes(String s, int k) {

        char[] arr = s.toCharArray();
        int n = arr.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (isPalidrom(arr, i, i + k - 1)) {
                ans++;
                i = i + k - 1;
                continue;
            }

            if (isPalidrom(arr, i, i + k)) {
                ans++;
                i = i + k;
                continue;
            }
        }

        return ans;
    }

    private boolean isPalidrom(char[] arr, int start, int end) {

        if (end >= arr.length) {
            return false;
        }

        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}