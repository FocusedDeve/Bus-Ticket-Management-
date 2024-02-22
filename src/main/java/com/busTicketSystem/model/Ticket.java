package com.busTicketSystem.model;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;


public class Ticket {

    private int id;

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    private int ticketID;
    private int idUser;
    private String codeQR;
    private boolean utilise;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getCodeQR() {
        return codeQR;
    }

    public void setCodeQR(String codeQR) {
        this.codeQR = codeQR;
    }

    public boolean isUtilise() {
        return utilise;
    }

    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
    }

   // private boolean utilise;

    public Ticket(int id, int ticketID, String codeQR, boolean utilise) {
        this.id = id;
        this.ticketID = ticketID;
        this.idUser = idUser;
        this.codeQR = codeQR;
        this.utilise = utilise;
    }

    public void genererCodeQR() {
        String data = "TicketID"; // Remplacez cela par les données que vous souhaitez encoder dans le code QR
        String filePath = "E:\\Downloads/codeQR.png"; // Spécifiez le chemin et le nom du fichier de sortie

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
        // Mise à jour de la propriété codeQR
        this.codeQR = "E:\\Downloads/barcode.png";

    }
}
