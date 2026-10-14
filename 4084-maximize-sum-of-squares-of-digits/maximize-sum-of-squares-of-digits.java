   class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if ((num * 9) < sum) return "";

        int start = Math.min(9, sum) + 1;

        int mx = 0;
        char[] mxArr = new char[num];
        while (--start > 0) {
            if ((num * start) < sum) return new String(mxArr);

            int number = num, summation = sum;
            int score = 0, curr = start;
            char[] arr = new char[num];
            int q = 0;
            while ((number > 0) && (summation >= 0)) {
                arr[q++] = (char) (curr + '0');
                score += curr * curr;
                number--; summation -= curr;
                curr = Math.min(9, summation);
            } 

            if (score > mx) {
                mx = score; 
                System.arraycopy(arr, 0, mxArr, 0, num);
            } else if (score == mx) {
                if (compareArr(arr, mxArr) > 0) System.arraycopy(arr, 0, mxArr, 0, num);
            } 
        } 

        return new String(mxArr);
    } 

    public static int compareArr(char[] arr, char[] mxArr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != mxArr[i]) return arr[i] - mxArr[i];
        } 

        return 0;
    }
}