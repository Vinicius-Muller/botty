package botty.ui.buttons;

public class SendButton {
  private static String placeholder;
  private static Runnable method;

  public SendButton(String placeholder, Runnable action) {
    SendButton.placeholder = placeholder;
    method = action;
  }
}
