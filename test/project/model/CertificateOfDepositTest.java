package project.model;
import project.model.CertificateOfDeposit; 

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Test ideas 
/* Test withdraw(not matured, penalty) and deposit
 * Test a withdraw when matured 
 * Test a withdraw that goes to the min and charges a fee
 * Test that interest is not accumulated when matured
 * Test that interest IS accumulated when not matured
 * NOTE: CdMin for this test is 500 and interest is always 5% annual 
 */

public class CertificateOfDepositTest {
	 private CertificateOfDeposit account; 
	 private BigDecimal basicBalance = new BigDecimal(600); 
	 
	    @Before
	    public void setUp() {
	        //account = new CertificateOfDeposit(CertificateOfDeposit.Term.ZERO, new BigDecimal(basicBalance);
	        account = new CertificateOfDeposit(CertificateOfDeposit.Term.ONE_YEAR, basicBalance);
	        TestUtil.assertEquals(basicBalance, account.getBalance());
	    }

	    @After
	    public void tearDown() {
	        account = null;
	    }

	    @Test
	    public void testWithdrawNotMature() throws InsufficientFundsException, OverdraftException {
	    	account = new CertificateOfDeposit(CertificateOfDeposit.Term.ONE_YEAR, new BigDecimal(1234.56));
	        TestUtil.assertEquals(1234.56, account.getBalance());
	        BigDecimal preBalance = account.getBalance(); 
	        account.withdraw(new BigDecimal(123.45));
	        BigDecimal result = account.getBalance(); 
	        BigDecimal expected = new BigDecimal(1111.11);
	        expected = expected.subtract(preBalance.multiply(account.getInterestRate()).divide(new BigDecimal("2"))); 
	        TestUtil.assertEquals(expected, result);
	    }

	    @Test (expected = IllegalArgumentException.class)
	    public void testWithdrawToMin() throws InsufficientFundsException, OverdraftException {
	        TestUtil.assertEquals(basicBalance, account.getBalance());
	        account.withdraw(new BigDecimal(100));
	        TestUtil.assertEquals(basicBalance, account.getBalance());
	    }
	    
	    @Test
	    public void testWithDrawMature() throws InsufficientFundsException, OverdraftException {
	    	account = new CertificateOfDeposit(CertificateOfDeposit.Term.ZERO, basicBalance);
	        account.withdraw(new BigDecimal(123.456));
	        TestUtil.assertEquals(476.544, account.getBalance());
	    }
	    
	    @Test
	    public void testInterestMature() throws InsufficientFundsException, OverdraftException {
	    	account = new CertificateOfDeposit(CertificateOfDeposit.Term.ZERO, basicBalance);
	    	account.doPayments();
	    	TestUtil.assertEquals(basicBalance, account.getBalance());
	    }
	    
	    @Test
	    public void testInterestNotMature() throws InsufficientFundsException, OverdraftException {
	    	account = new CertificateOfDeposit(CertificateOfDeposit.Term.ZERO, basicBalance);
	    	account.doPayments();
	    	BigDecimal finalBalance = basicBalance.add(basicBalance.multiply(account.getInterestRate()).divide(new BigDecimal(12)));
	    	TestUtil.assertEquals(finalBalance, account.getBalance());
	    }
	    
	    @Test
	    public void testAdvanceMonths() throws InsufficientFundsException, OverdraftException {
	    	account = new CertificateOfDeposit(CertificateOfDeposit.Term.SIX_MONTHS, basicBalance);
	    	int x; 
	    	for(x=0; x<7; x++){
	    	account.doPayments();
	    	}
	    	TestUtil.assertEquals(BigDecimal.ZERO, account.getInterestRate());
	    	System.out.println("Months on account: "+account.getMonthsElapsed());
	    	System.out.println("Months that should be on account: "+x); 
	    }
	}

