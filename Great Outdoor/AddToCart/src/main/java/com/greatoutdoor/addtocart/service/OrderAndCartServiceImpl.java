/**
 * 
 */
package com.greatoutdoor.addtocart.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.greatoutdoor.addtocart.dao.CartDao;
import com.greatoutdoor.addtocart.dao.OrderDao;
import com.greatoutdoor.addtocart.dao.OrderProductMapDao;
import com.greatoutdoor.addtocart.exception.CrudException;
import com.greatoutdoor.addtocart.model.Cart;
import com.greatoutdoor.addtocart.model.CartBean;
import com.greatoutdoor.addtocart.model.Order;
import com.greatoutdoor.addtocart.model.OrderProductMap;
import com.greatoutdoor.addtocart.model.Orders;
import com.greatoutdoor.addtocart.model.Product;
import com.greatoutdoor.addtocart.util.GenerateId;

/**
 * @author Shivani
 *
 * 
 */
@Service
public class OrderAndCartServiceImpl implements OrderAndCartService {

	@Autowired
	CartDao cartDao;

	@Autowired
	OrderProductMapDao orderProductMapDao;

	@Autowired
	OrderDao orderDao;

	@Autowired
	GenerateId generateId;

	@Autowired
	RestTemplate restTemplate;

	private String productURL = "http://localhost:8003/product";

	@Override
	public Cart addItemToCart(CartBean cartItem) {
		if(cartDao.getProductsByUserIdProductId(cartItem.getUserId(), cartItem.getProductId()).isEmpty()) {
			Cart cart = new Cart(cartItem.getUserId(), cartItem.getProductId(), cartItem.getQuantity(), cartItem.getProductName(), cartItem.getPrice());
			return cartDao.save(cart);
		}
		else {
		return null;
		}
	}

	@Override
	public boolean insertOrderProductMapEntity(OrderProductMap orderProductMapEntity) {
		orderProductMapDao.save(orderProductMapEntity);
		return true;
	}

	@Override
	public boolean deleteOrderProductMapEntity(OrderProductMap orderProductMapEntity) {
		orderProductMapDao.delete(orderProductMapEntity);
		return true;
	}

