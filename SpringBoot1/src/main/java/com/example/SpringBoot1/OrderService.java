package com.example.SpringBoot1;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

  private PaymentService paymentService;

  public OrderService(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  public void placeOrder() {
    paymentService.pay();
    IO.println("Order has been placed");
  }
}
