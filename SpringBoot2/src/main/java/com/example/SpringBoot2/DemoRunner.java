package com.example.SpringBoot2;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements ApplicationRunner {

  private PaymentGateway paymentGateway;

  public DemoRunner(PaymentGateway paymentGateway) {
    this.paymentGateway = paymentGateway;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    paymentGateway.print();
  }
}
