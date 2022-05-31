package com.example.myapp;

import com.example.myproject.bar.ImmutableBar;
import com.example.myproject.foo.ImmutableFoo;

public class App {
  public static void main(String... args) {
    ImmutableBar bar = ImmutableBar.builder().name("name").build();
    ImmutableFoo foo = ImmutableFoo.builder().bar(bar).build();;
    System.out.println(foo);
  }

}
