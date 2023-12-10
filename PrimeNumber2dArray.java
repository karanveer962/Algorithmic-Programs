import java.util.*;

public class PrimeNumber2dArray {

    public static void main(String[] args) {
        int rangeStart = 0;
        int rangeEnd = 1000;

       
        int arraySize = (rangeEnd - rangeStart) / 100 + 1; // Calculate the size of the 2D array based on the range

        
        int[][] primeArray = new int[arraySize][];// Create a 2D array to store prime numbers

       x
        for (int i = 0; i < arraySize; i++) { // Display the prime numbers in the 2D array
            primeArray[i] = findPrimesInRange(rangeStart, rangeStart + 100);
            rangeStart += 100;
        }

       
        displayPrimeArray(primeArray);  // Display the prime numbers in the 2D array
    }

   
    private static int[] findPrimesInRange(int start, int end) {
        List<Integer> primes=new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
               primes.add(i);
            }
        }

      
        int[] result = new int[primes.size()];  // Create a new array with the exact size needed
        for(int i=0;i<result.length;i++)
              result[i]=primes.get(i);
        return result;
    }

   
    private static boolean isPrime(int num) { // Function to check if a number is prime
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void displayPrimeArray(int[][] primeArray) {
        // Function to display the 2D array
        for (int i = 0; i < primeArray.length; i++) {
            System.out.print("Range " + (i * 100) + "-" + ((i + 1) * 100 - 1) + ": ");
            for (int j = 0; j < primeArray[i].length && primeArray[i][j] != 0; j++) {
                System.out.print(primeArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
