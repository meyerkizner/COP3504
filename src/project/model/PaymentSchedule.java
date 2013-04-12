package project.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// TODO some of these have constraints to check, like positive numbers
final class PaymentSchedule {
	private BigDecimal savingsInterest = new BigDecimal("0.0200");
	private BigDecimal savingsCharge = new BigDecimal("5.00");
	private BigDecimal savingsThreshold = new BigDecimal("1000.00");
	private final Map<CertificateOfDeposit.Term, BigDecimal> cdInterest;
	private BigDecimal cdMinimum = new BigDecimal("500.00");
	private BigDecimal checkingCharge = new BigDecimal("8.00");
	private BigDecimal checkingThreshold = new BigDecimal("2000.00");
	private BigDecimal overdraftLimit = new BigDecimal("50.00");
	private BigDecimal overdraftFee = new BigDecimal("40.00");
	private BigDecimal loanInterest = new BigDecimal("0.0500");
	private BigDecimal loanPenalty = new BigDecimal("20.00");
	private BigDecimal locInterest = new BigDecimal("0.0500");
	private BigDecimal locFixedPayment = new BigDecimal("50.00");
	private BigDecimal locPercentPayment = new BigDecimal("0.0200");
	private BigDecimal locPenalty = new BigDecimal("20.00");

    PaymentSchedule() {
        cdInterest = new HashMap<CertificateOfDeposit.Term, BigDecimal>();
        cdInterest.put(CertificateOfDeposit.Term.SIX_MONTHS, new BigDecimal("0.0250"));
        cdInterest.put(CertificateOfDeposit.Term.ONE_YEAR, new BigDecimal("0.0275"));
        cdInterest.put(CertificateOfDeposit.Term.TWO_YEARS, new BigDecimal("0.0300"));
        cdInterest.put(CertificateOfDeposit.Term.THREE_YEARS, new BigDecimal("0.0325"));
        cdInterest.put(CertificateOfDeposit.Term.FOUR_YEARS, new BigDecimal("0.0350"));
        cdInterest.put(CertificateOfDeposit.Term.FIVE_YEARS, new BigDecimal("0.0375"));
    }
	
	public BigDecimal getSavingsInterest() {
		return savingsInterest;
	}

	public void setSavingsInterest(BigDecimal savingsInterest) {
		this.savingsInterest = savingsInterest;
	}

	public BigDecimal getSavingsCharge() {
		return savingsCharge;
	}

	public void setSavingsCharge(BigDecimal savingsCharge) {
		this.savingsCharge = savingsCharge;
	}

	public BigDecimal getSavingsThreshold() {
		return savingsThreshold;
	}

	public void setSavingsThreshold(BigDecimal savingsThreshold) {
		this.savingsThreshold = savingsThreshold;
	}

	public BigDecimal getCdInterest(CertificateOfDeposit.Term term) {
		return cdInterest.get(term);
	}

	public void setCdInterest(CertificateOfDeposit.Term term, BigDecimal cdInterest) {
		this.cdInterest.put(term,cdInterest);
	}

	public BigDecimal getCdMinimum() {
		return cdMinimum;
	}

	public void setCdMinimum(BigDecimal cdMinimum) {
		this.cdMinimum = cdMinimum;
	}

	public BigDecimal getCheckingCharge() {
		return checkingCharge;
	}

	public void setCheckingCharge(BigDecimal checkingCharge) {
		this.checkingCharge = checkingCharge;
	}

	public BigDecimal getCheckingThreshold() {
		return checkingThreshold;
	}

	public void setCheckingThreshold(BigDecimal checkingThreshold) {
		this.checkingThreshold = checkingThreshold;
	}

	public BigDecimal getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(BigDecimal overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	public BigDecimal getOverdraftFee() {
		return overdraftFee;
	}

	public void setOverdraftFee(BigDecimal overdraftFee) {
		this.overdraftFee = overdraftFee;
	}

	public BigDecimal getLoanInterest() {
		return loanInterest;
	}

	public void setLoanInterest(BigDecimal loanInterest) {
		this.loanInterest = loanInterest;
	}

	public BigDecimal getLoanPenalty() {
		return loanPenalty;
	}

	public void setLoanPenalty(BigDecimal loanPenalty) {
		this.loanPenalty = loanPenalty;
	}

	public BigDecimal getLocInterest() {
		return locInterest;
	}

	public void setLocInterest(BigDecimal locInterest) {
		this.locInterest = locInterest;
	}

	public BigDecimal getLocFixedPayment() {
		return locFixedPayment;
	}

	public void setLocFixedPayment(BigDecimal locFixedPayment) {
		this.locFixedPayment = locFixedPayment;
	}

	public BigDecimal getLocPercentPayment() {
		return locPercentPayment;
	}

	public void setLocPercentPayment(BigDecimal locPercentPayment) {
		this.locPercentPayment = locPercentPayment;
	}

	public BigDecimal getLocPenalty() {
		return locPenalty;
	}

	public void setLocPenalty(BigDecimal locPenalty) {
		this.locPenalty = locPenalty;
	}
}
