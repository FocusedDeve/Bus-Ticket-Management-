package com.busTicketSystem.model;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class TicketManagement {
    private List<Ticket> tickets = new ArrayList<>();

    public void acheterTicket() {
        String codeQR = genererCodeQR(); // Appel à la méthode pour générer un nouveau code QR
        int ticketID = 1;
        Ticket ticket = new Ticket(tickets.size() + 1, ticketID, codeQR, false);
        tickets.add(ticket);
        System.out.println("Ticket acheté avec succès. Code QR: " + codeQR);

    }
    private String genererCodeQR() {
        // Logique pour générer un nouveau code QR (utilisez ZXing ou une autre bibliothèque)
        return UUID.randomUUID().toString();
    }

    public boolean validerTicket(String codeQR) {
        // Charger l'image du code QR

        try {
            System.out.println("Trying to read file: " + codeQR);
            BufferedImage bufferedImage = ImageIO.read(new File(codeQR));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading the QR code file.");
            return false;
        }

        // Configurer les paramètres du décodeur
        Map<DecodeHintType, Object> hintMap = new EnumMap<>(DecodeHintType.class);
        hintMap.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);

        // Décodeur de code QR
        QRCodeReader reader = new QRCodeReader();

        try {
            // Convertir l'image en une matrice binaire
            BufferedImage bufferedImage = null;
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));

            // Déchiffrer le code QR
            Result result = reader.decode(binaryBitmap, hintMap);

            // Récupérer les données du code QR
            String ticketData = result.getText();

            // Valider le ticket en fonction des données
            return validerTicketEnFonctionDesDonnees(ticketData);
        } catch (NotFoundException | ChecksumException | FormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean validerTicketEnFonctionDesDonnees(String ticketData) {
        // Extraire l'ID du ticket à partir des données
        int ticketID = extraireTicketID(ticketData);

        // Vérifier si le ticket avec cet ID est dans la liste des tickets valides
        return tickets.stream().anyMatch(ticket -> ticket.getTicketID() == ticketID);
    }

    private int extraireTicketID(String ticketData) {
        // Exemple de méthode pour extraire l'ID du ticket à partir des données du code QR
        String[] elements = ticketData.split(",");
        for (String element : elements) {
            String[] keyValue = element.split(":");
            if (keyValue.length == 2 && keyValue[0].equals("TicketID")) {
                try {
                    return Integer.parseInt(keyValue[1]);
                } catch (NumberFormatException e) {
                    // Gérer l'exception si la conversion en entier échoue
                    e.printStackTrace();
                }
            }
        }
        return -1; // Valeur par défaut ou signifiant une erreur
    }
}
