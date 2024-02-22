import com.busTicketSystem.model.TicketManagement;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindow extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Système de Billetterie de Bus");

        // Éléments de l'interface utilisateur
        Label label = new Label("Bienvenue !");
        Button inscriptionButton = new Button("Inscription");
        Button acheterTicketButton = new Button("Acheter un Ticket");

        // Configurer les actions des boutons
        inscriptionButton.setOnAction(e -> inscriptionUtilisateur());
        acheterTicketButton.setOnAction(e -> acheterTicket());

        // Disposer les éléments dans une mise en page
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, inscriptionButton, acheterTicketButton);

        // Configurer la scène
        Scene scene = new Scene(layout, 300, 200);

        // Afficher la fenêtre
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void inscriptionUtilisateur() {
        // Créer une nouvelle fenêtre pour l'inscription
        Stage fenetreInscription = new Stage();
        fenetreInscription.initModality(Modality.APPLICATION_MODAL);
        fenetreInscription.setTitle("Inscription");

        // Éléments de la fenêtre d'inscription
        Label labelNom = new Label("Nom:");
        TextField textFieldNom = new TextField();

        Label labelPrenom = new Label("Prénom:");
        TextField textFieldPrenom = new TextField();

        Label labelEmail = new Label("Email:");
        TextField textFieldEmail = new TextField();

        Label labelPassword = new Label("Password:");
        TextField textFieldPassword = new TextField();

        Button boutonValider = new Button("Valider");
        boutonValider.setOnAction(e -> validerInscription(textFieldNom.getText(), textFieldPrenom.getText(), textFieldEmail.getText(), textFieldPassword.getText(), fenetreInscription));

        // Disposer les éléments dans une mise en page
        VBox layoutInscription = new VBox(10);
        layoutInscription.getChildren().addAll(labelNom, textFieldNom, labelPrenom, textFieldPrenom, labelEmail, textFieldEmail, labelPassword, textFieldPassword, boutonValider);

        // Configurer la scène de la fenêtre d'inscription
        Scene sceneInscription = new Scene(layoutInscription, 250, 400);
        fenetreInscription.setScene(sceneInscription);

        // Afficher la fenêtre d'inscription
        fenetreInscription.showAndWait();
    }

    private void validerInscription(String nom, String prenom, String email, String textFieldPasswordText, Stage fenetreInscription) {
        // Logique pour valider l'inscription ici (par exemple, ajouter à la base de données)
        System.out.println("Utilisateur inscrit: Nom - " + nom + ", Prénom - " + prenom +", Email - " + email );

        // Fermer la fenêtre d'inscription
        fenetreInscription.close();
    }

    private void acheterTicket() {
        // Créer une nouvelle fenêtre pour l'achat de ticket
        Stage fenetreAchatTicket = new Stage();
        fenetreAchatTicket.initModality(Modality.APPLICATION_MODAL);
        fenetreAchatTicket.setTitle("Achat de Ticket");

        // Éléments de la fenêtre d'achat de ticket
        Label labelTypeTicket = new Label("Type de Ticket:");
        TextField textFieldTypeTicket = new TextField();

        Label labelDestination = new Label("Destination:");
        TextField textFieldDestination = new TextField();

        Button boutonValiderAchat = new Button("Valider l'Achat");
        boutonValiderAchat.setOnAction(e -> validerAchatTicket(textFieldTypeTicket.getText(), textFieldDestination.getText(), fenetreAchatTicket));

        // Disposer les éléments dans une mise en page
        VBox layoutAchatTicket = new VBox(10);
        layoutAchatTicket.getChildren().addAll(labelTypeTicket, textFieldTypeTicket, labelDestination, textFieldDestination, boutonValiderAchat);

        // Configurer la scène de la fenêtre d'achat de ticket
        Scene sceneAchatTicket = new Scene(layoutAchatTicket, 250, 150);
        fenetreAchatTicket.setScene(sceneAchatTicket);

        // Afficher la fenêtre d'achat de ticket
        fenetreAchatTicket.showAndWait();
    }

    private void validerAchatTicket(String typeTicket, String destination, Stage fenetreAchatTicket) {
        // Logique pour valider l'achat de ticket ici (par exemple, générer un ticket, ajouter à la base de données)
        System.out.println("Ticket acheté: Type - " + typeTicket + ", Destination - " + destination);

        // Appeler la méthode acheterTicket pour générer un nouveau ticket avec un code QR
        TicketManagement ticketManagement = new TicketManagement();
        ticketManagement.acheterTicket(/* ici, passez l'ID de l'utilisateur approprié */);

        // Fermer la fenêtre d'achat de ticket
        fenetreAchatTicket.close();
    }
}


