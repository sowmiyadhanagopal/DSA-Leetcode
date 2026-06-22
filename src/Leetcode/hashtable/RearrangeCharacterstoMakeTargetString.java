package Leetcode.hashtable;
import java.util.*;
public class RearrangeCharacterstoMakeTargetString {


    class Solution {
        public int rearrangeCharacters(String s, String target) {

            HashMap<Character, Integer> sMap = new HashMap<>();
            HashMap<Character, Integer> tMap = new HashMap<>();


            for (char ch : s.toCharArray()) {
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            }

            for (char ch : target.toCharArray()) {
                tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
            }

            int ans = Integer.MAX_VALUE;

            for (char ch : tMap.keySet()) {
                int sCount = sMap.getOrDefault(ch, 0);
                int tCount = tMap.get(ch);

                ans = Math.min(ans, sCount / tCount);
            }

            return ans;
        }
    }
}
