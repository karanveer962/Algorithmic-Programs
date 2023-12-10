import java.util.*;
class Queue {
    Node front, rear;

    public Queue() {  //queue class
        this.front = this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

public class PrimeAnagramQueue {

    public static void main(String[] args) {
        int rangeStart = 0;
        int rangeEnd = 1000;

        Queue primeQueue = new Queue();
        Queue anagramQueue = new Queue();

        
        for (int i = rangeStart; i <= rangeEnd; i++) {// Find and store prime numbers that are anagrams
            if (isPrime(i)) {
                primeQueue.enqueue(i);
                hasAnagram(i, primeQueue, anagramQueue);
            }
        }

        
        System.out.println("\nPrime Numbers that are Anagrams from the Queue:");
        while (!anagramQueue.isEmpty()) {
            System.out.print(anagramQueue.dequeue() + " ");
        }
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

    
    private static void hasAnagram(int num, Queue primeQueue, Queue anagramQueue) {// Function to check if a number has an anagram in the queue
        Node current = primeQueue.front;
        while (current != null) {
            if (areAnagrams(num, current.data)) {
                anagramQueue.enqueue(num);
                anagramQueue.enqueue(current.data);
                return;
            }
            current = current.next;
        }
    }

  
    private static boolean areAnagrams(int num1, int num2) {  // Function to check if two numbers are anagrams
        if (num1 == num2)
            return false;
        char[] num1Chars = Integer.toString(num1).toCharArray();
        char[] num2Chars = Integer.toString(num2).toCharArray();
        Arrays.sort(num1Chars);
        Arrays.sort(num2Chars);
        return Arrays.equals(num1Chars, num2Chars);
    }
}
