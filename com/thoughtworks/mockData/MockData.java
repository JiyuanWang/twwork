package com.thoughtworks.mockData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.entity.DiscountTypeEnum;

/**
 * Description: Mock数据
 * @author 王吉元
 * @version 1.0,3/2/16
 * @since JDK1.7
 */
public class MockData {
	
	/* 购买的商品列表*/
	public static List<String> purchasedProducts = Arrays.asList(
			"ITEM000001",
		    "ITEM000001",
		    "ITEM000001",
		    "ITEM000001",
		    "ITEM000001",
		    "ITEM000003-2",
		    "ITEM000005",
		    "ITEM000005",
		    "ITEM000005"
	);

	/* 商品单价列表*/
	public static Map productsUnitPriceMap = new HashMap<String, Double>() {
		{
			put("ITEM000001", 1.0);
			put("ITEM000002", 2.0);
			put("ITEM000003", 5.5);
			put("ITEM000005", 3.0);
		}
	};

	/* 商品单位列表*/
	public static Map productsUnitTypeMap = new HashMap<String, String>() {
		{
			put("ITEM000001", "个");
			put("ITEM000003", "斤");
			put("ITEM000005", "瓶");
		}
	};

	/* 商品名称列表*/
	public static Map productsNameMap = new HashMap<String, String>() {
		{
			put("ITEM000001", "羽毛球");
			put("ITEM000002", "香蕉");
			put("ITEM000003", "苹果");
			put("ITEM000005", "可口可乐");
		}
	};

	/* 商品优惠类型列表*/
	public static Map productsDiscountMap = new HashMap<String, DiscountTypeEnum>() {
		{
			put("ITEM000001", DiscountTypeEnum.GIFT_DISCOUNT);
			put("ITEM000002", DiscountTypeEnum.NO_DISCOUNT);
			put("ITEM000003", DiscountTypeEnum.PERCENT_DISCOUNT);
			put("ITEM000005", DiscountTypeEnum.GIFT_DISCOUNT);
		}
	};
}
