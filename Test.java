package fmi.informatics.comparators.JUnitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test {


	@org.junit.Test
	public void test() {
		HelperTest t = new HelperTest();
		assertTrue(t.i == 5);
		assertEquals("t ne e \"4\"","4",t.j);
	}
}
