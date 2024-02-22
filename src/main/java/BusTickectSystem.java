import com.busTicketSystem.model.TicketManagement;
import com.busTicketSystem.model.UserManagement;

public class BusTickectSystem {


        public static void main(String[] args) {
            UserManagement userManagement = new UserManagement();
            TicketManagement ticketManagement = new TicketManagement();

            // Simuler l'inscription d'un utilisateur
            int userId = userManagement.inscrireUtilisateur();
            if (userId != -1) {
                System.out.println("Utilisateur inscrit avec succès. ID d'utilisateur : " + userId);

                // Simuler l'achat d'un ticket par l'utilisateur d'ID 1
                ticketManagement.acheterTicket(userId);
                System.out.println("Simulation d'achat de ticket effectuée.");

                // Simuler la validation du ticket
                String codeQR = "votre_code_qr_simule"; // Remplacez cela par un vrai code QR
                boolean validationResult = ticketManagement.validerTicket(codeQR);
                if (validationResult) {
                    System.out.println("Ticket validé avec succès.");
                } else {
                    System.out.println("La validation du ticket a échoué.");
                }
            } else {
                System.out.println("L'inscription de l'utilisateur a échoué. L'achat de ticket est annulé.");
            }
        }
}
