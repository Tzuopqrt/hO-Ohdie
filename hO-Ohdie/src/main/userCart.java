package main;

public class userCart {
	
	private String userCartID;
	private String hoodieCartID;
	private Integer hoodieCartQty;
	
	public userCart(String userCartID, String hoodieCartID, Integer hoodieCartQty) {
		super();
		this.userCartID = userCartID;
		this.hoodieCartID = hoodieCartID;
		this.hoodieCartQty = hoodieCartQty;
	}
	public String getUserCartID() {
		return userCartID;
	}
	public void setUserCartID(String userCartID) {
		this.userCartID = userCartID;
	}
	public String getHoodieCartID() {
		return hoodieCartID;
	}
	public void setHoodieCartID(String hoodieCartID) {
		this.hoodieCartID = hoodieCartID;
	}
	public Integer getHoodieCartQty() {
		return hoodieCartQty;
	}
	public void setHoodieCartQty(Integer hoodieCartQty) {
		this.hoodieCartQty = hoodieCartQty;
	}
	

}
