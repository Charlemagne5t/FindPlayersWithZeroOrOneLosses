import java.util.*;

public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < matches.length; i++){
            if(!map.containsKey(matches[i][0])){
                map.put(matches[i][0], 0);
            }
            int countL = map.getOrDefault(matches[i][1], 0);
            countL++;
            map.put(matches[i][1], countL);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() == 0){
                zero.add(e.getKey());
            }
            if(e.getValue() == 1){
                one.add(e.getKey());
            }
        }
        Collections.sort(zero);
        Collections.sort(one);
        ans.add(zero);
        ans.add(one);

        return ans;
    }
}
