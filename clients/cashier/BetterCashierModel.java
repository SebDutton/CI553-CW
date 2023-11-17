package clients.cashier;

import java.io.Serializable;

import catalogue.BetterBasket;
import middle.MiddleFactory;

public class BetterCashierModel extends CashierModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public BetterCashierModel(MiddleFactory mf) {
		super(mf);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected BetterBasket makeBasket()
	  {
	    return new BetterBasket();
	  }

}
