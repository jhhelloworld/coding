package leetcode;

/**
 * jh
 * 2019年01月22日  19：54
 * <p>
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 */
public class Q_744_FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) {
                return c;
            }
        }

        return letters[0];
    }

    /**
     * fast
     */
    public char nextGreatestLetter2(char[] letters, char target) {
        int sp = 0, ep = letters.length - 1;
        while(sp <= ep) {
            int mid = (sp + ep) / 2;
            if(sp == ep) {
                return letters[sp] > target ? letters[sp] : letters[0];
            }
            if(letters[mid] <= target) {
                sp = mid + 1;
            }
            else {
                ep = mid;
            }
        }
        return letters[0];
    }



}