package com.example.agentieturism;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login {

    private Main main;
    private VBox layout; // Adăugarea inițializării aici pentru a evita NullPointerException

    public void setMain(Main main) {
        this.main = main;
    }

    public VBox createContent() {
        Label usernameLabel = new Label("Utilizator:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Parolă:");
        PasswordField passwordField = new PasswordField();

        if (layout == null) { // Verifică dacă layout-ul este deja inițializat
            layout = new VBox(10);
            layout.setPadding(new Insets(20, 20, 20, 20));
        }

        Button registerButton = new Button("Înregistrare");
        registerButton.setOnAction(event -> {


            // Creează o fereastră nouă pentru înregistrare și afișează-o
            Stage stage = new Stage();
            stage.setTitle("Înregistrare");
            VBox registerLayout = new VBox(10);
            TextField registerUsernameField = new TextField();
            PasswordField registerPasswordField = new PasswordField();
            Button submitButton = new Button("Înregistrare");

            submitButton.setOnAction(e -> {
                String newUsername = registerUsernameField.getText();
                String newPassword = registerPasswordField.getText();
                UtilizatoriManager.inregistrareUtilizator(newUsername, newPassword);
                // Implementează logica de înregistrare aici
                // Poți folosi valorile newUsername și newPassword pentru a crea un nou utilizator
                // De exemplu, UtilizatoriManager.adaugaUtilizator(newUsername, newPassword);
                // Sau poți deschide o fereastră nouă care să confirme înregistrarea
                // sau să afișeze un mesaj de succes sau eroare
            });

            registerLayout.getChildren().addAll(
                    new Label("Nume utilizator:"),
                    registerUsernameField,
                    new Label("Parolă:"),
                    registerPasswordField,
                    submitButton
            );

            Scene registerScene = new Scene(registerLayout, 300, 200);
            stage.setScene(registerScene);
            stage.show();
        });

        layout.getChildren().clear(); // Șterge orice elemente anterioare adăugate
        layout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, registerButton);

        Button loginButton = new Button("Conectare");
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Verificarea credențialelor
            if (UtilizatoriManager.verificaCredentiale(username, password)) {
                // Autentificare reușită, navigare către HelloApplication
                main.showHelloApplication();
            } else {
                // Mesaj de eroare sau acțiune în cazul în care autentificarea a eșuat
                // Aici poți adăuga o fereastră de alertă sau un mesaj în interfața de login
                System.out.println("Autentificare esuata!");
            }
        });

        layout.getChildren().add(loginButton); // Adăugare butonul de conectare

        return layout;
    }
}
