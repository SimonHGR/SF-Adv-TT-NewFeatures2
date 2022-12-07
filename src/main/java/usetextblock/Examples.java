package usetextblock;

public class Examples {
  public static void main(String[] args) {
    int x = 99;
    String message = String.format("""
          Hello, this is
        a ""\"""\"""message\n
             that %d spans
        four lines!
        """, x)/*.indent(8)*/;
    System.out.println(message);
  }
}
