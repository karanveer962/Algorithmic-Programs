import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeAnagram2dArray {

    public static void main(String[] args) {
        int rangeStart = 0;
        int rangeEnd = 1000;

        
        int arraySize = (rangeEnd - rangeStart) / 100 + 1;

        // Create a 2D array to store prime numbers and their anagrams
        List<Integer>[] primeArray = new List[arraySize];
        List<Integer>[] anagramArray = new List[arraySize];

        // Initialize the arrays
        for (int i = 0; i < arraySize; i++) {
            primeArray[i] = new ArrayList<>();
            anagramArray[i] = new ArrayList<>();
        }

        // Find and store prime numbers and anagrams
        for (int i = rangeStart; i <= rangeEnd; i++) {
            if (isPrime(i)) {
                primeArray[i / 100].add(i);
                isAnagram(i, primeArray[i / 100],anagramArray);
            }
        }

        // Display the 2D arrays
        displayPrimeAnagramArrays(primeArray, "Prime Numbers");
        displayPrimeAnagramArrays(anagramArray, "Anagram Numbers");
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

    
    private static void isAnagram(int num, List<Integer> anagramList,List<Integer>[] anagramArray) {
        for (int anagramNum : anagramList) {
            if (areAnagrams(num, anagramNum)) {
                anagramArray[num/100].add(num);
                anagramArray[num/100].add(anagramNum);
                return ;
            }
        }
    }

    private static boolean areAnagrams(int num1, int num2) {// Function to check if two numbers are anagrams
        if(num1==num2)
        return false;
        char[] num1Chars = Integer.toString(num1).toCharArray();
        char[] num2Chars = Integer.toString(num2).toCharArray();
        Arrays.sort(num1Chars);
        Arrays.sort(num2Chars);
        return Arrays.equals(num1Chars, num2Chars);
    }

   
    private static void displayPrimeAnagramArrays(List<Integer>[] array, String title) { // Function to display the 2D array
        System.out.println(title + ":");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Range " + (i * 100) + "-" + ((i + 1) * 100 - 1) + ": ");
            for (int num : array[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
