package EX3;

import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        final int port = 5545;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serveur en attente de connexions...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connecté depuis : " + clientSocket.getInetAddress());

                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

                try {
                    Personne personne = (Personne) in.readObject();
                    System.out.println("Personne recue du client : " + personne.getNom() + ", " + personne.getAge());
                    out.writeInt(personne.getId());
                } catch (ClassNotFoundException e) {
                    System.err.println("Erreur : " + e);
                }

                out.close();
                in.close();
                clientSocket.close();
            }
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}

