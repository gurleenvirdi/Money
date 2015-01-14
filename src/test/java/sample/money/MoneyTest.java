package sample.money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MoneyTest
{
	/*
	//This means both test cases are using some common objects to work on. Hence, we use "Test Fixtures"
	@Test 
	public void testSimpleAdd() {
	        Money m12CHF= new Money(12, "CHF");  // (1)
	        Money m14CHF= new Money(14, "CHF");        
	        Money expected= new Money(26, "CHF");
	        Money result= m12CHF.add(m14CHF);    // (2)
	        Assert.assertTrue(expected.equals(result));     // (3)
	    }

	@Test
	public void testEquals() {
		    Money m12CHF= new Money(12, "CHF");
		    Money m14CHF= new Money(14, "CHF");

		    Assert.assertFalse(m12CHF.equals(null));
		    Assert.assertEquals(m14CHF, m14CHF);
		    Assert.assertEquals(m12CHF, new Money(12, "CHF")); // (1)
		    Assert.assertTrue(!m12CHF.equals(m14CHF));
		}

	*/
	
	
	private Money f12CHF,f14CHF,f7USD,f21USD;
	private MoneyBag fMB1,fMB2;

    @Before //this creates the "JUnit Fixture", a set of common objects for all test cases
    public void initialize() {
        f12CHF= new Money(12, "CHF");
        f14CHF= new Money(14, "CHF");
        f7USD=  new Money( 7, "USD");
        f21USD= new Money(21, "USD");
        fMB1= new MoneyBag(f12CHF, f7USD);
        fMB2= new MoneyBag(f14CHF, f21USD);
    }
    
    //each "@Test" creates one test case, using the "@Before" test fixtures
    
    @Test
    public void testEquals() {
        Assert.assertTrue(!f12CHF.equals(null));
        Assert.assertEquals(f12CHF, f12CHF);
        Assert.assertEquals(f12CHF, new Money(12, "CHF"));
        Assert.assertTrue(!f12CHF.equals(f14CHF));
    }

    @Test
    public void testSimpleAdd() {
        Money expected= new Money(26, "CHF");
        Money result= f12CHF.add(f14CHF);
        Assert.assertTrue(expected.equals(result));
    }
   
    @Test
    public void testBagEquals() {
        //Assert.assertTrue(!fMB1.equals(null));
        Assert.assertEquals(fMB1, fMB1);
        Assert.assertFalse(fMB1.equals(f12CHF));
        Assert.assertTrue(!f12CHF.equals(fMB1));
        Assert.assertTrue(!fMB1.equals(fMB2));
    }
}
