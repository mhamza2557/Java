import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class KMCountByOilChange extends Application {
    private TextField tfEnterKM = new TextField();
    private TextField tfEnterVehicleNumber = new TextField();
    private Label lEnterKM = new Label("Enter KM");
    private Label lEnterVehicleNumber = new Label("Enter Vehicle Name");
    private Button btEnter = new Button("Enter");
    private Button btOpenFile = new Button("Open File");
    private Button btExit = new Button("Exit");

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5); gridPane.setVgap(5);
        gridPane.add(lEnterVehicleNumber,0,0);
        gridPane.add(tfEnterVehicleNumber,1,0);
        gridPane.add(lEnterKM,0,1);
        gridPane.add(tfEnterKM,1,1);
        gridPane.add(btEnter,1,2);
        gridPane.add(btOpenFile,1,2);
        gridPane.add(btExit,0,2);

        tfEnterVehicleNumber.setPromptText("KJT-1234");
        tfEnterKM.setPromptText("Enter KM");

        gridPane.setAlignment(Pos.CENTER);
        tfEnterVehicleNumber.setAlignment(Pos.BOTTOM_LEFT);
        tfEnterKM.setAlignment(Pos.BOTTOM_LEFT);
        GridPane.setHalignment(btEnter, HPos.RIGHT);
        GridPane.setHalignment(btOpenFile, HPos.LEFT);
        GridPane.setHalignment(btExit, HPos.CENTER);

        btEnter.setOnAction(e -> textFileWriter());
        btOpenFile.setOnAction(e -> textFileOpener());
        btExit.setOnAction(e -> btExit());

        Scene scene = new Scene(gridPane,400,250);
        gridPane.setStyle("-fx-background-color: #82ff77");

        Image img = new Image("file:OilChange.png");
        primaryStage.getIcons().add(img);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Oil Change");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void textFileWriter() {
        if (tfEnterVehicleNumber.getLength() == 0 && tfEnterKM.getLength() == 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter correct information");
            alert.show();
        }

        if (tfEnterVehicleNumber.getLength() > 0 && tfEnterKM.getLength() > 0) {
            String vehicleNumberLowerCase = String.valueOf(tfEnterVehicleNumber.getText());
            String kmValue = String.valueOf(tfEnterKM.getText());
            String vehicleNumberUpperCase = vehicleNumberLowerCase.toUpperCase();
            OilChange oilChange = new OilChange(vehicleNumberUpperCase, kmValue);
            oilChange.textFileWriter();
            tfEnterVehicleNumber.setText(null);
            tfEnterKM.setText(null);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Successful");
            alert.setHeaderText("Thank you");
            alert.show();

        }
    }
    private void textFileOpener() {
        OilChange.textFileOpener();
    }
    private void btExit() {
        System.exit(0);
    }

    public static void main(String[] MH) {
        Application.launch(MH);
    }
}
