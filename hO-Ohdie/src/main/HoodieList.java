package main;

public class HoodieList {
	
	private String hoodieId;
	private String hoodieName;
	private Double hoodiePrice;
	
	public HoodieList(String hoodieId, String hoodieName, Double hoodiePrice) {
		super();
		this.hoodieId = hoodieId;
		this.hoodieName = hoodieName;
		this.hoodiePrice = hoodiePrice;
	}
	public String getHoodieId() {
		return hoodieId;
	}
	public void setHoodieId(String hoodieId) {
		this.hoodieId = hoodieId;
	}
	public String getHoodieName() {
		return hoodieName;
	}
	public void setHoodieName(String hoodieName) {
		this.hoodieName = hoodieName;
	}
	public Double getHoodiePrice() {
		return hoodiePrice;
	}
	public void setHoodiePrice(Double hoodiePrice) {
		this.hoodiePrice = hoodiePrice;
	}
	
	
}
