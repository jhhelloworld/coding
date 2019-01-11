package leetcode;

import java.util.HashSet;

/**
 * jh
 * 2019年01月11日  10：25
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.  Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class Q_771_JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.length()==0 || S==null || S.length()==0)
            return 0;
        HashSet<Character> chars = new HashSet<Character>();
        for(int i = 0;i<J.length();i++){
            chars.add(J.charAt(i));
        }
        int result = 0;
        for(int i =0;i<S.length();i++){
            if (chars.contains(S.charAt(i))){
                result++;
            }
        }
        return result;



    }
}