
import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (Nihinlolamiwa Fajemilehin) 
 * @version (18th of October, 2018)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product retrievedProduct = findProduct(id);
        if (retrievedProduct != null) {
            retrievedProduct.increaseQuantity(amount);
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        int index = 0;
        while(index < stock.size()) {
            Product currStock = stock.get(index);
            if(currStock.getID() == id) {
                return currStock;
            }
            index++;
        }
        return null;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product retrievedProduct = findProduct(id);
        if (retrievedProduct == null) {
            return 0;
        }
        else {
            int quantity = retrievedProduct.getQuantity();
            return quantity;
        }
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product product : stock) {
            System.out.println(product.toString());
        }
    }
}
