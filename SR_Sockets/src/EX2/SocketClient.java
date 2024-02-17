package EX2;

import java.io.*;
import java.net.*;

public class SocketClient {
    public static void main(String argv[]) {
        String host = "127.0.0.1";
        int port = 5431;

        try {
            InetAddress adr = InetAddress.getByName(host);
            Socket socket = new Socket(adr, port);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Voiture voiture = new Voiture("Mustang", "Ford ");
            output.writeObject(voiture);
            Voiture voitureModifiee = (Voiture) input.readObject();
            System.out.println("Voiture modifiée reçue du serveur : " + voitureModifiee.getType() + " " +
                    voitureModifiee.getModel() + ", carburant : " + voitureModifiee.getCarburant() + "/" +
                    voitureModifiee.getCapacite());

            input.close();
            output.close();
            socket.close();

        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
