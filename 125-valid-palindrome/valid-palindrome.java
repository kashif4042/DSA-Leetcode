class Solution {
    public boolean isPalindrome(String s) {
        int i=0, e=s.length()-1;
        while(i<e) {
            if(!Character.isLetterOrDigit(s.charAt(i))) { //Skip if not Alphanumeric
                i++;
            }else if(!Character.isLetterOrDigit(s.charAt(e))) { //Skip if not Alphanumeric
                e--;
            }else if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(e))) { //Move pointer if both are equal
                i++;
                e--;
            }else { //Return false if not equal
                return false;
            }
        }
        return true; //Return true if all pointers passed
    }
}