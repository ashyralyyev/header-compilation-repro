package com.example.myproject.foo;

import com.example.myproject.bar.ImmutableBar;
import org.immutables.value.Value;

@Value.Immutable
public interface Foo {
  ImmutableBar bar();
}