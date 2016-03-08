package com.thoughtworks.test;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thoughtworks.discount.DiscountServiceComponent;
import com.thoughtworks.entity.DiscountTypeEnum;
import com.thoughtworks.entity.PayAmountDO;
import com.thoughtworks.printTicket.PrintTicketService;
import com.thoughtworks.printTicket.PrintTicketServiceOne;

/**
 * 测试类
 * @author 王吉元
 * @version 1.0,3/07/16
 * @since JDK1.7
 */
public class _PrintTicketServiceTest {

  @Test
  public void filterOriginalDataTest() {
	  PrintTicketService printTicketService = new PrintTicketServiceOne();
	  List<String> purchasedProducts = Arrays.asList("ITEM000001");
	  List<PayAmountDO> payAmountDOs = printTicketService.filterOriginalData(purchasedProducts);
	  Assert.assertEquals(payAmountDOs.get(0).getProductNum(), "ITEM000001");
	  Assert.assertEquals(payAmountDOs.get(0).getProductName(), "羽毛球");
	  Assert.assertEquals(payAmountDOs.get(0).getProductCount(), 1);
	  Assert.assertEquals(payAmountDOs.get(0).getProductUnitPrice(), 1.0);
	  Assert.assertEquals(payAmountDOs.get(0).getDiscountTypeEnum(), DiscountTypeEnum.GIFT_DISCOUNT);
  }

  @Test
  public void getTicketItemContentTest() {
	  PrintTicketService printTicketService = new PrintTicketServiceOne();
	  List<String> purchasedProducts = Arrays.asList("ITEM000001","ITEM000001","ITEM000001","ITEM000001","ITEM000001");
	  List<PayAmountDO> payAmountDOs = printTicketService.filterOriginalData(purchasedProducts);
	  List<PayAmountDO> goodList = DiscountServiceComponent.getAllAmount(payAmountDOs);
	  String goodStr = printTicketService.getTicketItemContent(goodList.get(0));
	  Assert.assertEquals(goodStr, "名称 : 羽毛球,数量 : 5个,单价 : 1.0(元),小计 : 4.00\n");
  }

  @Test
  public void printGoodsTicketTest() {
	  PrintTicketService printTicketService = new PrintTicketServiceOne();
	  List<String> purchasedProducts = Arrays.asList("ITEM000001","ITEM000001","ITEM000001","ITEM000001","ITEM000001");
	  List<PayAmountDO> payAmountDOs = printTicketService.filterOriginalData(purchasedProducts);
	  List<PayAmountDO> goodList = DiscountServiceComponent.getAllAmount(payAmountDOs);
	  Assert.assertEquals(goodList.get(0).getProductNum(), "ITEM000001");
	  Assert.assertEquals(goodList.get(0).getProductName(), "羽毛球");
	  Assert.assertEquals(goodList.get(0).getProductCount(), 5);
	  Assert.assertEquals(goodList.get(0).getProductUnitPrice(), 1.0);
	  Assert.assertEquals(goodList.get(0).getDiscountTypeEnum(), DiscountTypeEnum.GIFT_DISCOUNT);
	  Assert.assertEquals(goodList.get(0).getGiftCount(), 1);
	  Assert.assertEquals(goodList.get(0).getPayAmount(), 4.0);
	  Assert.assertEquals(goodList.get(0).getSaveAmount(), 1.0); 
  }
}
