package com.example.agentieturism;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Verificare credențiale
        if (checkCredentials(username, password)) {
            // Autentificare reușită, schimbăm scena
            // Aici ar trebui să treci la interfața HelloApplication
            // Implementarea acestei tranziții depinde de cum ai implementat scenele și navigarea între ele
        } else {
            // Mesaj de eroare sau acțiune în cazul în care autentificarea a eșuat
        }
    }

    private boolean checkCredentials(String username, String password) {
        // Verificarea credențialelor ar trebui să fie realizată aici
        // De exemplu, poți compara cu un nume de utilizator și o parolă prestabilite
        return "utilizator".equals(username) && "parola".equals(password);
    }
}
