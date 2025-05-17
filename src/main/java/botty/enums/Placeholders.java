package botty.enums;

public enum Placeholders {
  TITLE("What do you want to translate ?"),
  TRANSLATORTEXTFIELD("Type your text here");

  private final String text;

  Placeholders(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}