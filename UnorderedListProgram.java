import java.io.*;
import java.util.*;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class UnorderedList<T> {
    private Node<T> head;

    public UnorderedList() {
        this.head = null;
    }

    public void add(T data) {   //add the data to the list
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
    
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
    
        current.next = newNode;
    }

    public boolean search(T data) {  //search for the data in the list if present
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(T data) {  //removing the node from the list 
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        prev.next = current.next;
    }

    public void display() {  //printing the onordered list
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void saveToFile(String filename) {   //finally saving the modified list in a new file
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Node<T> current = head;
            while (current != null) {
                writer.print(current.data + " ");
                current = current.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class UnorderedListProgram{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnorderedList<String> wordList = new UnorderedList<>();

        // Reading text from file
        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    wordList.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("List of Words:");
        wordList.display();

        System.out.println("Enter a word to search or add/remove:");
        String userInput = scanner.next();

        if (wordList.search(userInput)) {
            System.out.println(userInput + " found. Removing from the list.");
            wordList.remove(userInput);
        } else {
            System.out.println(userInput + " not found. Adding to the list.");
            wordList.add(userInput);
        }

        System.out.println("Modified List of Words:");
        wordList.display();

        wordList.saveToFile("output.txt");

        scanner.close();
    }
}
