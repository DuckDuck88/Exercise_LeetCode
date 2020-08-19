package leetCode.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Program: LeetCode
 * @Description: 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习
 * @Author: YaYa
 * @Create: 2020-07-28 09:12
 */
public class 课程表 {
    /**
     * 可以转换为 图中是否存在环
     * 这类问题典型的拓扑排序问题，可以使用邻接表和入度表表示
     * 先将数据存入邻接表，并初始化入度表。
     * 然后将如度为零的点放入队列中进行广度优先搜索，每搜索完一个顶点，则将这个顶点移除，
     * 并将他的后置节点入度减一。最终如果还有顶点入度不为0，则存在环
     *
     * @param numCourses    总课程
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //邻接表
        List<List<Integer>> lists = new ArrayList<>();
        //入度表
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        //初始化邻接表，索引i表示先修课程  get(i)的结果表示依赖此课程的所有课程
        for (int i = 0; i < prerequisites.length; i++) {
            lists.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]]++;
        }
        //队列
        LinkedList<Integer> queues = new LinkedList<>();
        //入度为0的课程入队
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queues.offer(i);
        }
        //bfs
        while (!queues.isEmpty()) {
            int pre = queues.poll();
            //相当于学完一门先修课程，所以总课程减一
            numCourses--;
            //查询依赖此课程的所有课程，并将他们的入度减一。如果入度为0则将其入队。
            for (Integer cur : lists.get(pre)) {
                if (--indegrees[cur] == 0)
                    queues.offer(cur);
            }
        }
        //如果最后还有课程的入度不为0，说明有环
        return numCourses == 0;
    }
}
