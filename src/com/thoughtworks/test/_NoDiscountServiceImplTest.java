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
public class _NoDiscountServiceImplTest {

  @Test
  public void calculatePayAmount() {
	  PrintTicketService printTicketService = new PrintTicketServiceOne();
	  List<String> purchasedProducts = Arrays.asList("ITEM000002","ITEM000002");
	  List<PayAmountDO> payAmountDOs = printTicketService.filterOriginalData(purchasedProducts);
	  List<PayAmountDO> goodList = DiscountServiceComponent.getAllAmount(payAmountDOs);
	  Assert.assertEquals(goodList.get(0).getProductNum(), "ITEM000002");
	  Assert.assertEquals(goodList.get(0).getProductName(), "香蕉");
	  Assert.assertEquals(goodList.get(0).getProductCount(), 2);
	  Assert.assertEquals(goodList.get(0).getProductUnitPrice(), 2.0);
	  Assert.assertEquals(goodList.get(0).getDiscountTypeEnum(), DiscountTypeEnum.NO_DISCOUNT);
	  Assert.assertEquals(goodList.get(0).getPayAmount(), 4.0);
	  Assert.assertEquals(goodList.get(0).getSaveAmount(), 0.0); 
  }
}
