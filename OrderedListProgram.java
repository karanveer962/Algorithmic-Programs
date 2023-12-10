import java.io.*;
import java.util.*;

class Node<T extends Comparable<T>> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    public int compareTo(Node<T> obj){
        return this.data.compareTo(obj.data);
    }
}

class OrderedList<T extends Comparable<T>> {
    private Node<T> head;

    public void readFromFile(String filename) { //reading from the file
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                T data = (T) scanner.next();
                insertInOrder(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertInOrder(T data) {  //inserting in list in an ordered way
        Node<T> newNode = new Node<>(data);
        if (head == null || head.data.equals(data)) {
            newNode.next = head;
            head = newNode;
            return;
        }
    
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
    
        newNode.next = current.next;
        current.next = newNode;
    }
    

    public void display() {  //printing the list
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void insertOrRemove(T data) {
        boolean flag=contains(data);
        if (flag) {
            remove(data);
        } else {
            insertInOrder(data);
        }
    }

    private boolean contains(T data) {  //search for the element in the list
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void remove(T data) {  // removing the node from the list
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void saveToFile(String filename) { // finally saving the modified list
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

public class OrderedListProgram {
    public static void main(String[] args) {
        OrderedList<Integer> orderedList = new OrderedList<>();
        orderedList.readFromFile("numbers.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Current List:");
        orderedList.display();

        System.out.print("Enter a number to insert or remove: ");
        int userInput = scanner.nextInt();

        orderedList.insertOrRemove(userInput);

        System.out.println("Updated List:");
        orderedList.display();

        orderedList.saveToFile("output.txt");
        System.out.println("List saved to output.txt");
    }
}
