package main;

public class Detail {
	
	private String TransactionDetailID;
	private String HoodieID;
	private String HoodieName;
	private Integer HoodieQty;
	private Double TotalPrice;
	
	public Detail(String transactionDetailID, String hoodieID, String hoodieName, Integer hoodieQty,
			Double totalPrice) {
		super();
		TransactionDetailID = transactionDetailID;
		HoodieID = hoodieID;
		HoodieName = hoodieName;
		HoodieQty = hoodieQty;
		TotalPrice = totalPrice;
	}
	public String getTransactionDetailID() {
		return TransactionDetailID;
	}
	public void setTransactionDetailID(String transactionDetailID) {
		TransactionDetailID = transactionDetailID;
	}
	public String getHoodieID() {
		return HoodieID;
	}
	public void setHoodieID(String hoodieID) {
		HoodieID = hoodieID;
	}
	public String getHoodieName() {
		return HoodieName;
	}
	public void setHoodieName(String hoodieName) {
		HoodieName = hoodieName;
	}
	public Integer getHoodieQty() {
		return HoodieQty;
	}
	public void setHoodieQty(Integer hoodieQty) {
		HoodieQty = hoodieQty;
	}
	public Double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		TotalPrice = totalPrice;
	}
	

}
