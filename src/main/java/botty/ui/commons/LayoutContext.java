package botty.ui.commons;

import javafx.geometry.Insets;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class LayoutContext {
  private static VBox layout;

  public static void initializeLayoutContext() {
    layout = new VBox(10);
    layout.setPadding(new Insets(20));
    layout.setFillWidth(true);
    layout.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
    layout.setStyle("-fx-background-color: white;");
  
    VBox.setVgrow(layout, Priority.ALWAYS);
  }

  public static VBox getLayoutContext() {
    return layout;
  }
}