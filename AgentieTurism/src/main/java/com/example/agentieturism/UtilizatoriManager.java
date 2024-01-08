package com.example.agentieturism;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UtilizatoriManager {
    private static final String FILE_PATH = "utilizatori.txt";
    private static final Map<String, String> utilizatori = new HashMap<>();

    static {
        // Citirea datelor de utilizatori din fișier la inițializarea aplicației
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linie;
            while ((linie = bufferedReader.readLine()) != null) {
                String[] dateUtilizator = linie.split(",");
                utilizatori.put(dateUtilizator[0], dateUtilizator[1]); // Adaugarea numelui de utilizator și parolei în map
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean verificaCredentiale(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("utilizatori.txt"))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] informatiiUtilizator = linie.split(",");
                if (informatiiUtilizator.length == 2 &&
                        informatiiUtilizator[0].equals(username) &&
                        informatiiUtilizator[1].equals(password)) {
                    return true; // Utilizator găsit
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Gestionează eroarea într-un mod corespunzător
        }
        return false; // Utilizatorul nu a fost găsit sau eroare la citirea fișierului
    }

    public static void adaugaUtilizator(String username, String password) {
        utilizatori.put(username, password);
        salveazaUtilizatoriInFisier(); // Salvează noul utilizator în fișier
    }

    private static void salveazaUtilizatoriInFisier() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, String> entry : utilizatori.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void inregistrareUtilizator(String username, String password) {
        String utilizator = username + "," + password; // Concatenează username-ul și parola

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(utilizator); // Scrie informațiile în fișier
            writer.newLine(); // Adaugă o linie nouă pentru fiecare utilizator
        } catch (IOException e) {
            e.printStackTrace(); // Gestionează eroarea într-un mod corespunzător
        }
    }
}

