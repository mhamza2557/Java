import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class Main extends Application {

    private final String URL_1 = "https://www.vocabulary.com/dictionary/";
    private final String URL_2 = "https://www.ijunoon.com/dictionary/";

    //Labels
    private Label lEnglishWord = new Label("English: ");
    private Label lUrduWord = new Label("Urdu: ");
    private Label lRomanWord = new Label("Roman: ");
    private Label lSynonym = new Label("Synonym: ");
    private Label lIdiom = new Label("Idiom: ");
    private Label lPronunciation = new Label("Pronunciation: ");
    private Label lShortDescription = new Label("Short: ");

    //TextFields
    private TextField tfEnglishWord = new TextField();
    private TextField tfUrduWord = new TextField();
    private TextField tfRomanWord = new TextField();
    private TextField tflSynonym = new TextField();
    private TextField tfIdiom = new TextField();
    private TextField tfPronunciation = new TextField();

    //TextArea
    private TextArea taShortDescription = new TextArea();

    //Image and ImageView
    private Image image = new Image(getImageURL(tfEnglishWord.getText()));
    private ImageView imageView = new ImageView(image);

    //Buttons
    private Button btHistory = new Button("History");
    private Button btEnter = new Button("Enter");
    private Button btClean = new Button("Clean");
    private Button btExit = new Button("Exit");

    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 500, 430);

        gridPane.add(lEnglishWord,0,0);
        gridPane.add(tfEnglishWord,1,0);

        tfUrduWord.setEditable(false);
        gridPane.add(lUrduWord,0,1);
        gridPane.add(tfUrduWord,1,1);

        tfRomanWord.setEditable(false);
        gridPane.add(lRomanWord,0,2);
        gridPane.add(tfRomanWord,1,2);

        tflSynonym.setEditable(false);
        gridPane.add(lSynonym,0,3);
        gridPane.add(tflSynonym,1,3);

        tfIdiom.setEditable(false);
        gridPane.add(lIdiom,0,4);
        gridPane.add(tfIdiom,1,4);

        tfPronunciation.setEditable(false);
        gridPane.add(lPronunciation,0,6);
        gridPane.add(tfPronunciation,1,6);

        taShortDescription.setEditable(false);
        taShortDescription.setWrapText(true);
        taShortDescription.setPrefWidth(14);
        gridPane.add(lShortDescription,0,5);
        gridPane.add(taShortDescription,1,5);

        gridPane.add(btHistory,0,7);
        gridPane.add(btEnter,1,7);
        gridPane.add(btClean,1,7);
        gridPane.add(btExit,1,7);

        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        gridPane.add(imageView,2,5);

        gridPane.setAlignment(Pos.CENTER);
        GridPane.setHalignment(btHistory,HPos.RIGHT);
        GridPane.setHalignment(btClean, HPos.CENTER);
        GridPane.setHalignment(btExit, HPos.RIGHT);

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setStyle("-fx-background-color: #8eb84b");

        btHistory.setOnAction(e -> setBtHistory() );
        btEnter.setOnAction(e -> setBtEnter());
        btClean.setOnAction(e -> setBtClean());
        btExit.setOnAction(e -> System.exit(0));

        Image icon = new Image("file:dictionary.png");

        //primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Dictionary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setBtHistory() {
        historyFileOpener();
        System.out.println("setBtHistory() pressed");
    }

    private void setBtEnter() {
        String englishWord = tfEnglishWord.getText();
//        DataFetch.setEnglishWord(englishWord);

        if (englishWord.length() > 0) {
            try {
                tfUrduWord.setText(getUrdu(englishWord));
                tfRomanWord.setText(getRoman(englishWord));
                tflSynonym.setText(getSynonym(englishWord));
                tfIdiom.setText(getIdioms(englishWord));
                tfPronunciation.setText(getPronunciation(englishWord));

                taShortDescription.setText(getShortDescription(englishWord));

                image = new Image(getImageURL(englishWord));
                imageView.setImage(image);

                System.out.println(getImageURL(englishWord));

                historyFileWriter();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Enter correct word");
            alert.show();
        }
        System.out.println("setBtEnter() pressed");
    }

    private void setBtClean() {
        if (tfEnglishWord.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter word");
            alert.show();
        } else {
            tfEnglishWord.setText("");
            tfUrduWord.setText(null);
            tfRomanWord.setText(null);
            tflSynonym.setText(null);
            tfIdiom.setText(null);
            tfPronunciation.setText(null);

            taShortDescription.setText(null);

            image = new Image(getImageURL(tfEnglishWord.getText()));
            imageView.setImage(image);
        }
        System.out.println("setBtClean() pressed");
    }

    private String getUrdu(String englishWord) {
        try {
            final String URL = URL_2 + englishWord + "-urdu-meaning/";
            Document document2 = Jsoup.connect(URL).get();
            Elements data = document2.select(".urdu_results");
            List<String> urdu = data.select(".u").eachText();
            return urdu.get(0);
        } catch (Exception e) {
            return "";
        }
    }

    private String getRoman(String englishWord) {
        try {
            final String URL = URL_2 + englishWord + "-urdu-meaning/";
            Document document2 = Jsoup.connect(URL).get();
            Elements data = document2.select(".urdu_results");
            List<String> roman = data.select(".r").eachText();
            return roman.get(0);
        } catch (Exception e) {
            return "";
        }
    }

    private String getShortDescription(String englishWord) {
        try {
            final String URL = URL_1 + englishWord;
            Document document1 = Jsoup.connect(URL).get();
            Elements shortDescription = document1.select(".short");
            return shortDescription.text();
        } catch (Exception e) {
            return "";
        }
    }

    private String getSynonym(String englishWord) {
        try {
            final String URL = URL_1 + englishWord;
            Document document1 = Jsoup.connect(URL).get();
            Elements synonymWords = document1.select(".instances");
            List<String> synonymWord = synonymWords.select(".word").eachText();
            return synonymWord.get(0);
        } catch (Exception e) {
            return "";
        }
    }

    private String getIdioms(String englishWord) {
        try {
            String URL_3 = "https://dictionary.cambridge.org/dictionary/english/";
            final String URL = URL_3 + englishWord;
            Document document = Jsoup.connect(URL).get();
            Elements elements = document.select(".cols__col");
            List<String> phrase = elements.select(".phrase").eachText();
            return phrase.get(0);
        } catch (Exception e) {
            return "";
        }
    }

    private String getPronunciation(String englishWord) {
        try {
            String URL_4 = "https://www.thefreedictionary.com/";
            final String URL = URL_4 + englishWord;
            Document document = Jsoup.connect(URL).get();
            Elements definition = document.select("div#Definition");
            List<String> pronunciations = definition.select("span.pron").eachText();
            return pronunciations.get(0);
        } catch (Exception e) {
            return "";
        }
    }

    private String getImageURL(String englishWord) {
        return "https://www.ijunoon.com/sw-store/images/dictionary/" +
                englishWord + ".jpg";
    }

    private void historyFileWriter() {
        String englishWord = tfEnglishWord.getText();
        try(FileWriter fileWriter = new FileWriter("History.MHamza2551",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println("English: " + englishWord);
            printWriter.println("Urdu: " + getUrdu(englishWord));
            printWriter.println("Roman: " + getRoman(englishWord));
            printWriter.println("Synonym: " + getSynonym(englishWord));
            printWriter.println("Idiom: " + getIdioms(englishWord));
            printWriter.println("Short: " + getShortDescription(englishWord));
            printWriter.println("Pronunciation: " + getPronunciation(englishWord));
            printWriter.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void historyFileOpener() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe","History.MHamza2551");
            processBuilder.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}