package newswitches;

public class Example {
  public static void main(String[] args) {
    int x = (int)(Math.random() * 10);

//    String message;
//    if (x < 2) message = "Small";
//    else message = "Bigger";

//    String message = (x < 2) ? "Small" : "Bigger";

    String message = switch (x) {
      case 0, 1, 2 -> {
        String prefix = "It's ";
        yield prefix + "Small";
      }
      default -> "Bigger";
    };

//    String message = switch (x) {
//      case 0:
//      case 1:
//      case 2: yield "Small";
//      default: yield "Bigger";
//    };

//    switch (x) {
//      case 0 -> {
//        String messageRoot = "it's";
//        System.out.println(messageRoot + " kinda small");
//      }
//      default -> System.out.println("it's big");
//    }

//    switch (x) {
//      case 0:
//        int y;
//      case 1:
//      case 2:
//        System.out.println("it's kinda small");
//        break;
//      default:
//        System.out.println("it's big");
//        break;
//    }
  }
}
