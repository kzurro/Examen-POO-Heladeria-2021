package com.github.extras;

public class Extra {
  public static final Extra[] EXTRAS = new Extra[] {
                                            new Extra("Lemon", .2f),
                                            new Extra("Caramel", .3f),
                                            new Extra("Mango", .4f),
                                            new Extra("Chocolate", .5f),
                                            new Extra("Raspberry", .6f),
                                            new Extra("Strawberry", .7f)
                                        };
  private String description;
  private float price;

  public Extra(String description, float price) {
    super();
    this.description = description;
    this.price = price;
  }

  public String getDescription() {
    return description;
  }
  
  public float getPrice() {
    return price;
  }
  
}