	@Override
	public boolean removeItemFromCartByUserId(String userId) {
		if (cartDao.findById(userId).isPresent()) {
			cartDao.deleteById(userId);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateItemQuantity(Cart cartItem) {
		if (cartDao.getProductsByUserIdProductId(cartItem.getUserId(), cartItem.getProductId()).isEmpty()) {
			return false;
		} else {

			cartDao.updateItemInCart(cartItem.getUserId(), cartItem.getProductId(), cartItem.getQuantity());
			return true;

		}

	}

	@Override
	public boolean registerOrder(Order order) {
//		if (cartDao.count() == 0 || cartDao.getAllProducts(order.getUserId()).isEmpty()) {
//			return false;
//		}
//		List<Cart> cartItems = (List<Cart>) cartDao.getAllProducts(order.getUserId());
//		if (cartItems == null) {
//			return false;
//		}
//		Iterator<Cart> itr = cartItems.iterator();
//		int index = 0;
//		String orderId = generateId.generateOrderId(order.getUserId());
//		while (itr.hasNext()) {
//			
//			OrderProductMap orderProductMap = new OrderProductMap(generateId.generateProductUIN(), orderId,
//					cartItems.get(index).getProductId(), cartItems.get(index).getQuantity());
//			insertOrderProductMapEntity(orderProductMap);
//			index++;
//			itr.next();
//		}
//
//		long millis = System.currentTimeMillis();
//		Date orderInitiationTime = new Date(millis);
//
//		Order newOrder = new Order(orderId, order.getUserId(), order.getAddressId(),  orderInitiationTime, order.getTotalcost());
//
//		orderDao.save(newOrder);
//		cartDao.deleteByUserId(order.getUserId());
//		return true;
		
		

		//insert the item from the cart to order product map table
		if(cartDao.count()==0) throw new CrudException("Please item add to cart to place an order!");
		List<Cart> cartItems = (List<Cart>) cartDao.findAll();
		Iterator<Cart> itr = cartItems.iterator();
		int index = 0;
		String orderId = generateId.generateOrderId(order.getUserId());
		
		while (itr.hasNext()) {
			
			OrderProductMap orderProductMap = new OrderProductMap(generateId.generateProductUIN(),
			orderId, cartItems.get(index).getProductId(),cartItems.get(index).getQuantity());
			insertOrderProductMapEntity(orderProductMap);
			index++;
			itr.next();
		}
		
		
		///////////////////////////////////////////////
		
		
		long millis = System.currentTimeMillis();
		Date orderInitiationTime = new Date(millis);
		
		Order newOrder = new Order(orderId, order.getUserId(), order.getAddressId(),  orderInitiationTime, order.getTotalcost());
		
		orderDao.save(newOrder);
		cartDao.deleteByUserId(order.getUserId());
		
		return true;
	}

	@Override
	public boolean deleteOrder(Order order) {
		orderDao.delete(order);
		return true;
	}

	@Override
	public boolean cancelOrderByOrderId(String orderId) {

		if (orderProductMapDao.count() == 0 || orderDao.count() == 0
				|| orderProductMapDao.getAllOrdersByOrderId(orderId).isEmpty()) {
			return false;
		} else {
			orderProductMapDao.deleteOrderByOrderId(orderId);
			orderDao.deleteById(orderId);
			return true;
		}

	}

	@Override
	public Orders getAllOrdersByOrderId(String orderId) {
		Orders orders = new Orders();
		orders.setOrders(orderProductMapDao.getAllOrdersByOrderId(orderId));
		if (orders.getOrders().isEmpty()) {
			return null;
		}
		return orders;
	}

	@Override
	public Orders getAllOrdersByOrderIdProductId(String orderId, String productId) {
		Orders orders = new Orders();
		orders.setOrders(orderProductMapDao.getAllOrdersByOrderIdProductId(orderId, productId));
		if (orders.getOrders().isEmpty()) {
			return null;
		}
		return orders;
	}

	@Override
	public boolean cancelProductByOrderIdProductId(String orderId, String productId) {
		if (orderProductMapDao.getAllOrdersByOrderIdProductId(orderId, productId).isEmpty()) {
			return false;
		} else {
			orderProductMapDao.deleteOrderByOrderIdProductId(orderId, productId);
			return true;
		}

	}

	@Override
	public long getOrderTableSize() {
		return orderDao.count();
	}

	@Override
	public long getOrderProductMapTableSize() {
		return orderProductMapDao.count();
	}

	@Override
	public List<Product> getAllProductsByUserId(String userId) {
		if (cartDao.getAllProducts(userId).isEmpty()) {
			return null;
		} else {
			List<Cart> listCartItems = cartDao.getAllProducts(userId);
			List<Product> listProducts = new ArrayList<>();

			Iterator<Cart> itr = listCartItems.iterator();
			int index = 0;

			while (itr.hasNext()) {
				Product product = restTemplate.getForObject(
						productURL + "/getProductById/" + listCartItems.get(index).getProductId(),
						Product.class);
				product.setQuantity(listCartItems.get(index).getQuantity());
				listProducts.add(product);
				index++;
				itr.next();
			}
			return listProducts;
		}

	}

	@Override
	public boolean removeProductByUserIdProductId(String userId, String productId) {
		if (cartDao.getProductsByUserIdProductId(userId, productId).isEmpty()) {
			return false;
		} else {
			cartDao.removeItemFromCart(userId, productId);
			return true;
		}

	}

	@Override
	public List<Order> getAllOrdersByUserId(String userId) {
		if (orderDao.getAllOrders(userId).isEmpty()) {
			return null;
		}
		return orderDao.getAllOrders(userId);
	}

	@Override
	public List<Product> getAllProductsByOrderId(String orderId) {
		if (orderProductMapDao.getAllOrdersByOrderId(orderId).isEmpty()) {
			return null;
		} else {

			List<OrderProductMap> orderProductMap = orderProductMapDao.getAllOrdersByOrderId(orderId);
			List<Product> listProducts = new ArrayList<>();

			Iterator<OrderProductMap> itr = orderProductMap.iterator();
			int index = 0;
			while (itr.hasNext()) {
				Product product = restTemplate.getForObject(
						productURL + "/getProductById?productId=" + orderProductMap.get(index).getProductId(),
						Product.class);
				product.setQuantity(orderProductMap.get(index).getQuantity());
				listProducts.add(product);
				index++;
				itr.next();
			}
			return listProducts;
		}
	}

}
