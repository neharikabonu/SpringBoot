package com.example.SpringBoot1;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

  public void pay() {
    IO.println("Payment successful");
  }
}
