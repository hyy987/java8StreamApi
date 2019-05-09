package com.atguigu.pojo;

import java.util.Arrays;
import java.util.List;

public class TestTransaction {

	List<Transaction> transactions=null;
	public void before() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		transactions= Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)				
				);
	}
	//1.找出2011年发送的交易，并按照交易额排序（从低到高）
	//2.交易员都在哪些不同的城市工作过
	//3.查找所有来自剑桥的交易员，并按照姓名排序
	//4.返回所有交易员的 姓名字符串，按字母顺序排序
	//5.有没有交易员在米兰工作
	//6.打印生活在剑桥的交易员的所有交易额
	//7.所有交易中，最高的交易额是多少
	//8.找到交易额最小的交易
	
	
	
}
