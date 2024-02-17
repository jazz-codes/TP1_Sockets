package EX1;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketServeur {
    public static void main(String argv[]) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);
// lecture (et verfification) du n° du listening  port a partir de l'entree standard
        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }
        try {
// instantiation d'un nouveau socket serveur qui écoute sur le port spécifié
            ServerSocket serverSocket = new ServerSocket(port);
// création dune nouvelle socket a la reception d'une requete dun nouveau client

            Socket socket = serverSocket.accept();

// creation de buffers d'entree et de sortie pour cette socket
            ObjectOutputStream output =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input =
                    new ObjectInputStream(socket.getInputStream());
// lecture du buffer dentree et affichage
            String chaine = (String) input.readObject();
            System.out.println(" recu : " + chaine);
// affichage de l'@ ip et du port du client
            System.out.println(" ca vient de : " + socket.getInetAddress() +
                    ":" + socket.getPort());
// envoyer bien reçu sur le buffer de sortie
            output.writeObject(new String("bien recu"));
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}