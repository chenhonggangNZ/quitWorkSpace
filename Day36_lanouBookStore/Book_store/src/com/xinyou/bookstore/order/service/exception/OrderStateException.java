package com.xinyou.bookstore.order.service.exception;

public class OrderStateException extends OrderException {
    @Override
    public String getMessage() {
        return "您的订单状态异常，请确认您是否已经确认信息并付款。";
    }
}
