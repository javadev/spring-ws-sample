/*
 * $Id$
 *
 * Copyright 2012 Valentyn Kolesnikov
 */
package com.live.order.service.client;

import org.apache.log4j.Logger;

import org.springframework.ws.client.core.WebServiceTemplate;

import com.liverestaurant.orderservice.schema.CancelOrderRequest;
import com.liverestaurant.orderservice.schema.CancelOrderResponse;
import com.liverestaurant.orderservice.schema.ObjectFactory;
import com.liverestaurant.orderservice.schema.Order;
import com.liverestaurant.orderservice.schema.PlaceOrderRequest;
import com.liverestaurant.orderservice.schema.PlaceOrderResponse;
import com.live.order.service.OrderService;

/**
 * OrderServiceClient.
 *
 * @author javadev
 * @version $Revision$ $Date$
 */
public class OrderServiceClient implements OrderService {

    private static final Logger logger = Logger.getLogger(OrderServiceClient.class);
    private static final ObjectFactory WS_CLIENT_FACTORY = new ObjectFactory();

    private  WebServiceTemplate webServiceTemplate;

    public OrderServiceClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    @Override
    public boolean cancelOrder(String orderRef) {
        logger.debug("Preparing CancelOrderRequest.....");
        CancelOrderRequest request =   WS_CLIENT_FACTORY.createCancelOrderRequest();
        request.setRefNumber(orderRef);

        logger.debug("Invoking Web service Operation[CancelOrder]....");
        CancelOrderResponse response = (CancelOrderResponse) webServiceTemplate.marshalSendAndReceive(request);

        logger.debug("Has the order cancelled: " + response.isCancelled());

        return response.isCancelled();
    }

    @Override
    public String placeOrder(Order order) {
        logger.debug("Preparing PlaceOrderRequest.....");
                PlaceOrderRequest request = WS_CLIENT_FACTORY.createPlaceOrderRequest();
                request.setOrder(order);

        logger.debug("Invoking Web service Operation[PlaceOrder]....");
                PlaceOrderResponse response = (PlaceOrderResponse) webServiceTemplate.marshalSendAndReceive(request);
        logger.debug("Order reference:" + response.getRefNumber());
        return response.getRefNumber();
    }
}
