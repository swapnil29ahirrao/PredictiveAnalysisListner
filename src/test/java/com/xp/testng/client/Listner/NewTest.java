package com.xp.testng.client.Listner;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

@Listeners(CustomListner.class)

public class NewTest {
  @Test
  public void f() {
  }
  @Test
  public void fa() {
	  Assert.fail();
  }
  
  @Test
  public void fa1() {
	  Assert.fail("Failed");
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
