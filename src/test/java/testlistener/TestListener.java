package testlistener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(testlistener.MyListeners.class)

public class TestListener {
@Test

	
public void testcase1() {
	
	Assert.assertEquals(true ,true);
	System.out.println("Test Case1 Pass....");
}

@Test

public void testcase2() {
	Assert.assertEquals(true ,true);
	System.out.println("Test Case2 Pass....");
}

}
