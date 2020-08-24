package VendingMachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VTest {


	@Test
	public final void testPayment() {
		V test = new V();
		V.Payment(0);
		String x = test.test1;
		assertEquals(x, "Welcome Next Time"); 
	}

	@Test
	public final void testPurchase() {
		V test = new V();
		V.Purchase();
		assertEquals(V.test2, V.balance);
		
	}

	@Test
	public final void testCalculations() {
		V testt = new V();
		int ch = V.change;
		int xxx = V.Calculations(ch);
		
		assertEquals(ch, ch>0);
		
	}

	@Test
	public final void testDecision() {
		V testtt = new V();
		testtt.total = 25;
		testtt.balance = 100;
		assertEquals(testtt.displayBoard, "Enter more money.");
		
	}

	@Test
	public final void testDisplay() {
		V testttx = new V();
		assertTrue(testttx.vt == true);
	}

	@Test
	public final void testReset() {
		V test3 = new V();
		assertTrue(test3.productNum ==0);
		assertTrue(test3.a ==0);
		
	}

}
