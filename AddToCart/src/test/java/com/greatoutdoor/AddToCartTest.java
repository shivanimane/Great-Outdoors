package com.greatoutdoor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.greatoutdoor.addtocart.model.Cart;
import com.greatoutdoor.addtocart.model.CartBean;
import com.greatoutdoor.addtocart.model.Order;
import com.greatoutdoor.addtocart.model.OrderProductMap;
import com.greatoutdoor.addtocart.model.Orders;
import com.greatoutdoor.addtocart.service.OrderAndCartService;
import com.greatoutdoor.addtocart.service.OrderAndCartServiceImpl;

class AddToCartTest {

	@Test
	void testaddItemToCart() {
		CartBean cartItem = new CartBean("100", "200", 20);
		OrderAndCartService orderandcartservice = mock(OrderAndCartServiceImpl.class);
		when(orderandcartservice.addItemToCart(cartItem)).thenReturn(Boolean.TRUE);
		System.out.println(cartItem.toString());
		boolean log = orderandcartservice.addItemToCart(cartItem);
		assertEquals(Boolean.TRUE, log);
	}

	@Test
	void testinsertOrderProductMapEntity() {
	OrderProductMap orderProductMapEntity = new OrderProductMap("456", "789", "345", 657, 355,
				400);
   OrderAndCartService orderandcartservice = mock(OrderAndCartServiceImpl.class);
		when(orderandcartservice.insertOrderProductMapEntity(orderProductMapEntity)).thenReturn(Boolean.TRUE);
		System.out.println(orderProductMapEntity.toString());
		boolean log1 = orderandcartservice.insertOrderProductMapEntity(orderProductMapEntity);
		assertEquals(Boolean.TRUE, log1);
	}
	
	@Test
	void testdeleteOrderProductMapEntity() {
		OrderProductMap orderProductMapEntity = new OrderProductMap("456", "789", "345", 657, 355,
				400);
		OrderAndCartService orderandcartservice = mock(OrderAndCartServiceImpl.class);
		when(orderandcartservice.deleteOrderProductMapEntity(orderProductMapEntity)).thenReturn(Boolean.TRUE);
		System.out.println(orderProductMapEntity.toString());
		boolean logb = orderandcartservice.deleteOrderProductMapEntity(orderProductMapEntity);
		assertEquals(Boolean.TRUE, logb);
		
	}
	
	@Test
	 void testupdateItemQuantity() {
		 Cart cartItem =new Cart("687","543",10);
		 OrderAndCartService orderandcartservice = mock(OrderAndCartServiceImpl.class);
		 when(orderandcartservice.updateItemQuantity(cartItem)).thenReturn(Boolean.TRUE);
			System.out.println(cartItem.toString());
			boolean logc = orderandcartservice.updateItemQuantity(cartItem);
			assertEquals(Boolean.TRUE, logc);
		 
		 
	 }
	/**@Test
	void testdeleteOrder() {
		Order order=new Order("3000", "t567", "4528", 5, 2020-12-12,2019-06-05, 2000);
	}**/
	
	/**@Test
	void testremoveItemFromCartByUserId() {
		Cart cartItem=new Cart("567");
		OrderAndCartService orderandcartservice = mock(OrderAndCartServiceImpl.class);
		 when(orderandcartservice.removeItemFromCartByUserId(cartItem)).thenReturn(Boolean.TRUE);
			System.out.println(cartItem.toString());
			boolean logc = orderandcartservice.removeItemFromCartByUserId(cartItem);
			assertEquals(Boolean.TRUE, logc);
	}**/
	
	@Test
	void testdeleteOrder() {
		Order order= new Order();
		OrderAndCartService orderandcartservice = mock(OrderAndCartServiceImpl.class);
		 when(orderandcartservice.deleteOrder(order)).thenReturn(Boolean.TRUE);
			System.out.println(order.toString());
			boolean logc = orderandcartservice.deleteOrder(order);
			assertEquals(Boolean.TRUE, logc);
		
	}
	
	
	
	
}
