package com.dancingcloudservices;

public class Main {
  public static void main(String[] args) {
    Object o = "Hello Java 21 world!";
    System.out.println(
        switch (o) {
          case String s -> "Message is " + s;
          default -> "Unexpected!";
        }
    );
  }
}