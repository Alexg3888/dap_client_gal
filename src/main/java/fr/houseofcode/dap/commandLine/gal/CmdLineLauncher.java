package fr.houseofcode.dap.commandLine.gal;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
         *
         * @author Alex
         *
         */
public class CmdLineLauncher {

    /**
     * Logger.
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     *
     * @param args input parameters.
     * @throws IOException.!
     * @throws GeneralSecurityException.
     */
    public static void main(final String[] args) throws IOException, GeneralSecurityException {

        LOG.debug("Début du main avec comme arguments : " + args);

        String userKeySaisieNom = args[1];
        ServerUtils serversUtils = new ServerUtils();

        //"type" "Variable ou on met l'objet" = "Machine qui crée l'objet" "type de l'objet (le constructeur)
        //                                            =                  "instance de la classe"

        String messageErreur = "Erreur, entrer 1,2,3 ou 9";

        if (args.length == 0) {
            System.out.println(messageErreur);
        } else {

            String nbEmails = serversUtils.getNbUnreadEmails(userKeySaisieNom);
            String nextEvent2 = serversUtils.getNextEvents(userKeySaisieNom);
            String allLabels2 = serversUtils.getLabels(userKeySaisieNom);

            int i = Integer.parseInt(args[0]);

            switch (i) {

            case 1:
                System.out.println(allLabels2);
                break;

            case 2:
                System.out.println("Vous avez : " + nbEmails + " emails non lus");
                break;

            case 3:

                System.out.println(nextEvent2);
                break;

            case 9:
                System.out.println("Vous avez : " + nbEmails + " emails non lus");
                System.out.println(allLabels2);
                System.out.println(nextEvent2);
                break;

            default:
                System.out.println(messageErreur);
            }

        }
    }
}
