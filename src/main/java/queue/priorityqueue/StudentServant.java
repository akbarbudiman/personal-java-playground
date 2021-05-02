package src.main.java.queue.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 	origin :
 * 	https://www.hackerrank.com/challenges/java-priority-queue/problem
 * 
 * 	given :
 * 	1. rule of comparing
 * 	2. events (insertion or removal)
 * 
 * 	return :
 * 	final queue
 * 
 * 	idea :
 * 	1. simple pojo for the entity
 * 	2. create Comparator class
 * 	3. use PriorityQueue to store the list of pojo
 */

class Student {
    private int id;
    private String name;
    private double cgpa;
    
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCgpa() {
        return this.cgpa;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student obj1, Student obj2) {
        if (obj1.getCgpa() < obj2.getCgpa())
            return 1;
        else if (obj1.getCgpa() > obj2.getCgpa())
            return -1;
        
        int comparingNameResult = obj1.getName().compareTo(obj2.getName());
        if (comparingNameResult != 0) {
            return comparingNameResult;
        }
        
        if (obj1.getId() > obj2.getId())
            return 1;
        else if (obj1.getId() < obj2.getId())
            return -1;
        else
            return 0;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
    	Queue<Student> studentsQueue = new PriorityQueue<>(2, new StudentComparator());
        for (String event : events) {
            if (event.equals("SERVED")) {
                studentsQueue.poll();
            }
            else {
                String[] eventDetail = event.split(" ");
                String name = eventDetail[1];
                double cgpa = Double.valueOf(eventDetail[2]);
                int id = Integer.valueOf(eventDetail[3]);
                Student newStudent = new Student(id, name, cgpa);
                studentsQueue.offer(newStudent);
            }
        }
        
        List<Student> result = new ArrayList<Student>();
        int studentsSize = studentsQueue.size();
        for (int i = 0 ; i < studentsSize ; i = i + 1) {
            result.add(studentsQueue.poll());
        }
        return result;
    }
}

public class StudentServant {
	private final static Priorities priorities = new Priorities();
	
	public static void main(String[] args) {
		List<String> events = new ArrayList<>();
		events.add("ENTER John 3.75 50");
		events.add("ENTER Mark 3.8 24");
		events.add("ENTER Shafaet 3.7 35");
		events.add("SERVED");
		events.add("SERVED");
		events.add("ENTER Samiha 3.85 36");
		events.add("SERVED");
		events.add("ENTER Ashley 3.9 42");
		events.add("ENTER Maria 3.6 46");
		events.add("ENTER Anik 3.95 49");
		events.add("ENTER Dan 3.95 50");
		events.add("SERVED");
		
		List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
	}
}
