package catalogue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BetterBasketTest {

	@Test
	void testMergeAddProduct() {
		BetterBasket b = new BetterBasket();
		Product p1 = new Product("0001", "Toaster",10.00,1);
		Product p2 = new Product("0001", "Toaster",10.00,1);
		Product p3 = new Product("0002", "Kettle",15.00,1);
		Product p4 = new Product("0002", "Kettle",15.00,2);
		
		//test that p1 and p2 get merged
		b.add(p1);
		b.add(p2);
		assertEquals(1,b.size(),"Size Incorrect after merge");
		assertEquals(2,b.get(0).getQuantity(), "Quantity incorrect after merge");
		
		//Test that p3 doesnt get merged 
		b.add(p3);
		assertEquals(2, b.size(),"Size Incorrect after non-merge");
		
		//Test that p4 merged into p3
		b.add(p4);
		assertEquals(3,b.get(1).getQuantity(), "Quantity incorrect after reverse merge");
		
	}

	@Test
	void testSortAddProduct() {
		BetterBasket b = new BetterBasket();
		Product p1 = new Product("0001", "Toaster", 10.00,1);
		Product p2 = new Product("0003", "Microwave", 50.00,1);
		Product p3 = new Product("0001", "Kettle", 15.00,1);
		
		//Test that p1 and p3 get sorted
		b.add(p3);
		b.add(p1);
		assertEquals("0001",b.get(0).getProductNum(),"Product missorted");
		assertEquals("0003",b.get(1).getProductNum(),"Product missorted");
		
		//Test that p2 gets inserted
		b.add(p2);
		assertEquals("0001",b.get(0).getProductNum(),"Product incorrect after insert");
		assertEquals("0002",b.get(1).getProductNum(),"Product incorrect after insert");
		assertEquals("0003",b.get(2).getProductNum(),"Product incorrect after insert");
	}
}
