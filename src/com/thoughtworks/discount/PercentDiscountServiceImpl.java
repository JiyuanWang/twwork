package com.thoughtworks.discount;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.entity.DiscountTypeEnum;
import com.thoughtworks.entity.PayAmountDO;

/**
 * Description: 打折优惠策略的实现类
 * @author 王吉元
 * @version 1.0,3/2/16
 * @since JDK1.7
 */
public class PercentDiscountServiceImpl implements DiscountService {

	/*计算打折策略的商品返回结果*/
	@Override
	public List<PayAmountDO> calculatePayAmount(List<PayAmountDO> goodList) {
		double percent = 0.95;
		List<PayAmountDO> payAmountDOs = new ArrayList<PayAmountDO>();
		double payAmount = 0.0;
		double saveAmount = 0.0;
		double productUnitPrice = 0.0;
		long productCount = 0;
		for(PayAmountDO goodDO : goodList){
			if(goodDO.getDiscountTypeEnum() == DiscountTypeEnum.PERCENT_DISCOUNT){
				productUnitPrice = goodDO.getProductUnitPrice();
				productCount = goodDO.getProductCount();
				payAmount = productCount*productUnitPrice*percent;
				saveAmount = productCount*productUnitPrice*(1-percent);
				goodDO.setPayAmount(payAmount);
				goodDO.setSaveAmount(saveAmount);
				payAmountDOs.add(goodDO);
			}
		}
		return payAmountDOs;
	}
}
