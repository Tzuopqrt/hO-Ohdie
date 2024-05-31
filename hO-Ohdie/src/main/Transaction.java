package main;

public class Transaction {

	private String TransactionID;
	private String UserID;
	private String Username;
	
	public Transaction(String transactionID, String userID, String username) {
		super();
		TransactionID = transactionID;
		UserID = userID;
		Username = username;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public Transaction(String transactionID, String userID) {
		super();
		TransactionID = transactionID;
		UserID = userID;
	}
	public String getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	
}
