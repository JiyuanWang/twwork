package com.thoughtworks.printTicket;

import java.util.List;

import com.thoughtworks.discount.DiscountServiceComponent;
import com.thoughtworks.entity.DiscountTypeEnum;
import com.thoughtworks.entity.PayAmountDO;
import com.thoughtworks.mockData.MockData;

/**
 * Description: 购物小票打印模版的实现类
 * @author 王吉元
 * @version 1.0,3/07/16
 * @since JDK1.7
 */
public class PrintTicketServiceOne extends PrintTicketService{
	
	/*自定义打印样式*/
	@Override
	public  void printGoodsTicket(){
		// 处理原始数据
		List<PayAmountDO> goodList = filterOriginalData(MockData.purchasedProducts);
		// 获得List<PayAmountDO>
		List<PayAmountDO> payAmountDOs = DiscountServiceComponent.getAllAmount(goodList);
		// 遍历List
		StringBuilder ticketContent = new StringBuilder();
		StringBuilder discountInfo = new StringBuilder();
		double totalAmount = 0.0;
		double savedAmount = 0.0;
		ticketContent.append(TICKET_HEADER);
		for(PayAmountDO payAmountDO : payAmountDOs){
			if(payAmountDO.getDiscountTypeEnum() == DiscountTypeEnum.GIFT_DISCOUNT){
				discountInfo.append("名称 : ");
				discountInfo.append(payAmountDO.getProductName());
				discountInfo.append(",数量 : ");
				discountInfo.append(payAmountDO.getGiftCount());
				discountInfo.append(MockData.productsUnitTypeMap.get(payAmountDO.getProductNum()));
				discountInfo.append("\n");
			}
			ticketContent.append(getTicketItemContent(payAmountDO));
			savedAmount = savedAmount + payAmountDO.getSaveAmount();
			totalAmount = totalAmount + payAmountDO.getPayAmount();
		}
		ticketContent.append(TICKET_SEPERATER);
		
		if(0 != savedAmount){
			ticketContent.append(discountInfo);
			ticketContent.append(TICKET_SEPERATER);
		}
		ticketContent.append("总计：%s(元)\n".replace("%s", totalAmount+""));
		
		if(0 != savedAmount){
			ticketContent.append("节省: ");
			ticketContent.append(String.format("%.2f(元)\n", savedAmount));
		}
		ticketContent.append(TICKET_FOOTER);

		System.out.println(ticketContent);
	}
}
