package com.thoughtworks.test;
import com.thoughtworks.printTicket.PrintTicketService;
import com.thoughtworks.printTicket.PrintTicketServiceOne;

/**
 * Description: 测试类
 * 可以到MockData类中设置各个商品不同的优惠策略
 * @author 王吉元
 * @version 1.0,3/07/16
 * @since JDK1.7
 */
public class main {
	public static void main(String args[]) {
		PrintTicketService printTicketService = new PrintTicketServiceOne();
		printTicketService.printGoodsTicket();
	}
}
