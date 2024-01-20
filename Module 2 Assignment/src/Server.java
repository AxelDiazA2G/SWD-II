import java.util.ArrayList;
import java.util.List;

/**
 * The Server class represents a server that manages a list of todo items.
 */
public class Server {
    private List<String> todoItems;

    /**
     * Constructs a new Server object with an empty list of todo items.
     */
    public Server() {
        todoItems = new ArrayList<>();
    }

    /**
     * Adds a new item to the list of todo items.
     *
     * @param item the item to be added
     * @throws IllegalArgumentException if the item is null or empty
     */
    public void addItem(String item) {
        if (item == null || item.isEmpty()) {
            throw new IllegalArgumentException("Item cannot be null or empty");
        }
        todoItems.add(item);
    }

    /**
     * Deletes an item from the list of todo items.
     *
     * @param index the index of the item to be deleted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void deleteItem(int index) {
        if (index < 1 || index > todoItems.size()) {
            throw new IndexOutOfBoundsException("Invalid index. Please enter a valid index.");
        }
        todoItems.remove(index - 1);
    }

    /**
     * Returns the list of todo items.
     *
     * @return the list of todo items
     */
    public List<String> getItems() {
        return todoItems;
    }

    /**
     * Updates an item in the list of todo items.
     *
     * @param index the index of the item to be updated
     * @param newItem the new item value
     * @throws IndexOutOfBoundsException if the index is out of range
     * @throws IllegalArgumentException if the new item is null or empty
     */
    public void updateItem(int index, String newItem) {
        if (index < 1 || index > todoItems.size()) {
            throw new IndexOutOfBoundsException("Invalid index. Please enter a valid index.");
        }
        if (newItem == null || newItem.isEmpty()) {
            throw new IllegalArgumentException("New item cannot be null or empty");
        }
        todoItems.set(index - 1, newItem);
    }
}
