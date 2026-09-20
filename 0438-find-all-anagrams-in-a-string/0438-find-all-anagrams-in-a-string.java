import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       return new AbstractList<Integer>() {
            List<Integer> ans;
            private void init(){
                if(ans != null)
                    return;
                HashMap<Character, Integer> map = new HashMap<>();
                for(int i = 0; i < p.length(); i++){
                    map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
                }
                ans = new ArrayList<>();
                int i = 0;
                int count = map.size();
                int j = 0;
                int k = p.length();
                while(j < s.length()){
                    if(map.containsKey(s.charAt(j))){
                        map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                        if(map.get(s.charAt(j)) == 0) count--;
                    }
                    if(j - i + 1 < k){
                        j++;
                    }else if(j - i + 1 == k){
                        if(count == 0){
                            ans.add(i);
                        }
                        if(map.containsKey(s.charAt(i))){
                            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                            if(map.get(s.charAt(i)) == 1) count++;
                        }
                        i++;
                        j++;
                    }
                }
            }
            @Override
            public Integer get(int index) {
                if(ans == null)
                    init();
                return ans.get(index);
            }

            @Override
            public int size() {
                if(ans == null)
                    init();
                return ans.size();
            }
        };

    }
}