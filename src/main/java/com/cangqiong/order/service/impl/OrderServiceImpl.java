package com.cangqiong.order.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ylx.gmall.bean.UserAddress;
import com.ylx.gmall.service.OrderService;
import com.ylx.gmall.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component("orderService")
public class OrderServiceImpl implements OrderService {

	@Reference
	UserService userService;

	@Override
	public List<UserAddress> initOrder(String userId) {
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		for (UserAddress userAddress : addressList) {
			System.out.println(userAddress.getUserAddress());
		}
		return addressList;
	}

}


