package com.thoughtworks.discount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.thoughtworks.entity.PayAmountDO;

/**
 * Description: 处理优惠策略的组件类
 * 
 * @author 王吉元
 * @version 1.0,07/03/16
 * @since JDK1.7
 */
public class DiscountServiceComponent {

	/*优惠服务列表*/
	private static List<DiscountService> discountServicesList;

	/*通过组件类计算返回的商品结果*/
	private List<PayAmountDO> payResult;

	/*根据优惠策略，计算商品结果*/
	public static List<PayAmountDO> getAllAmount(List<PayAmountDO> goodList) {
		if (goodList.size() == 0) {
			return Collections.emptyList();
		}
		getCountService();
		List<PayAmountDO> listResult = new ArrayList<PayAmountDO>();
		for (DiscountService discountService : discountServicesList) {
			List<PayAmountDO> tempResult = discountService.calculatePayAmount(goodList);
			listResult.addAll(tempResult);
		}
		return listResult;
	}
	
	/*加载优惠策略服务*/
	public static List<DiscountService> getCountService() {
		if (discountServicesList == null || discountServicesList.size() == 0) {
			discountServicesList = new ArrayList<DiscountService>();
			discountServicesList.add(new GiftDiscountServiceImpl());
			discountServicesList.add(new NoDiscountServiceImpl());
			discountServicesList.add(new PercentDiscountServiceImpl());
		}
		return discountServicesList;
	}

}
