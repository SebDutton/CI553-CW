package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * Extension of Basket class. Merges repeated products and sorts orders
 * 
 * @author  Your Name 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable, Comparator<Product>
{
  private static final long serialVersionUID = 1L;
  
  
  @Override
  public boolean add( Product p1 ) {
  //Search existing products for matching record
  for(Product p2: this){
	  if(p1.getProductNum().equals(p2.getProductNum())) {
		  //found - update quantity and return
		  p2.setQuantity(p2.getQuantity()+p1.getQuantity());
		  return (true);
	  }
  }
                
  //not found - add new product using superclass method
    super.add( p1 );     // Call add in ArrayList
    
    //now sort list
    Collections.sort(this, this);
    return(true);
  }
  
  public int compare(Product p1, Product p2) {
	  return p1.getProductNum().compareTo(p2.getProductNum());
  }
}
