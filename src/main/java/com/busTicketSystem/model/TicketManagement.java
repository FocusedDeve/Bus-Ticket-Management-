package com.busTicketSystem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TicketManagement
{
    private List<Ticket> tickets = new ArrayList<>();

    public void acheterTicket(int idUtilisateur) {
        String codeQR = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(tickets.size() + 1, idUtilisateur, codeQR, false);
        tickets.add(ticket);
        System.out.println("Ticket acheté avec succès. Code QR: " + codeQR);
    }

   /* public void genererCodeQR() {
        String data = "VotreDonneeAEncoder"; // Remplacez cela par les données que vous souhaitez encoder dans le code QR
        String filePath = "chemin/vers/le/fichier/codeQR.png"; // Spécifiez le chemin et le nom du fichier de sortie

        int size = 300; // Taille du code QR

        // Configurer les paramètres du code QR
        Map<EncodeHintType, Object> hintMap = new EnumMap<>(EncodeHintType.class);
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        // Créer le code QR
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, size, size, hintMap);
            BufferedImage bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

            // Remplir l'image avec les données du code QR
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
                }
            }

            // Sauvegarder l'image dans un fichier
            File qrCodeFile = new File(filePath);
            ImageIO.write(bufferedImage, "png", qrCodeFile);
            System.out.println("Code QR généré avec succès à l'emplacement : " + filePath);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }*/
}
