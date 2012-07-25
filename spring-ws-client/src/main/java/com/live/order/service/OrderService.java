/*
 * $Id$
 *
 * Copyright 2012 Valentyn Kolesnikov
 */
package com.live.order.service;

import com.liverestaurant.orderservice.schema.Order;

/**
 * OrderService.
 *
 * @author javadev
 * @version $Revision$ $Date$
 */
public interface OrderService {
    boolean cancelOrder(String orderRef);

    String placeOrder(Order order);
}
