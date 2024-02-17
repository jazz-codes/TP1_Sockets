package EX2;

import java.io.*;
import java.net.*;

public class SocketServeur {
    public static void main(String argv[]) {
        int port = 5431;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Serveur en attente de connexion sur le port " + port + "...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connecté depuis : " + socket.getInetAddress() + ":" + socket.getPort());

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            Voiture voiture = (Voiture) input.readObject();
            System.out.println("Voiture reçue du client : " + voiture.getType() + " " + voiture.getModel() +
                    ", carburant : " + voiture.getCarburant() + "/" + voiture.getCapacite());

            voiture.setCarburant(50);
            output.writeObject(voiture);
            input.close();
            output.close();
            socket.close();

        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}

