import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;


public class NARDA extends Application {
    private Button bbForm = new Button("B-Form");
    private Button bCnic = new Button("CNIC");
    private Button bInternationalCnic = new Button("International CNIC");


    private Label lFatherName = new Label("Father Name ");
    private Label lMotherName = new Label("Mother Name ");
    private Label lTypeService = new Label("Type Service ");
    private Label lBirthCertificate = new Label("Birth Certificate ");
    private Label lCountBrother = new Label("Brothers ");
    private Label lCountSister = new Label("Sisters ");
    private Label lFee = new Label("Fee");

    private TextField tfFatherName = new TextField();
    private TextField tfMotherName = new TextField();
    private TextField tfTypeService = new TextField();
    private TextField tfBirthCertificate = new TextField();
    private TextField tfCountBrother = new TextField();
    private TextField tfCountSister = new TextField();
    private TextField tfFee = new TextField();
    private Button bTap1 = new Button("Submit");

    private Label lFatherName1 = new Label("Father Name ");
    private Label lMotherName1 = new Label("Mother Name ");
    private Label lTypeService1 = new Label("Type Service ");
    private Label lBform = new Label("B-Form");
    private Label lAge = new Label("Age");
    private Label lCnicType = new Label("CNIC Type");
    private Label lFee1 = new Label("Fee");

    private TextField tfFatherName1 = new TextField();
    private TextField tfMotherName1 = new TextField();
    private TextField tfTypeService1 = new TextField();
    private TextField tfBform = new TextField();
    private TextField tfAge = new TextField();
    private TextField tfCnicType = new TextField();
    private TextField tfFee1 = new TextField();
    private Button bTap2 = new Button("Submit");

    private Label lFatherName2 = new Label("Father Name ");
    private Label lMotherName2 = new Label("Mother Name ");
    private Label lTypeService2 = new Label("Type Service ");
    private Label lpassport = new Label("Passport");
    private Label lFee2 = new Label("Fee");

    private TextField tfFatherName2 = new TextField();
    private TextField tfMotherName2 = new TextField();
    private TextField tfTypeService2 = new TextField();
    private TextField tfpassport = new TextField();
    private TextField tfFee2 = new TextField();
    private Button bTap3 = new Button("Submit");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(bbForm,0, 0);
        gridPane.add(bCnic, 0, 1);
        gridPane.add(bInternationalCnic, 0, 2);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHalignment(bbForm, HPos.CENTER);
        gridPane.setHalignment(bCnic, HPos.CENTER);
        gridPane.setHalignment(bInternationalCnic, HPos.CENTER);

        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Label");
        primaryStage.setScene(scene);
        primaryStage.show();


        //---------------------------------------------

        GridPane gridPane1 = new GridPane();
        Stage stage = new Stage();
        Scene scene1 = new Scene(gridPane1, 400, 250);
        stage.setTitle("B-Form");
        stage.setScene(scene1);

        gridPane1.add(lFatherName, 0, 0);
        gridPane1.add(tfFatherName, 1, 0);
        gridPane1.add(lMotherName, 0, 1);
        gridPane1.add(tfMotherName, 1, 1);
        gridPane1.add(lTypeService, 0, 2);
        gridPane1.add(tfTypeService, 1, 2);
        gridPane1.add(lBirthCertificate, 0, 3);
        gridPane1.add(tfBirthCertificate, 1, 3);
        gridPane1.add(lCountBrother, 0, 4);
        gridPane1.add(tfCountBrother, 1, 4);
        gridPane1.add(lCountSister, 0, 5);
        gridPane1.add(tfCountSister, 1, 5);
        gridPane1.add(lFee, 0, 6);
        gridPane1.add(tfFee, 1, 6);
        gridPane1.add(bTap1, 1, 7);

        gridPane1.setAlignment(Pos.CENTER);
        lFatherName.setAlignment(Pos.BOTTOM_LEFT);
        lMotherName.setAlignment(Pos.BOTTOM_LEFT);
        lTypeService.setAlignment(Pos.BOTTOM_LEFT);
        lBirthCertificate.setAlignment(Pos.BOTTOM_LEFT);
        lCountBrother.setAlignment(Pos.BOTTOM_LEFT);
        lCountSister.setAlignment(Pos.BOTTOM_LEFT);
        lFee.setAlignment(Pos.BOTTOM_LEFT);

        tfFee.setEditable(false);

        gridPane1.setHalignment(bTap1, HPos.CENTER);

        bbForm.setOnAction(e -> stage.show());
        bTap1.setOnAction(e -> caculateBform());

        tfFatherName.setPromptText("Enter Father's Name");
        tfMotherName.setPromptText("Enter Mother's Name");
        tfTypeService.setPromptText("Normal or Urgent or Executive");
        tfBirthCertificate.setPromptText("true or false");
        tfCountBrother.setPromptText("How many brothers");
        tfCountSister.setPromptText("How many sisters");


        //---------------------------------------


        GridPane gridPane2 = new GridPane();
        Stage stage1 = new Stage();
        Scene scene2 = new Scene(gridPane2, 400, 250);
        stage1.setTitle("CNIC");
        stage1.setScene(scene2);

