package com.example.myproject;

import com.example.myproject.ImmutableBar;
import org.immutables.value.Value;

@Value.Immutable
public interface Foo {
  ImmutableBar bar();
}