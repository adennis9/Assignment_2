/**
 *
 * @author Andrew
 */
package Assignment_2;

import java.util.HashMap;


public class ShoppingCart 
{
    HashMap<String, String> cartItems;

    public ShoppingCart() 
    {
        cartItems = new HashMap<>();
    }
    

    public HashMap getCartItems()
    {
        return cartItems;
    }
    
    public void addToCart(String image, String price)
    {
        cartItems.put(image, price);
    }
}
