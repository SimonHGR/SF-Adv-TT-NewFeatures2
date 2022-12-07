package usewrapper;

import java.util.ArrayList;
import java.util.List;

public class Example {
  public static void main(String[] args) {
    List<Integer> li = new ArrayList<>();

    li.add(99); // autoboxing!!!

    synchronized (li.get(0)) {

    }
  }
}
