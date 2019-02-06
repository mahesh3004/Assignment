package com.cts.dao;

public class RCSP_Record_Dao {

	private int Reference;
	private String AccountNumber;
	private String Description;
	private double Start_Balance;
	private double Mutation;
	private double End_Balance;
	private boolean valid;

	public int getReference() {
		return Reference;
	}

	public void setReference(int reference) {
		Reference = reference;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getStart_Balance() {
		return Start_Balance;
	}

	public void setStart_Balance(double start_Balance) {
		Start_Balance = start_Balance;
	}

	public double getMutation() {
		return Mutation;
	}

	public void setMutation(double mutation) {
		Mutation = mutation;
	}

	public double getEnd_Balance() {
		return End_Balance;
	}

	public void setEnd_Balance(double end_Balance) {
		End_Balance = end_Balance;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	private String Remarks;

	@Override
	public String toString() {
		return "RCSP_Record_Dao [Reference=" + Reference + ", AccountNumber=" + AccountNumber + ", Description="
				+ Description + ", Start_Balance=" + Start_Balance + ", Mutation=" + Mutation + ", End_Balance="
				+ End_Balance + ", valid=" + valid + ", Remarks=" + Remarks + "]";
	}

}
