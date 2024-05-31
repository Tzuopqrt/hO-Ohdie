package main;

public class Cart {
	private String userIDCart;
	private String HoodieIDCart;
	private String HoodieNameCart;
	private Integer HoodieQtyCart;
	private Double HoodiePriceCart;
	private Double HoodieTotalPriceCart;
	
	public Cart(String userIDCart, String hoodieIDCart, String hoodieNameCart, Integer hoodieQtyCart,
			Double hoodiePriceCart, Double hoodieTotalPriceCart) {
		super();
		this.userIDCart = userIDCart;
		HoodieIDCart = hoodieIDCart;
		HoodieNameCart = hoodieNameCart;
		HoodieQtyCart = hoodieQtyCart;
		HoodiePriceCart = hoodiePriceCart;
		HoodieTotalPriceCart = hoodieTotalPriceCart;
	}
	public String getUserIDCart() {
		return userIDCart;
	}
	public void setUserIDCart(String userIDCart) {
		this.userIDCart = userIDCart;
	}
	public String getHoodieIDCart() {
		return HoodieIDCart;
	}
	public void setHoodieIDCart(String hoodieIDCart) {
		HoodieIDCart = hoodieIDCart;
	}
	public String getHoodieNameCart() {
		return HoodieNameCart;
	}
	public void setHoodieNameCart(String hoodieNameCart) {
		HoodieNameCart = hoodieNameCart;
	}
	public Integer getHoodieQtyCart() {
		return HoodieQtyCart;
	}
	public void setHoodieQtyCart(Integer hoodieQtyCart) {
		HoodieQtyCart = hoodieQtyCart;
	}
	public Double getHoodiePriceCart() {
		return HoodiePriceCart;
	}
	public void setHoodiePriceCart(Double hoodiePriceCart) {
		HoodiePriceCart = hoodiePriceCart;
	}
	public Double getHoodieTotalPriceCart() {
		return HoodieTotalPriceCart;
	}
	public void setHoodieTotalPriceCart(Double hoodieTotalPriceCart) {
		HoodieTotalPriceCart = hoodieTotalPriceCart;
	}


}



