package botty.enums;

public enum Kinds {
  TITLE("TITLE"),
  TEXT("TEXT");

  private final String value;

  Kinds(String value) {
    this.value = value;
  }

  public String getKindValue() {
    return value;
  }
}