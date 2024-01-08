package com.example.agentieturism;

import javafx.scene.control.Button;

import java.util.*;

public class DestinatiiDictionary {
    private List<String> orase;

    public DestinatiiDictionary() {
        orase = new ArrayList<>();
        orase.add("Arad");
        orase.add("Bacau");
        orase.add("Baia Mare");
        orase.add("Bucuresti_Otp");
        orase.add("Bucuresti_BBU");
        orase.add("Brasov");
        orase.add("Cluj-Napoca");
        orase.add("Constanta");
        orase.add("Craiova");
        orase.add("Iasi");
        orase.add("Oradea");
        orase.add("Satu Mare");
        orase.add("Sibiu");
        orase.add("Suceava");
        orase.add("Targu Mures");
        orase.add("Timisoara");
        orase.add("Tulcea");
    }

    public List<String> getOrase() {
        return orase;
    }

    public Map<String, List<String>> generateZboruri() {
        Map<String, List<String>> zboruri = new HashMap<>();

        Random random = new Random();
        int numarZboruri = 6; // Numărul de zboruri generate pentru fiecare destinație


        for (String oras : orase) {
            List<String> oreZboruri = new ArrayList<>();
            for (int i = 0; i < numarZboruri; i++) {
                int ora = random.nextInt(25); // Generăm aleatoriu ore între 0 și 23
                oreZboruri.add(String.format("%02d:00", ora)); // Adăugăm ora sub forma "HH:00"
            }
            zboruri.put(oras, oreZboruri);
        }

        return zboruri;
    }
}
