package edu.neu.ccs.cs5500.entity;

import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkiLiftTest {

  SkiLift skiLift1;

  @Before
  public void setUp() throws Exception {
    skiLift1 = new SkiLift(12L);
  }

  @Test
  public void getId() {
    Assert.assertEquals(java.util.Optional.ofNullable(skiLift1.getId()), Optional.of(12L));
  }

  @Test
  public void setId() {
    skiLift1.setId(11L);
    Assert.assertEquals(java.util.Optional.ofNullable(skiLift1.getId()), Optional.of(11L));
  }
}