package com.example.agentieturism;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Verifică și creează fișierul utilizatori.txt dacă nu există
        File file = new File("utilizatori.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Afiseaza ecranul de autentificare
        showLoginScreen();
    }


    private void showLoginScreen() {
        Login login = new Login();
        login.setMain(this);
        primaryStage.setScene(new Scene(login.createContent(), 300, 200));
        primaryStage.setTitle("Autentificare");
        primaryStage.show();
        primaryStage.setResizable(false); // Setează fereastra să nu poată fi redimensionată
        primaryStage.setWidth(600); // Setează o lățime fixă
        primaryStage.setHeight(400); // Setează o înălțime fixă


    }

    public void showHelloApplication() {
        HelloApplication helloApp = new HelloApplication();
        helloApp.start(new Stage()); // Creează un nou Stage pentru a afișa HelloApplication

    }

}
