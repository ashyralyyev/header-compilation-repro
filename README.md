# Header compilation issues in Bazel (Turbine)

TLDR; bazel fails on the header compilation step (`JavacTurbine`) when a generated source file uses another generated class from within the same `java_library` but different package.

## Example

`Foo` has `@Value.Immutable` annotation. It generates `ImmutableFoo`. Similarly, `Bar` has `@Value.Immutable` annotation. It generates `ImmutableBar`. `ImmutableFoo` uses `ImmutableBar`.

## 1. Working example

When `Foo.java` and `Bar.java` are in the same package, it works with and without header compilation:
```bash
$ bazel run //working-project:binary --java_header_compilation
Foo{bar=Bar{name=name}}

$ bazel run //working-project:binary --nojava_header_compilation
Foo{bar=Bar{name=name}}
```

## 2. Failing example

When `Foo.java` and `Bar.java` are in different packages, header compilation fails:
```bash
$ bazel run //failing-project:binary --java_header_compilation
com/example/myproject/foo/ImmutableFoo.java:145: error: could not resolve ImmutableBar
    public final Builder bar(ImmutableBar bar) {
                             ^
...
```
It works when header compilation is disabled:
```bash
$ bazel run //failing-project:binary --nojava_header_compilation
Foo{bar=Bar{name=name}}
```

