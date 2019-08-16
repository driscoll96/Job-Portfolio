package edu.neu.ccs.cs5500.entity;


import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RideTest {
  Ride ride1;
  Skier skier1;
  SkiLift skiLift1;

  @Before
  public void setUp() throws Exception {
    skier1 = new Skier(0L);
    skiLift1 = new SkiLift(1L);
    ride1 = new Ride(0L, skier1, skiLift1, 10L);
  }

  @Test
  public void getId() {
    Assert.assertEquals(java.util.Optional.ofNullable(ride1.getId()), Optional.of(0L));
  }

  @Test
  public void setId() {
    ride1.setId(1L);
    Assert.assertEquals(java.util.Optional.ofNullable(ride1.getId()), Optional.of(1L));
  }

  @Test
  public void getSkier() {
    Assert.assertEquals(java.util.Optional.ofNullable(ride1.getSkier()), Optional.of(skier1));
  }

  @Test
  public void setSkier() {
    Skier skier2 = new Skier(1L);
    ride1.setSkier(skier2);
    Assert.assertEquals(java.util.Optional.ofNullable(ride1.getSkier()), Optional.of(skier2));
  }

  @Test
  public void getLift() {
    Assert.assertEquals(java.util.Optional.ofNullable(ride1.getLift()), Optional.of(skiLift1));
  }

  @Test
  public void setLift() {
    SkiLift skiLift2 = new SkiLift(2L);
    ride1.setLift(skiLift2);
    Assert.assertEquals(java.util.Optional.ofNullable(ride1.getLift()), Optional.of(skiLift2));
  }

  @Test
  public void getTime() {
    Assert.assertEquals(java.util.Optional.ofNullable(ride1.getTime()), Optional.of(10L));
  }

  @Test
  public void setTime() {
    ride1.setTime(15L);
    Assert.assertEquals(java.util.Optional.ofNullable(ride1.getTime()), Optional.of(15L));
  }
}