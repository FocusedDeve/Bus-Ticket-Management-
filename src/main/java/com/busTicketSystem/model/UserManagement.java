package com.busTicketSystem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {

    private List<User> users = new ArrayList<>();

    public int inscrireUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inscription");
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        int id = users.size() + 1;
        User users = new User(id, nom, prenom, email, motDePasse);
        users.add(users);
        System.out.println("Utilisateur inscrit avec succès!");
        return id;
    }



}
