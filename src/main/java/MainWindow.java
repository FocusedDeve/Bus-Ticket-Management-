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

        Button boutonValider = new Button("Valider");
        boutonValider.setOnAction(e -> validerInscription(textFieldNom.getText(), textFieldPrenom.getText(), fenetreInscription));

        // Disposer les éléments dans une mise en page
        VBox layoutInscription = new VBox(10);
        layoutInscription.getChildren().addAll(labelNom, textFieldNom, labelPrenom, textFieldPrenom, boutonValider);

        // Configurer la scène de la fenêtre d'inscription
        Scene sceneInscription = new Scene(layoutInscription, 250, 150);
        fenetreInscription.setScene(sceneInscription);

        // Afficher la fenêtre d'inscription
        fenetreInscription.showAndWait();
    }

    private void validerInscription(String nom, String prenom, Stage fenetreInscription) {
        // Logique pour valider l'inscription ici (par exemple, ajouter à la base de données)
        System.out.println("Utilisateur inscrit: Nom - " + nom + ", Prénom - " + prenom);

        // Fermer la fenêtre d'inscription
        fenetreInscription.close();
    }

    private void acheterTicket() {
        // Logique pour acheter un ticket
        System.out.println("Ouvrir une fenêtre d'achat de ticket ici...");
    }
}


