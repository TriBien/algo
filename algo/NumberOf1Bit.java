// Ref: https://leetcode.com/problems/number-of-1-bits/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        
        return count;
    }
}