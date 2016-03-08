package com.thoughtworks.printTicket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.entity.DiscountTypeEnum;
import com.thoughtworks.entity.PayAmountDO;
import com.thoughtworks.mockData.MockData;

/**
 * Description: 购物小票打印模版抽象类
 * (可以通过继承该抽象类，自定义打印模版)
 * @author 王吉元
 * @version 1.0,3/2/16
 * @since JDK1.7
 */
public abstract class PrintTicketService {
	/*打印小票票头*/
	protected static final String TICKET_HEADER = "***<没钱赚商店>购物清单***\n";
	/*打印小票票尾*/
	protected static final String TICKET_FOOTER = "**********************\n";
	/*打印小票分隔线*/
	protected static final String TICKET_SEPERATER = "----------------------\n";
	
	/**
	 * Description: 处理原始购物条形码数据
	 * @param purchasedProducts 原始购物条形码数据
	 * @return 返回处理后的商品信息数据
	 */
	public  List<PayAmountDO> filterOriginalData(List<String> purchasedProducts){
		Map<String, Integer> productMap = new HashMap<String, Integer>();
		List<PayAmountDO> ticketDOs = new ArrayList<PayAmountDO>();
		String productArr[] = null;
		String productNum = null;
		int productCount = 0;
		PayAmountDO payAmountDO = null;
		for(String product : purchasedProducts){
			productArr = product.split("-");
			if(productArr.length == 1){
				productNum = product;
				productCount = 1;
			}else{
				productNum = productArr[0].trim();
				productCount = Integer.parseInt(productArr[1]);
			}
			productCount = (productMap.get(productNum) != null ? productMap.get(productNum) : 0)  + productCount;
			productMap.put(productNum, productCount);
		}
		for(String productId : productMap.keySet()){
			payAmountDO = new PayAmountDO();
			payAmountDO.setProductName((String) MockData.productsNameMap.get(productId));
			payAmountDO.setProductNum(productId);
			payAmountDO.setProductCount(productMap.get(productId));
			payAmountDO.setProductUnitPrice((Double) MockData.productsUnitPriceMap.get(productId));
			payAmountDO.setDiscountTypeEnum((DiscountTypeEnum) MockData.productsDiscountMap.get(productId));
			ticketDOs.add(payAmountDO);
		}
		return ticketDOs;
	}
	
	/**
	 * 处理单个商品的打印数据
	 * @param payAmountDO
	 * @return
	 */
	public  String getTicketItemContent(PayAmountDO payAmountDO){
		StringBuilder reStrBuilder = new StringBuilder();
		reStrBuilder.append("名称 : ");
		reStrBuilder.append(payAmountDO.getProductName());
		reStrBuilder.append(",数量 : ");
		reStrBuilder.append(payAmountDO.getProductCount());
		reStrBuilder.append(MockData.productsUnitTypeMap.get(payAmountDO.getProductNum()));
		reStrBuilder.append(",单价 : ");
		reStrBuilder.append(payAmountDO.getProductUnitPrice());
		reStrBuilder.append("(元),小计 : ");
		reStrBuilder.append(String .format("%.2f",payAmountDO.getPayAmount()));
		if(payAmountDO.getDiscountTypeEnum() == DiscountTypeEnum.PERCENT_DISCOUNT){
			reStrBuilder.append(",节省 : ");
			reStrBuilder.append(String .format("%.2f",payAmountDO.getSaveAmount()));
			reStrBuilder.append("(元)");
		}
		reStrBuilder.append("\n");
		
		return reStrBuilder.toString();
	}
	
	/**
	 * 抽象方法待实现
	 * 小票打印结果
	 */
	public  abstract void printGoodsTicket();
}
