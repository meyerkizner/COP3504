package project.model;


import java.math.BigDecimal;


public class Loan extends AbstractLoan{
	BigDecimal minimumPayment;//Total money needed to be payed by end of month
	
	public Loan(BigDecimal amount, BigDecimal minimumPayment, BigDecimal interestPremium) {
		// TODO possibly calculate minimumPayment ourselves
		super(interestPremium);
		applyTransaction(amount, Transaction.Type.WITHDRAWAL);
		Bank.getInstance().setLoanCap(Bank.getInstance().getLoanCap().subtract(amount));
		this.minimumPayment = minimumPayment;
	}
	
	@Override
	public Transaction deposit(BigDecimal amount){
		if (getBalance().add(amount).compareTo(BigDecimal.ZERO) > 0){
			throw new IllegalArgumentException("Overpaying what you owe");
		}
		depositsToDate = depositsToDate.add(amount);
		Bank.getInstance().setLoanCap(Bank.getInstance().getLoanCap().add(amount));
		return super.deposit(amount);
	}
	
	@Override
	public Transaction withdraw(BigDecimal amount) throws OverdraftException{
		throw new UnsupportedOperationException();
	}

    @Override
    protected void doPayments() throws OverdraftException {
        if (getBalance().compareTo(BigDecimal.ZERO) == 0) {
            close();
        }
        super.doPayments();
    }
	
	protected BigDecimal getMinimumPayment(){
		return minimumPayment;
	}
	
	@Override
	protected BigDecimal getBaseInterest() {
		return Bank.getInstance().getPaymentSchedule().getLoanInterest();
	}

	@Override
	protected BigDecimal getCreditLimit() {//Used for calculating loanCap
		return getBalance();
	}
	
	@Override
	protected BigDecimal getPenalty() {
		return Bank.getInstance().getPaymentSchedule().getLoanPenalty();
	}
	
}
