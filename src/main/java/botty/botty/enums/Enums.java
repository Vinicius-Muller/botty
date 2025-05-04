package botty.botty.enums;

import java.util.HashMap;
import java.util.Map;

public class Enums {
  private static final Map<String, int[]> textMap = new HashMap<>();

  static {
    textMap.put("TITLE", new int[] { 10, 90 });
    textMap.put("TEXT", new int[] { 10, 90 });
  }

  public static int[] getStyle(String type) {
    return textMap.getOrDefault(type, new int[] {});
  }
}
