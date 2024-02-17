package EX3;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String adresse = "127.0.0.1";
        final int port = 5545;

        try (Socket socket = new Socket(adresse, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
            Personne personne = new Personne(21, "Yasmine");

            out.writeObject(personne);
            System.out.println("Personne envoyée au serveur.");

            int clientId = in.readInt();
            System.out.println("Identifiant du client reçu du serveur : " + clientId);

        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
