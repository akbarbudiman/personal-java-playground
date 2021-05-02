package src.main.java.queue.priorityqueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class ScheduleCourse {

/*
 * 	origin:
 * 	https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3729/
 * 	
 * 	given:
 * 	1. list of course which having duration and time limit
 * 
 * 	return:
 * 	the number of course that can be taken
 *  
 *  the idea :
 *  1. sort the courses by time limit, so that try to take the course with the nearest time limit first
 *  2. save the duration of taken course in PriorityQueue where the lowest duration has the highest priority
 *  3. after trying to take a course, but time limit exceeded, remove one course in PriorityQueue
 *  4. the number of courses taken is the size of PriorityQueue
 */
	
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        Queue<Integer> takenCourseDuration = new PriorityQueue<>(Collections.reverseOrder());
        int takenDuration = 0;
        
        for (int[] course : courses) {
            int thisCourseDuration = course[0];
            takenDuration = takenDuration + thisCourseDuration;
            takenCourseDuration.offer(thisCourseDuration);
            
            int thisCourseTimelimit = course[1];
            if (takenDuration > thisCourseTimelimit) {
                int takenCourseDurationToExclude = takenCourseDuration.poll();
                takenDuration = takenDuration - takenCourseDurationToExclude;
            }
        }
        
        return takenCourseDuration.size();
    }
    
}
