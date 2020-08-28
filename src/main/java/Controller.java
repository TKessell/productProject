import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

public class Controller {

    @FXML
    private Label lblOutput;

    public void sayHello() {
        lblOutput.setText("Hello FXML!");

    }

    public void closeProgram(javafx.event.ActionEvent actionEvent) {
        System.exit(0);
    }
}