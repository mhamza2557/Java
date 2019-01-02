import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class DataWhenUnknown extends Application {
    private Label lGivenPercent = new Label("Enter Given Percent");
    private Label lEnterGivenData = new Label("Enter Given Data");
    private Label lTotalDataMB = new Label("Total Data");
    private Label lTotalDataGB = new Label("Total Data");
    private Label lMB = new Label("MB");
    private Label lGB = new Label("GB");
    private TextField tfGivenPercent = new TextField();
    private TextField tfEnterGivenData = new TextField();
    private TextField tfShowDataMB = new TextField();
    private TextField tfShowDataGB = new TextField();
    private Button btCalculateTotalData = new Button("Calculate");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(lGivenPercent,0 ,0);
        gridPane.add(tfGivenPercent, 1, 0);
        gridPane.add(lEnterGivenData,0 ,1);
        gridPane.add(tfEnterGivenData,1 ,1);
        gridPane.add(lTotalDataMB,0 ,2);
        gridPane.add(tfShowDataMB,1 ,2);
        gridPane.add(lMB,1,2);
        gridPane.add(lTotalDataGB,0 ,3);
        gridPane.add(tfShowDataGB,1 ,3);
        gridPane.add(lGB,1,3);
        gridPane.add(btCalculateTotalData,1 ,4);

        gridPane.setAlignment(Pos.CENTER);
        GridPane.setHalignment(btCalculateTotalData, HPos.RIGHT);
        GridPane.setHalignment(lMB, HPos.RIGHT);
        GridPane.setHalignment(lGB, HPos.RIGHT);
        tfShowDataMB.setEditable(false);
        tfShowDataGB.setEditable(false);

        btCalculateTotalData.setOnAction(e -> calculateData());

        Scene scene = new Scene(gridPane,400 ,250);
        primaryStage.setTitle("Data Calculate");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateData() {
        double givenPercent = Double.parseDouble(tfGivenPercent.getText());
        double givenData = Double.parseDouble(tfEnterGivenData.getText());

        CalculateData calculateData = new CalculateData();
        double mb = calculateData.CalculateDataWhenUnknownMB(givenPercent,givenData);
        double gb = calculateData.CalculateDataWhenUnknownGB(givenPercent,givenData);

        tfShowDataMB.setText(String.format("%.2f", mb));
        tfShowDataGB.setText(String.format("%.2f", gb));




    }
}
