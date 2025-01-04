// Ref: https://leetcode.com/problems/course-schedule/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] ingredient = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {

            // increase the ingredient - the number of dependencies
            ingredient[prerequisites[i][0]]++;

            // update the graph key-values with neighbors 
            // key: the course id
            // values: the courses we can register after we register the course key
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int enrolled = 0;
        for (int i = 0; i < numCourses; i++) {
            if (ingredient[i] == 0) {
                queue.add(i);
                enrolled++;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor: graph.get(node)) {
                ingredient[neighbor]--;

                if (ingredient[neighbor] == 0) {
                    queue.add(neighbor);
                    enrolled++;
                }
            }
        }
        
        return enrolled == numCourses;
    }
}