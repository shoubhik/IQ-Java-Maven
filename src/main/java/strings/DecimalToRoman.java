package strings;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class DecimalToRoman {

  Map<Integer, String> romanVaueMap = ImmutableMap.<Integer, String>builder()
      .put(1, "i")
      .put(   4, "iv")
      .put(5, "v")
      .put(9, "ix")
      .put(10, "x")
      .put(40, "xl")
      .put(50, "l")
      .put(90, "xc")
      .put(100, "c")
      .put(400, "cd")
      .put(500, "d")
      .put(900, "cm")
      .put(1000, "m")
      .build();

  String convertToRoman(int num) {
    if(num == 0 || num > 3999)
      throw new RuntimeException("not a valid number");
    return null;
  }

}
