package EX1;

import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
    public static void main(String argv[]) {
        int port = 0;
        String host = "";
        Scanner keyb = new Scanner(System.in);
// lecture a partir de l'entree standard (et verfification) du n° de l@ ip et port du serveur de destination
        System.out.print("Nom du serveur : ");
        host = keyb.next();
        System.out.print("Port du serveur : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le second paramètre n'est pas un entier.");
            System.exit(-1);
        }
// début du bloc d'instructions qui peuvent générer des erreurs qu'on peut récupérer a la suite
        try {
// // récupération du nom du domaine du serveur
            InetAddress adr = InetAddress.getByName(host);
// création dune nouvelle socket client pour le serveur spécifié
            Socket socket = new Socket(adr, port);
// creation de buffers d'entree et de sortie pour cette socket
            ObjectOutputStream output =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input =
                    new ObjectInputStream(socket.getInputStream());
//envoyer au serveur "ma premiere socket"
            output.writeObject(new String("ma première socket"));
//lire la réponse du serveur
            String chaine = (String) input.readObject();
            System.out.println(" recu du serveur : " + chaine);
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}