package firstexamples;

import static java.lang.System.out;

public class TempConv {

//  public static int fToC(int fTemp) {
  public static double fToC(double fTemp) {
//    int cTemp = (5 / 9) * (fTemp - 32);
//    int cTemp = (int)((5.0 / 9) * (fTemp - 32));
    double cTemp = (5.0 / 9) * (fTemp - 32);
    return cTemp;
  }
  public static void main(String[] args) {
    int fTemp = 212;
    double cTemp = fToC(fTemp);
    out.println(fTemp + "F -> " + cTemp + "C");

    double big = 3.456E+120;
    out.println(big);
    int broken = (int)big;
    out.println(broken);

    int ok = 1_234_567_890;
    // "widening" conversions, automatic, no complaints, but might lose precision
    float okFloat = ok;
    out.printf("ok is %d, okFloat is %12.1f\n", ok, okFloat);
  }
}
