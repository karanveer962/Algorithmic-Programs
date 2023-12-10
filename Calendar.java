public class Calendar {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Calendar <month> <year>");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        printCalendar(month, year);
    }

    private static void printCalendar(int month, int year) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        System.out.printf("%tB %d%n", calendar, year);
        System.out.println("S  M  T  W  Th  F  S");

        int firstDayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        System.out.print(firstDayOfWeek+" "+daysInMonth);
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("   ");
        }
         
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);

            if ((day + firstDayOfWeek - 1) % 7 == 0 || day == daysInMonth) {
                System.out.println();
            }
        }
    }
}
