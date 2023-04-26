import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PasswordGeneratorGUI extends Application {

    private PasswordGeneratorApp passwordGeneratorApp = new PasswordGeneratorApp();
    private PasswordStrengthChecker passwordStrengthChecker = new PasswordStrengthChecker();

    private Label passwordLabel;
    private Label strengthLabel;
    private TextField passwordField;
    private Button generateButton;
    private Button strengthButton;

    @Override
    public void start(Stage primaryStage) {

        // Password generation controls
        passwordLabel = new Label("Password:");
        passwordField = new TextField();
        passwordField.setEditable(false);
        generateButton = new Button("Generate");
        generateButton.setOnAction(event -> passwordField.setText(passwordGeneratorApp.getGeneratedPassword(passwordField.getText()).toString()));

        // Password strength checking controls
        strengthLabel = new Label("Strength:");
        TextField strengthField = new TextField();
        strengthField.setEditable(false);
        strengthButton = new Button("Check");
        strengthButton.setOnAction(event -> strengthField.setText(passwordStrengthChecker.checkStrength(passwordField.getText()).toString()));

        // Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25,    25, 25));

    grid.add(passwordLabel, 0, 0);
    grid.add(passwordField, 1, 0);
    grid.add(generateButton, 2, 0);
    grid.add(strengthLabel, 0, 1);
    grid.add(strengthField, 1, 1);
    grid.add(strengthButton, 2, 1);

    VBox vbox = new VBox(10);
    vbox.setAlignment(Pos.CENTER);
    vbox.getChildren().add(grid);

    HBox hbox = new HBox(10);
    hbox.setAlignment(Pos.CENTER);
    hbox.getChildren().add(vbox);

    Scene scene = new Scene(hbox, 400, 200);

    primaryStage.setTitle("Password Generator App");
    primaryStage.setScene(scene);
    primaryStage.show();
}

@Override
public void stop() throws Exception {
    super.stop();
    passwordGeneratorApp.stopGeneratingPasswords();
}

public static void main(String[] args) {
    launch(args);
}
}


