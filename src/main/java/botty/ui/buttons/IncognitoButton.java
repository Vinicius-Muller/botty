package botty.ui.buttons;

import botty.ui.buttons.factories.RoundButtonFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;
import javafx.stage.Stage;

public class IncognitoButton extends StackPane {
    private final Button incognitoButton;
    private boolean disabled = false;
    private boolean isSecure = false;

    public IncognitoButton(Stage primaryStage) {
        this.incognitoButton = RoundButtonFactory.createButton("\uD83D\uDD12");
        this.setActions(primaryStage);

        String os = System.getProperty("os.name").toLowerCase();
        if (!os.contains("win")) {
            this.toggleDisableButton();
            Tooltip tooltip = new Tooltip("Incognito mode only works in Windows OS");
            this.incognitoButton.setTooltip(tooltip);
            this.incognitoButton.setOnMouseClicked(null);
        }

        getChildren().add(incognitoButton);
    }

    private void setActions(Stage primaryStage) {
        this.incognitoButton.setOnMouseClicked(event -> {
            this.isSecure = !this.isSecure;
            this.setWindowSecure(primaryStage, this.isSecure);
            toggleDisableButton();
        });
    }

    public interface User32Extra extends StdCallLibrary {
        User32Extra INSTANCE = Native.load("user32", User32Extra.class);

        int WDA_NONE = 0;
        int WDA_EXCLUDEFROMCAPTURE = 11;

        boolean SetWindowDisplayAffinity(HWND hWnd, int dwAffinity);
    }

    private void setWindowSecure(Stage stage, boolean secure) {
        HWND hwnd = User32.INSTANCE.FindWindow(null, stage.getTitle());
        if (hwnd != null) {
            int mode = secure ? User32Extra.WDA_EXCLUDEFROMCAPTURE : User32Extra.WDA_NONE;
            boolean result = User32Extra.INSTANCE.SetWindowDisplayAffinity(hwnd, mode);
            System.out.println("Set security mode: " + secure + " -> Result: " + result);
        } else {
            System.out.println("Could not find window handle.");
        }
    }

    private void toggleDisableButton() {
        this.disabled = !this.disabled;

        if(this.disabled) {
            this.incognitoButton.setOpacity(0.5);
        } else {
            this.incognitoButton.setOpacity(1.0);
        }
    }
}
