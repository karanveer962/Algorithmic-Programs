import java.util.Arrays;
import java.util.Scanner;

class Task implements Comparable<Task> {
    int deadline;
    int time;

    public Task(int deadline, int time) {   //constructor
        this.deadline = deadline;
        this.time = time;
    }

    @Override
    public int compareTo(Task other) {  //implemented sorting in ascending order of deadline
        return Integer.compare(this.deadline, other.deadline);
    }
}

public class ScheduleTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of tasks: ");
        int T = scanner.nextInt();

        Task[] tasks = new Task[T];

        System.out.println("Enter the deadline and time for each task:");

        for (int i = 0; i < T; i++) {
            int D = scanner.nextInt();
            int M = scanner.nextInt();
            tasks[i] = new Task(D, M);
        }

        Arrays.sort(tasks);  //sorted on the basis of comparable interface

        int cumulativeTime = 0;
        System.out.println("Maximum overshoot for each task:");

        for (int i = 0; i < T; i++) {
            cumulativeTime += tasks[i].time;     //prefix sum
            int overshoot = Math.max(0, cumulativeTime - tasks[i].deadline);
            System.out.println("Task "+(i+1)+":"+overshoot);
        }

        scanner.close();
    }
}