        gridPane2.add(lFatherName1, 0, 0);
        gridPane2.add(tfFatherName1, 1, 0);
        gridPane2.add(lMotherName1, 0, 1);
        gridPane2.add(tfMotherName1, 1, 1);
        gridPane2.add(lTypeService1, 0, 2);
        gridPane2.add(tfTypeService1, 1, 2);
        gridPane2.add(lBform, 0, 3);
        gridPane2.add(tfBform, 1, 3);
        gridPane2.add(lAge, 0, 4);
        gridPane2.add(tfAge, 1, 4);
        gridPane2.add(lCnicType, 0, 5);
        gridPane2.add(tfCnicType, 1, 5);
        gridPane2.add(lFee1, 0, 6);
        gridPane2.add(tfFee1, 1, 6);
        gridPane2.add(bTap2, 1, 7);

        gridPane2.setAlignment(Pos.CENTER);
        lFatherName1.setAlignment(Pos.BOTTOM_LEFT);
        lMotherName1.setAlignment(Pos.BOTTOM_LEFT);
        lTypeService1.setAlignment(Pos.BOTTOM_LEFT);
        lBform.setAlignment(Pos.BOTTOM_LEFT);
        lAge.setAlignment(Pos.BOTTOM_LEFT);
        lCnicType.setAlignment(Pos.BOTTOM_LEFT);
        lFee1.setAlignment(Pos.BOTTOM_LEFT);
        tfFee1.setEditable(false);

        gridPane2.setHalignment(bTap2, HPos.CENTER);

        bCnic.setOnAction(e -> stage1.show());
        bTap2.setOnAction(e -> calulateCnic());

        tfFatherName1.setPromptText("Enter Father's Name");
        tfMotherName1.setPromptText("Enter Mother's Name");
        tfTypeService1.setPromptText("Normal or Urgent or Executive");
        tfBform.setPromptText("true or false");
        tfAge.setPromptText("greater than 18");
        tfCnicType.setPromptText("CNIC or SNIC");

        //---------------------------------------

        GridPane gridPane3 = new GridPane();
        Stage stage2 = new Stage();
        Scene scene3 = new Scene(gridPane3, 400, 250);
        stage2.setTitle("InternationalCNIC");
        stage2.setScene(scene3);

        gridPane3.add(lFatherName2, 0, 0);
        gridPane3.add(tfFatherName2, 1, 0);
        gridPane3.add(lMotherName2, 0, 1);
        gridPane3.add(tfMotherName2, 1, 1);
        gridPane3.add(lTypeService2, 0, 2);
        gridPane3.add(tfTypeService2, 1, 2);
        gridPane3.add(lpassport, 0, 3);
        gridPane3.add(tfpassport, 1, 3);
        gridPane3.add(lFee2, 0, 4);
        gridPane3.add(tfFee2, 1, 4);
        gridPane3.add(bTap3, 1, 5);

        gridPane3.setAlignment(Pos.CENTER);
        lFatherName2.setAlignment(Pos.BOTTOM_LEFT);
        lMotherName2.setAlignment(Pos.BOTTOM_LEFT);
        lTypeService2.setAlignment(Pos.BOTTOM_LEFT);
        lpassport.setAlignment(Pos.BOTTOM_LEFT);
        lFee2.setAlignment(Pos.BOTTOM_LEFT);
        tfFee2.setEditable(false);

        gridPane3.setHalignment(bTap3, HPos.CENTER);

        bInternationalCnic.setOnAction(e -> stage2.show());
        bTap3.setOnAction(e -> internationalCnic());

        tfFatherName2.setPromptText("Enter Father's Name");
        tfMotherName2.setPromptText("Enter Mother's Name");
        tfTypeService2.setPromptText("Normal or Urgent or Executive");
        tfpassport.setPromptText("true or false");


    }

    void caculateBform() {
        String fatherName = new String(tfFatherName.getText());
        String motherName = new String(tfFatherName.getText());
        String typeService = new String(tfTypeService.getText());
        int countBrothers = Integer.parseInt(tfCountBrother.getText());
        int countSisters = Integer.parseInt(tfCountSister.getText());
        boolean birthCertificate = Boolean.parseBoolean(tfBirthCertificate.getText());

        BForm bForm = new BForm(fatherName, motherName, typeService, birthCertificate, countBrothers, countSisters);

        tfFee.setText(String.format(String.valueOf(bForm.typeService())));

    }

    void calulateCnic() {
        String fatherName = new String(tfFatherName1.getText());
        String motherName = new String(tfFatherName1.getText());
        String typeService = new String(tfTypeService1.getText());
        boolean bForm = Boolean.parseBoolean(tfBform.getText());
        int age = Integer.parseInt(tfAge.getText());
        String cnicType = new String(tfCnicType.getText());

        Cnic cnic = new Cnic(fatherName, motherName, typeService, bForm, age, cnicType);

        tfFee1.setText(String.format(String.valueOf(cnic.typeService())));
    }

    void internationalCnic() {
        String fatherName = new String(tfFatherName2.getText());
        String motherName = new String(tfFatherName2.getText());
        String typeService = new String(tfTypeService2.getText());
        boolean passport = Boolean.parseBoolean(tfpassport.getText());

        InternationalCnic internationalCnic = new InternationalCnic(fatherName, motherName, typeService, passport);

        tfFee2.setText(String.format(String.valueOf(internationalCnic.typeService())));
    }

}
