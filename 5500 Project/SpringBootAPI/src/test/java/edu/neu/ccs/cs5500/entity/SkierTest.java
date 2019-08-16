package edu.neu.ccs.cs5500.entity;


import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkierTest {
  Skier skier;

  @Before
  public void setUp() throws Exception {
    skier = new Skier(0L);
  }

  @Test
  public void getId() {
    Assert.assertEquals(java.util.Optional.ofNullable(skier.getId()), Optional.of(0L));
  }

  @Test
  public void setId() {
    skier.setId(11L);
    Assert.assertEquals(java.util.Optional.ofNullable(skier.getId()), Optional.of(11L));
  }
}