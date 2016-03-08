package com.thoughtworks.discount;

import java.util.List;

import com.thoughtworks.entity.PayAmountDO;

/**
 * Description: 优惠策略的接口
 * @author 王吉元
 * @version 1.0,03/07/16
 * @since JDK1.7
 */
public interface DiscountService {
	/**
	 * 根据采购商品，计算小记金额和节省金额
	 * @param goodList 采购商品
	 * @return PayAmountDO
	 */
	public List<PayAmountDO> calculatePayAmount(List<PayAmountDO> goodList);
}
