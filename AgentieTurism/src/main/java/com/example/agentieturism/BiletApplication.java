package com.example.agentieturism;

public class BiletApplication {

    public static void BiletApplication(String[] args) {
        String content = "Zborul dumneavoastra este la ora:";
        String numeFisier = "bilet.pdf";

        BiletGenerator.generateBilet(content, numeFisier);
    }
}
