package com.tallentview.tallentview.user.dao;

import java.security.SecureRandom;
import java.math.BigInteger;

public final class RandomString {

  public String nextSessionId() {
	  SecureRandom random = new SecureRandom();
    return new BigInteger(130, random).toString(32);
  }
}
