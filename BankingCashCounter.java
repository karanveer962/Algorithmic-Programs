import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class CashCounter {
    private int cashBalance;
    private Queue<Customer> customerQueue;

    public CashCounter() {
        this.cashBalance = 0;
        this.customerQueue = new LinkedList<>();
    }

    public void enqueueCustomer(Customer customer) {  //insert the customer in the queue
        customerQueue.add(customer);
    }

    public void processCustomers() {      // processing the queue
        while (!customerQueue.isEmpty()) {
            Customer customer = customerQueue.poll();
            if (customer.isDeposit()) {
                depositMoney(customer.getAmount());
            } else {
                withdrawMoney(customer.getAmount());
            }
        }
    }

    private void depositMoney(int amount) {  // updating cash balance for customers who deposited money
        cashBalance += amount;
        System.out.println("Deposited: $" + amount);
        displayCashBalance();
    }

    private void withdrawMoney(int amount) {// updating cash balance for customers who withdrawn money
        if (cashBalance >= amount) {
            cashBalance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds. Cannot withdraw $" + amount);
        }
        displayCashBalance();
    }

    private void displayCashBalance() { 
        System.out.println("Cash Balance: $" + cashBalance);
    }
}

class Customer {  //customer class
    private boolean isDeposit;
    private int amount;

    public Customer(boolean isDeposit, int amount) {
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    public boolean isDeposit() {
        return isDeposit;
    }

    public int getAmount() {
        return amount;
    }
}

public class BankingCashCounter {  //main class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CashCounter cashCounter = new CashCounter();

        while (true) {
            System.out.println("Enter customer details (deposit/withdraw amount): ");
            System.out.print("Transaction type (deposit/withdraw): ");
            String transactionType = scanner.next();
            boolean isDeposit = transactionType.equalsIgnoreCase("deposit");
            System.out.print("Enter amount: ");
            int amount = scanner.nextInt();

            Customer customer = new Customer(isDeposit, amount);
            cashCounter.enqueueCustomer(customer);

            System.out.print("Do you want to add another customer? (yes/no): ");
            String anotherCustomer = scanner.next().toLowerCase();
            if (anotherCustomer.equals("no")) {
                break;
            }
        }

        cashCounter.processCustomers();
    }
}
