class Solution {
    public boolean isPalindromic(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            int ascii = s.charAt(i);

            String binary = Integer.toBinaryString(ascii);

            // Add leading zeros until we have 8 bits
            while (binary.length() < 8) {
                binary = "0" + binary;
            }

            sb.append(binary);
        }

        int i = 0;
        int j = sb.length() - 1;

        while (i < j) {

            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}