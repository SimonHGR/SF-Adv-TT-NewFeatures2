package records;

interface LoadCarrier {
  int getPayload();
}

public record Truck(String make, String model)
    /*extends java.lang.Record*/ // implicit, but no extends ever pemitted
    implements LoadCarrier {
      public Truck {
        if (make == null || make.length() == 0) {
          throw new IllegalArgumentException("Bad make");
        }
          make = "Make: " + make;
//        this.make = make; // nope!! Initialization handled after this
      }
  // Explicit canonical constructor
//  public Truck(String make, String model) {
//    if (make == null || make.length() == 0) {
//      throw new IllegalArgumentException("Bad make");
//    }
//    this.make = make;
//    this.model = model;
//  }

  @Override
  public String toString() {
    return "I'm a Truck, with make and model: " + make + ", " + model;
  }

  public Truck(String make) {
    // two argument constructor, defined by the line "record..."
    // is called "canonical constructor"
    this(make, "base");
  }

  @Override
  public int getPayload() {
    return 20_000;
  }
}

// NOPE records are imlicitly final types.
// public class X extends Truck {
//      X() {
//        super("", "");
//      }
//}

class UseTruck {
  public static void main(String[] args) {
    Truck t1 = new Truck("Ford", "F150");
    Truck t2 = new Truck("Dodge", "Ram");
    Truck t3 = new Truck("Ford", "F150");

    System.out.println(t1);
    System.out.println(t1.equals(t3));

    System.out.println("My " + t1.make() + " " + t1.model() + " truck is cool!");

//    t1.make = // NOPE, it's private and final
  }
}

//import java.util.Objects;
//
//public class Truck {
//  private String make;
//  private String model;
//
//  public String getMake() {
//    return make;
//  }
//
//  public String getModel() {
//    return model;
//  }
//
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//
//    Truck truck = (Truck) o;
//
//    if (!Objects.equals(make, truck.make)) return false;
//    return Objects.equals(model, truck.model);
//  }
//
//  @Override
//  public int hashCode() {
//    int result = make != null ? make.hashCode() : 0;
//    result = 31 * result + (model != null ? model.hashCode() : 0);
//    return result;
//  }
//
//  @Override
//  public String toString() {
//    return "Truck{" +
//        "make='" + make + '\'' +
//        ", model='" + model + '\'' +
//        '}';
//  }
//}
