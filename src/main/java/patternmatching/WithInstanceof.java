package patternmatching;

import java.util.Objects;

sealed interface Transporter permits Car, Truck/*, Scooter, Toy*/ {
}

record Car(String color, int seats) implements Transporter {
}

record Truck(int payload) implements Transporter {
}

//enum Toy implements Transporter {
//  POGO_STICK, SKATE;
//}

//sealed class Scooter implements Transporter permits A, B {}
//non-sealed class Scooter implements Transporter {}

class Customer {
  private String name;
  private int creditLimit;

  @Override
  public final boolean equals(Object o) {
//    if (o instanceof Customer) {
//      Customer customer = (Customer) o;
//      return customer.name.equals(this.name)
//          && customer.creditLimit == this.creditLimit;
//    } else {
//      return false;
//    }

    return o instanceof Customer other
        && other.name.equals(name)
        && other.creditLimit == creditLimit;
  }
}

public class WithInstanceof {
  public static void main(String[] args) {
    Transporter obj = new Truck(10_000);
//    Transporter obj = new Car("Red", 5);
//    Object obj = new Car("Red", 5);

    int packageWeight = 8_000;

    boolean canCarry = switch (obj) {
      case null -> false; // special null case now allowed
      case Truck t -> t.payload() >= packageWeight;
//        case Car c when c.color() == null || c.color() != null ->
//            170 * (c.seats() - 1) >= packageWeight;
      case Car c when c.color().equals("Blue") -> 200 * (c.seats() - 1) >= packageWeight;
      case Car c -> 170 * (c.seats() - 1) >= packageWeight;
//        default ->
//            throw new IllegalArgumentException("can't carry weight in that!");
    };

//      boolean canCarry = false;
//      if (!(obj instanceof Car c)) {
//        System.out.println("hmm, not a car.");
//      } else {
//        canCarry = (c.seats() - 1) * 170 >= packageWeight;
//      }
//
//      if (obj instanceof Truck t) {
//        canCarry = t.payload() >= packageWeight;
//      }
/*
    if (obj instanceof Car) {
      Car c = (Car)obj;
      canCarry = (c.seats() - 1) * 170 >= packageWeight;
    }

    if (obj instanceof Truck) {
      Truck t = (Truck)obj;
      canCarry = t.payload() >= packageWeight;
    }
*/

    System.out.println(obj + " can carry " + packageWeight + "? " + canCarry);

  }
}
