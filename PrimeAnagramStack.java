import java.util.*;

class Node implements Comparable<Node> {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.data, other.data); // Compare in descending order
    }
}

class Stack {
    Node top;

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null || newNode.compareTo(top) > 0) {
            newNode.next = top;
            top = newNode;
        } else {
            Node current = top;
            while (current.next != null && newNode.compareTo(current.next) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class PrimeAnagramStack {

    public static void main(String[] args) {
        int rangeStart = 0;
        int rangeEnd = 1000;

        Stack anagramStack = new Stack();
        Stack primeStack=new Stack();

        // Find and store prime numbers that are anagrams
        for (int i = rangeStart; i <= rangeEnd; i++) {
            if (isPrime(i)){
                primeStack.push(i);
               hasAnagram(i, primeStack,anagramStack);
        }
         }

       
        System.out.println("Prime Numbers that are Anagrams in Reverse Order:");
        while (!anagramStack.isEmpty()) {
            System.out.print(anagramStack.pop() + " ");
        }
    }

    // Function to check if a number is prime
    private static boolean isPrime(int num) {
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

    // Function to check if a number has an anagram in the stack
    private static void hasAnagram(int num, Stack primeStack, Stack anagramStack) {
        Node current = primeStack.top;
        while (current != null) {
            if (areAnagrams(num, current.data)) {
                anagramStack.push(num);
                anagramStack.push(current.data);
                return;
            }
            current = current.next;
        }
    }

    // Function to check if two numbers are anagrams
    private static boolean areAnagrams(int num1, int num2) {
        if(num1==num2)
        return false;
        char[] num1Chars = Integer.toString(num1).toCharArray();
        char[] num2Chars = Integer.toString(num2).toCharArray();
        Arrays.sort(num1Chars);
        Arrays.sort(num2Chars);
        return Arrays.equals(num1Chars, num2Chars);
    }
}
