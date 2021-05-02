package src.main.java.queue.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 	another version of src.main.java.queue.priorityqueue.StudentServant
 */

class StudentComparable implements Comparable<StudentComparable> {
    private int id;
    private String name;
    private double cgpa;
    
    public StudentComparable(int id, String name, double cgpa) {
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

	@Override
	public int compareTo(StudentComparable o) {
		if (this.cgpa < o.getCgpa())
            return 1;
        else if (this.cgpa > o.getCgpa())
            return -1;
        
        int comparingNameResult = this.name.compareTo(o.getName());
        if (comparingNameResult != 0) {
            return comparingNameResult;
        }
        
        if (this.id > o.getId())
            return 1;
        else if (this.id < o.getId())
            return -1;
        else
            return 0;
	}
}

class PrioritiesUsingComparable {
    public List<StudentComparable> getStudents(List<String> events) {
    	Queue<StudentComparable> studentsQueue = new PriorityQueue<>();
        for (String event : events) {
            if (event.equals("SERVED")) {
                studentsQueue.poll();
            }
            else {
                String[] eventDetail = event.split(" ");
                String name = eventDetail[1];
                double cgpa = Double.valueOf(eventDetail[2]);
                int id = Integer.valueOf(eventDetail[3]);
                StudentComparable newStudent = new StudentComparable(id, name, cgpa);
                studentsQueue.offer(newStudent);
            }
        }
        
        List<StudentComparable> result = new ArrayList<StudentComparable>();
        int studentsSize = studentsQueue.size();
        for (int i = 0 ; i < studentsSize ; i = i + 1) {
            result.add(studentsQueue.poll());
        }
        return result;
    }
}

public class StudentCompareableServant {
	private final static PrioritiesUsingComparable priorities = new PrioritiesUsingComparable();
	
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
		
		List<StudentComparable> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (StudentComparable st: students) {
                System.out.println(st.getName());
            }
        }
	}
}
