/*
 * $Id$
 *
 * Copyright 2012 Valentyn Kolesnikov
 */
package com.live.order.service;

import com.liverestaurant.orderservice.schema.Order;

/**
* <pre>
* Service interface for Order Service operations, handles two operations. <ul>
*     <li>placeOrderRequest</li>
*     <li>cancelOrderRequest</li>
* </ul>
* </pre>
*
*
* @see OrderServiceImpl
* @author javadev
* @version $Revision$ $Date$
*/
public interface OrderService {
    boolean cancelOrder(String orderRef);

    String placeOrder(Order order);
}
