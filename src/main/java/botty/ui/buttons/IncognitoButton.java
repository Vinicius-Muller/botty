package botty.ui.buttons;

import botty.ui.buttons.factories.RoundButtonFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class IncognitoButton extends StackPane {
    private final Button incognitoButton;

    public IncognitoButton() {
        incognitoButton = RoundButtonFactory.createButton("\uD83D\uDD12");
        setActions();

        getChildren().add(incognitoButton);
    }

    private void setActions() {
        this.incognitoButton.onMouseClickedProperty();
    }
}
