package com.hou.leetcode.solution.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-19 17:55
 */
public class CourseSchedule207Solution {

    /**
     * 拓扑排序，如果图中没有环，那么最后所有的节点的入度都应该是0
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度
        int[] in = new int[numCourses];
        for (int i=0; i<prerequisites.length; i++) {
            in[prerequisites[i][0]]++;
        }
        //邻接表表示图
        List<Integer>[] graph = new List[numCourses];
        for (int i=0; i<prerequisites.length; i++) {
            if (graph[prerequisites[i][1]] == null) {
                graph[prerequisites[i][1]] = new ArrayList<>();
            }
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (graph[course] == null) {
                continue;
            }
            for (int next : graph[course]) {
                in[next]--;
                if (in[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        for (int i=0; i<numCourses; i++) {
            if (in[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
