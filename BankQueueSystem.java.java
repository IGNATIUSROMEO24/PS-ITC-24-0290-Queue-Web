import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BankQueueSystem {
    public static void main(String[] args) {
        Queue<String> customers = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== BANK QUEUE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. Display waiting customers");
            System.out.println("4. View next customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.print("Please enter a number from 1 to 5: ");
                input.next();
            }
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer's name: ");
                    String name = input.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Customer name cannot be empty.");
                    } else {
                        customers.offer(name);
                        System.out.println(name + " has joined the queue.");
                    }
                    break;

                case 2:
                    String served = customers.poll();
                    if (served == null) {
                        System.out.println("The queue is empty. No customer to serve.");
                    } else {
                        System.out.println("Now serving: " + served);
                    }
                    break;

                case 3:
                    if (customers.isEmpty()) {
                        System.out.println("There are no waiting customers.");
                    } else {
                        System.out.println("Waiting customers (first to last):");
                        int number = 1;
                        for (String customer : customers) {
                            System.out.println(number + ". " + customer);
                            number++;
                        }
                    }
                    break;

                case 4:
                    String next = customers.peek();
                    if (next == null) {
                        System.out.println("The queue is empty.");
                    } else {
                        System.out.println("Next customer: " + next);
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Bank Queue Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1 to 5.");
            }
        } while (choice != 5);

        input.close();
    }
}
