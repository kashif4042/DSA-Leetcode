//TC- O(k log k)
// There are 2 methods:- categorize by Sorting the keys and --> it takes extra Space
// categorize by Frequency --> more Optimal

class Solution {
    private String getFrequencyString(String str){
        // frequency bucket
        int [] freq = new int[26];

        //iteration over each character
        for(char ch : str.toCharArray()){
            freq [ ch - 'a']++;
        }
        // creating frequencyString
        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        for(int i : freq){
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }
        return frequencyString.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList <>();
        }
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            String frequencyString = getFrequencyString(str);
            
            //if the frquency string is present , add it to the map
            if(map.containsKey(frequencyString)){
                map.get(frequencyString).add(str);
            }
            else{
                // create a new List
                List<String> strList = new ArrayList<>();
                strList.add(str);
                map.put(frequencyString , strList);

            }
        }
        return new ArrayList <>(map.values());
        
    }
}