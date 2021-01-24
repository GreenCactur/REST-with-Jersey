package io.project.mock.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class products {
	private String productCode;
	private String productName;
	private String productLine;
	private String productScale;
	
	private String productVendor;
	private String quantityinStock;
	private String buyPrice;
	private String MSRP;
	
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public String getProductScale() {
		return productScale;
	}
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}
	public String getProductVendor() {
		return productVendor;
	}
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	public String getQuantityinStock() {
		return quantityinStock;
	}
	public void setQuantityinStock(String quantityinStock) {
		this.quantityinStock = quantityinStock;
	}
	public String getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getMSRP() {
		return MSRP;
	}
	public void setMSRP(String mSRP) {
		MSRP = mSRP;
	}
	
	@Override
	public String toString() {
		return "product [productCode=" + productCode + ", productName=" + productName + ", productLine=" + productLine
				+ ", productScale=" + productScale + ", productVendor=" + productVendor + ", quantityinStock="
				+ quantityinStock + ", buyPrice=" + buyPrice + ", MSRP=" + MSRP + "]";
	}
	
	
}
