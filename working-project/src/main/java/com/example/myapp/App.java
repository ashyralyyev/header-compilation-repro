package com.example.myapp;

import com.example.myproject.ImmutableBar;
import com.example.myproject.ImmutableFoo;

public class App {
  public static void main(String... args) {
    ImmutableBar bar = ImmutableBar.builder().name("name").build();
    ImmutableFoo foo = ImmutableFoo.builder().bar(bar).build();;
    System.out.println(foo);
  }

}
