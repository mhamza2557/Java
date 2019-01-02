import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EnterColorName extends Application {

    private TextField tfColor = new TextField();
    private Button btColor = new Button("Enter Color Name");
    private Button btShowColorNames = new Button("Color Names");
    private Button btExit = new Button("Exit");
    private final String colorMethod = "-fx-background-color: ";
    private static String colorName = "gainsboro";
    private static GridPane gridPane = new GridPane();

    @Override
    public void start(Stage primaryStage) {
        gridPane.setHgap(5); gridPane.setVgap(5);
        gridPane.add(tfColor,0,1);
        gridPane.add(btColor,0,2);
        gridPane.add(btShowColorNames,0,3);
        gridPane.add(btExit,0,4);

        btColor.setMaxWidth(150);
        btShowColorNames.setMaxWidth(150);
        btExit.setMaxWidth(150);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle(colorMethod + colorName);

        tfColor.setPromptText("Enter Color Name");

        Scene scene = new Scene(gridPane,250,250);
        primaryStage.setTitle("Choose Color");
        primaryStage.setScene(scene);
        primaryStage.show();

        btColor.setOnAction(event -> getColor());
        btShowColorNames.setOnAction(event -> secondWindowsOpen());
        btExit.setOnAction(event -> System.exit(0) );
    }

    private void getColor() {
        colorName = tfColor.getText();
        gridPane.setStyle(colorMethod + colorName);

        final String textFileName = "ColorNames.txt";
        BufferedReader br; FileReader fr; String line;
        int found = 1;

        try {
            fr = new FileReader(textFileName);
            br = new BufferedReader(fr);

            try {
                while((line = br.readLine()) != null) {
                    String[] allColorNames = line.split(" ");

                    for (String searchColorNames : allColorNames) {
                        if (searchColorNames.equals(colorName)) {
                            System.out.println("FOUND");
                            found = 0;
                        }
                    }
                } br.close();
            } catch (IOException e) { e.getMessage(); }
        } catch (FileNotFoundException e) { e.getMessage(); }

        if (found == 1) {
            System.out.println("NOT-FOUND");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter correct information");
            alert.show();
        }
    }
    private void secondWindowsOpen() {
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();

        gridPane.setHgap(5); gridPane.setVgap(5);
        Image image = new Image("file:ColorNames.PNG");
        ImageView imageView = new ImageView(image);
        Button btExit = new Button("Exit");

        gridPane.setAlignment(Pos.CENTER);
        GridPane.setHalignment(btExit, HPos.CENTER);
        btExit.setMaxWidth(400);

        gridPane.add(imageView,0,0);
        gridPane.add(btExit,0,1);

        Scene scene = new Scene(gridPane,771,650);
        stage.setTitle("Color Names");
        stage.setScene(scene);
        stage.show();

        btExit.setOnAction(event -> stage.close());
    }

    public static void main(String[] MH) {
        Application.launch(MH);
    }
}
