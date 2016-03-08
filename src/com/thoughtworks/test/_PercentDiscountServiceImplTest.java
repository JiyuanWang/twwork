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
public class _PercentDiscountServiceImplTest {

  @Test
  public void calculatePayAmount() {
	  PrintTicketService printTicketService = new PrintTicketServiceOne();
	  List<String> purchasedProducts = Arrays.asList("ITEM000003","ITEM000003");
	  List<PayAmountDO> payAmountDOs = printTicketService.filterOriginalData(purchasedProducts);
	  List<PayAmountDO> goodList = DiscountServiceComponent.getAllAmount(payAmountDOs);
	  Assert.assertEquals(goodList.get(0).getProductNum(), "ITEM000003");
	  Assert.assertEquals(goodList.get(0).getProductName(), "苹果");
	  Assert.assertEquals(goodList.get(0).getProductCount(), 2);
	  Assert.assertEquals(goodList.get(0).getProductUnitPrice(), 5.5);
	  Assert.assertEquals(goodList.get(0).getDiscountTypeEnum(), DiscountTypeEnum.PERCENT_DISCOUNT);
	  Assert.assertEquals(String.format("%.2f", goodList.get(0).getPayAmount()), "10.45");
	  Assert.assertEquals(String.format("%.2f", goodList.get(0).getSaveAmount()), "0.55"); 
  }
}
