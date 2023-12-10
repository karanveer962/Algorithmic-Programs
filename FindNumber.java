import java.util.*;



public class FindNumber {
      public static int steps=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of N (2^n): ");
        int N = sc.nextInt();

        // System.out.println("Think of a number between 0 and " + (N - 1));

        int low = 0;
        int high = (int)1e5;

        // Call the recursive method to find the number
        int result = findNumber(low, high, sc);

        System.out.println("The number you thought of is: " + result);
        System.out.println("Total Steps Taken: " + steps);

        sc.close();
    }

    private static int findNumber(int low, int high, Scanner sc) {
       steps++;
        if (low <= high) {
            int mid = low + (high - low) / 2;    //binary searching for that number

            System.out.println("Is the number between " + low + " and " + mid + " ? (true/false)");
            boolean response = sc.nextBoolean();  //taking user reponse 

            if (response) {
                // Number is in the lower half
                return findNumber(low, mid - 1, sc);
            } else {
                // Number is in the upper half
                return findNumber(mid + 1, high, sc);
            }
            
        } else {
            // Found the number
            return low;
        }
    }
}
