package com.example.SpringBoot2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

  private PaymentProperties paymentProperties;

  public PaymentGateway(PaymentProperties paymentProperties) {
    this.paymentProperties = paymentProperties;
  }

  public String getType() {
    return paymentProperties.getType();
  }

  public int getRetryCount() {
    return paymentProperties.getRetryCount();
  }

  public boolean isEnabled() {
    return paymentProperties.isEnabled();
  }

  public int timeout() {
    return paymentProperties.getTimeout();
  }

  public void print() {
    IO.println(getType());
    IO.println(getRetryCount());
    IO.println(isEnabled());
    IO.println(timeout());
  }
}
