package botty.enums;

public enum Placeholders {
  TITLE("How can I help you today ?"),
  TRANSLATORTEXTFIELD("Type your text here");

  private final String text;

  Placeholders(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}