import com.busTicketSystem.model.TicketManagement;
import com.busTicketSystem.model.UserManagement;

public class BusTickectSystem {


        public static void main(String[] args) {
            UserManagement userManagement = new UserManagement();
            TicketManagement ticketManagement = new TicketManagement();

            // Simuler l'inscription d'un utilisateur
            userManagement.inscrireUtilisateur();

            // Simuler l'achat d'un ticket par l'utilisateur d'ID 1
            ticketManagement.acheterTicket(1);

    }

}
