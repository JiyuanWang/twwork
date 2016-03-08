package com.thoughtworks.entity;

/**
 * Description: 优惠类型的枚举
 * @author 王吉元
 * @version 1.0,3/2/16
 * @since JDK1.7
 */
public enum DiscountTypeEnum {
	/*无优惠*/
	NO_DISCOUNT("noDiscount"),
	/*打折优惠*/
	PERCENT_DISCOUNT("percentDiscount"),
	/*赠品优惠*/
	GIFT_DISCOUNT("giftDiscount");
	
    private String type;
   
    private DiscountTypeEnum(String type) {
        this.type=type;
    }
    
    public String getType(){
        return type;
    }
}