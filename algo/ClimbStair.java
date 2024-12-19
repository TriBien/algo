// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:
// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
//
// Example 2:
//
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
//
// Constraints:
// 1 <= n <= 45

class Solution {

    // Solution 1: time complexity O(n), space complexity O(n)
    public int climbStairs1(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] numPaths = new int[n-1];

        // 1 path for stair 1 step
        numPaths[0] = 1;

        // 2 paths for stair 2 step
        numPaths[1] = 2;

        for (int i = 2; i < n - 1; i++) {
            numPaths[i] = numPaths[i-1] + numPaths[i-2];
        }

        return numPaths[n-2] + numPaths[n-3]; 
    }

    // Solution 2: time complexity O(n), space complexity O(1)
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int first = 1;
        int second = 2;
        int temp;
        for (int i = 1; i <= n-2; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
            
        return second;
    }
}