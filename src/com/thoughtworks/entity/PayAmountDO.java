package com.thoughtworks.entity;

/**
 * Description: 商品详细信息DO类
 * @author 王吉元
 * @version 1.0,3/2/16
 * @since JDK1.7
 */
public class PayAmountDO {
	/* 商品编号 */
	private String productNum;
	/* 商品名称 */
	private String productName;
	/* 商品数量 */
	private long productCount;
	/* 商品单价 */
	private double productUnitPrice;	
	/* 商品优惠类型 */
	private DiscountTypeEnum discountTypeEnum;
	/*支付金额 */
	private double payAmount;
	/*节省金额 */
	private double saveAmount;
	/*赠送数量*/
	private long giftCount;
	
	public long getGiftCount() {
		return giftCount;
	}
	public void setGiftCount(long giftCount) {
		this.giftCount = giftCount;
	}
	public String getProductNum() {
		return productNum;
	}
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductCount() {
		return productCount;
	}
	public void setProductCount(long productCount) {
		this.productCount = productCount;
	}
	public double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	public double getSaveAmount() {
		return saveAmount;
	}
	public void setSaveAmount(double saveAmount) {
		this.saveAmount = saveAmount;
	}
	public DiscountTypeEnum getDiscountTypeEnum() {
		return discountTypeEnum;
	}
	public void setDiscountTypeEnum(DiscountTypeEnum discountTypeEnum) {
		this.discountTypeEnum = discountTypeEnum;
	}
}
