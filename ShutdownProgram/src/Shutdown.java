import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Shutdown extends Application {
    private Button btShutdown = new Button("Shutdown");
    private Button btRestart = new Button("Restart");
    private Button btLogOff = new Button("Log Off");
    private Button btHibernate = new Button("Hibernate");
    private Button btSignOut = new Button("Sign Out");
    private Button btClose = new Button("Close");

    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane,310,100);
        gridPane.setStyle("-fx-background-color: darkseagreen");

        gridPane.add(btShutdown,0,0);
        gridPane.add(btRestart,1,0);
        gridPane.add(btLogOff,2,0);

        gridPane.add(btHibernate,0,1);
        gridPane.add(btSignOut,1,1);
        gridPane.add(btClose,2,1);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setHgap(5);
        gridPane.setVgap(5);

        btShutdown.setOnAction(e -> operation(1));
        btRestart.setOnAction(e -> operation(2));
        btLogOff.setOnAction(e -> operation(3));
        btHibernate.setOnAction(e -> operation(4));
        btSignOut.setOnAction(e -> operation(5));
        btClose.setOnAction(e -> operation(6));

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void operation(int option) {
        Runtime runtime = Runtime.getRuntime();
        try {
            if (option == 1) //shutdown
                runtime.exec("cmd /c shutdown -s");
            else if (option == 2) //restart
                runtime.exec("cmd /c shutdown -r");
            else if (option == 3) //logoff
                runtime.exec("cmd /c shutdown -l");
            else if (option == 4) //hibernate
                runtime.exec("cmd /c shutdown -h");
            else if (option == 5) //signout
                runtime.exec("cmd /c rundll32.exe user32.dll,LockWorkStation");
            else if (option == 6) //exit GUI
                System.exit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
