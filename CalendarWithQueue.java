import java.util.LinkedList;
import java.util.Queue;

class WeekDay {
    private String day;
    private String date;

    public WeekDay(String day, String date) {
        this.day = day;
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }
}

class Week {
    private Queue<WeekDay> days;

    public Week() {
        this.days = new LinkedList<>();
    }

    public void addDay(WeekDay day) {
        days.add(day);
    }

    public Queue<WeekDay> getDays() {
        return days;
    }
}

public class CalendarWithQueue {
    public static void main(String[] args) {
       
        Week week = new Week();  //week object created
        week.addDay(new WeekDay("S", "1"));
        week.addDay(new WeekDay("M", "2"));
        week.addDay(new WeekDay("T", "3"));
        week.addDay(new WeekDay("W", ""));
        week.addDay(new WeekDay("Th", "5"));
        week.addDay(new WeekDay("F", "6"));
        week.addDay(new WeekDay("S", "7"));

       
        Queue<Week> calendarQueue = new LinkedList<>(); // Add the Week to a Queue
        calendarQueue.add(week);

        
        displayCalendar(calendarQueue);   // Display the Calendar
    }

    private static void displayCalendar(Queue<Week> calendarQueue) {
       
        while (!calendarQueue.isEmpty()) {
            Week currentWeek = calendarQueue.poll();
            Queue<WeekDay> days = currentWeek.getDays();
    
            while (!days.isEmpty()) {
                WeekDay currentDay = days.poll();
                String date = currentDay.getDate().isEmpty() ? " " : currentDay.getDate();
                System.out.printf("%-3s%s ", currentDay.getDay(), date);
                System.out.println();
            }
            System.out.println();
        }
    }
}
