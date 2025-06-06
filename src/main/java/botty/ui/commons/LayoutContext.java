package botty.ui.commons;

import javafx.geometry.Insets;
import javafx.scene.Node;
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

  public static void addChild(javafx.scene.Node node) {
    if (layout != null && node != null) {
      layout.getChildren().add(node);
    }
  }

  public static void addChildToPriorityPosition(javafx.scene.Node node) {
    if (layout != null && node != null) {
      layout.getChildren().add(0, node);
    }
  }

  public static void addMultipleChilds(javafx.scene.Node... nodes) {
    if (layout != null && nodes != null) {
      layout.getChildren().addAll(nodes);
    }
  }

  public static void deleteLayoutNode(int position) {
    layout.getChildren().remove(position);
  }

  public static Node getLayoutNode(int position) {
    return layout.getChildren().get(position);
  }

  public static int getLayoutNodeIndex(Node node) {
    if (layout != null && node != null) {
      return layout.getChildren().indexOf(node);
    }
    return -1;
  }
}