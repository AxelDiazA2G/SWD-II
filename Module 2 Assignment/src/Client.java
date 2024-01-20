import java.util.Scanner;

public class Client {
    /**
     * The main method is the entry point of the program.
     * It creates a Server object, prompts the user to enter items,
     * and displays the list of items entered.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a Server object
        Server server = new Server();
        
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        try {
            boolean running = true;
            while (running) {
                // Display menu options
                displayMenu();
                
                // Read user's choice
                int choice = getUserChoice(scanner);

                switch (choice) {
                    case 1:
                        addItem(server, scanner);
                        break;
                    case 2:
                        deleteItem(server, scanner);
                        break;
                    case 3:
                        showItems(server);
                        break;
                    case 4:
                        updateItem(server, scanner);
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                System.out.println(); // Add an empty line for better readability
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Displays the menu options.
     */
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add an item");
        System.out.println("2. Delete an item");
        System.out.println("3. Show list of items");
        System.out.println("4. Update an item");
        System.out.println("5. Quit");
        System.out.print("Enter your choice: ");
    }
    
    /**
     * Reads and returns the user's choice.
     *
     * @param scanner the Scanner object to read user input
     * @return the user's choice
     */
    private static int getUserChoice(Scanner scanner) {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
    
    /**
     * Adds an item to the server.
     *
     * @param server the Server object
     * @param scanner the Scanner object to read user input
     */
    private static void addItem(Server server, Scanner scanner) {
        System.out.print("Enter an item to add: ");
        String addItem = scanner.nextLine();
        server.addItem(addItem);
    }
    
    /**
     * Deletes an item from the server.
     *
     * @param server the Server object
     * @param scanner the Scanner object to read user input
     */
    private static void deleteItem(Server server, Scanner scanner) {
        System.out.println("Todo Items:");
        System.out.println("-------------------------");
        int index = 1;
        for (String item : server.getItems()) {
            System.out.println(index + ". " + item);
            index++;
        }
        System.out.println("-------------------------");
        System.out.print("Enter the index of the item to delete: ");
        if (scanner.hasNextInt()) {
            int deleteIndex = scanner.nextInt();
            scanner.nextLine();
            if (deleteIndex >= 1 && deleteIndex <= server.getItems().size()) {
                server.deleteItem(deleteIndex);
                System.out.println("Item deleted successfully.");
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid index.");
            scanner.nextLine();
        }
    }
    
    /**
     * Shows the list of items in the server.
     *
     * @param server the Server object
     */
    private static void showItems(Server server) {
        System.out.println("Todo Items:");
        System.out.println("-------------------------");
        for (String item : server.getItems()) {
            System.out.println("- " + item);
        }
        System.out.println("-------------------------");
    }
    
    /**
     * Updates an item in the server.
     *
     * @param server the Server object
     * @param scanner the Scanner object to read user input
     */
    private static void updateItem(Server server, Scanner scanner) {
        System.out.println("Todo Items:");
        System.out.println("-------------------------");
        int index = 1;
        for (String item : server.getItems()) {
            System.out.println(index + ". " + item);
            index++;
        }
        System.out.println("-------------------------");
        System.out.print("Enter the index of the item to update: ");
        if (scanner.hasNextInt()) {
            int updateIndex = scanner.nextInt();
            scanner.nextLine();
            if (updateIndex >= 1 && updateIndex <= server.getItems().size()) {
                System.out.print("Enter the new item value: ");
                String newItem = scanner.nextLine();
                server.updateItem(updateIndex, newItem);
                System.out.println("Item updated successfully.");
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid index.");
            scanner.nextLine();
        }
    }
}
