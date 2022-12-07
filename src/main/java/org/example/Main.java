package org.example;

public class Main {
  public static void main(String[] args) {
    Object obj = "Hello";
    System.out.println(switch (obj) {
      case String s when s.length() > 3 -> s + " World!";
      default -> throw new IllegalStateException("That can't happen!");
    });
  }
}