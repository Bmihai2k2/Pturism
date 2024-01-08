package com.example.agentieturism;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HelloApplication extends Application {

    private Map<String, List<String>> zboruri; // Mapa cu zborurile
    private Stage primaryStage;
    private String selectOra; // Variabila pentru a retine ora selectata
    private String selectOras; // Variabila pentru a retine orasul selectat



    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage; // Retine referinta catre primaryStage
        primaryStage.setResizable(false);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        setupInitialScene();
    }

    private void setupInitialScene() {
        primaryStage.setTitle("Agenție de Turism");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label label = new Label("Bine ai venit în Agenția de Turism!");
        Button button = new Button("Vezi zborurile disponibile");

        button.setOnAction(event -> {
            generateFlightsScene();
        });

        root.getChildren().addAll(label, button);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateFlightsScene() {
        primaryStage.setTitle("Agenție de Turism");

        DestinatiiDictionary destinatiiDictionary = new DestinatiiDictionary();
        List<String> orase = destinatiiDictionary.getOrase();
        zboruri = destinatiiDictionary.generateZboruri();

        VBox vbox = new VBox(10);

        orase.forEach(oras -> {
            Button orasButton = new Button(oras);
            vbox.getChildren().add(orasButton);

            orasButton.setOnAction(e -> {
                List<String> zboruriOras = zboruri.get(oras);
                StringBuilder zboruriString = new StringBuilder("Zborurile pentru " + oras + ": ");
                zboruriOras.forEach(ora -> zboruriString.append(ora).append(", ")); // Construim șirul de zboruri


                Label orasLabel = new Label(oras); // Etichetă pentru afișarea orașului
                Label zboruriLabel = new Label(zboruriString.toString()); // Etichetă pentru afișarea zborurilor

                // Adăugăm butoanele pentru orele disponibile
                VBox oreBox = new VBox(5);
                oreBox.getChildren().addAll(orasLabel, zboruriLabel); // Adăugăm orașul și zborurile în VBox-ul pentru ore

                zboruriOras.forEach(ora -> {
                            Button oraButton = new Button(ora);
                            oreBox.getChildren().add(oraButton);

                            oraButton.setOnAction(event -> {
                                selectOras = oras;
                                selectOra = ora; // Salvează ora selectată

                                // Restul codului existent

                                Button backButton = new Button("Înapoi la orașe");
                                backButton.setOnAction(backEvent -> {
                                    setupInitialScene();
                                });

                                // Actualizează conținutul bonului cu orașul și ora selectate
                                String content = "Zborul dumneavoastra este la ora: " + selectOra + " din orașul " + selectOras;
                                String numeFisier = "bilet.pdf";
                                BiletGenerator.generateBilet(content, numeFisier);
                            });
                        });

                // Adăugăm butonul "Înapoi la orașe"
                Button backButton = new Button("Înapoi la orașe");
                backButton.setOnAction(backEvent -> {
                    setupInitialScene(); // Reafișarea listei de orașe
                });



                // Adăugăm alte orașe, în afară de cel selectat
                List<String> alteOrase = destinatiiDictionary.getOrase();
                alteOrase.remove(oras); // Excludem orașul selectat
                Collections.shuffle(alteOrase, new Random());
                int numarOraseAleatoare = 3;
                for (int i = 0; i < numarOraseAleatoare; i++) {
                    String orasAleator = alteOrase.get(i);
                    Button orasAleatorButton = new Button(orasAleator);
                    oreBox.getChildren().add(orasAleatorButton);

                    orasAleatorButton.setOnAction(event -> {
                        // Aici poți adăuga logica pentru când utilizatorul alege un oraș aleator

                    });
                }

                VBox finalBox = new VBox(10);
                finalBox.getChildren().addAll(oreBox, backButton); // Așezăm butonul de revenire sub butoanele pentru ore

                vbox.getChildren().setAll(finalBox); // Setăm conținutul VBox-ului principal cu VBox-ul pentru ore și butonul de revenire
            });
        });



        // Creăm un ScrollPane și adăugăm VBox-ul în acesta
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        // Creăm scena și o afișăm
        Scene scene = new Scene(scrollPane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
