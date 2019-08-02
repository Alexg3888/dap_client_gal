package fr.houseofcode.dap.commandLine.gal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Alex
 *
 */
public class ServerUtils {

    public final String USER_AGENT = "Mozilla/5.0";

    public String getLabels(String userKeySaisieNom1) throws IOException {
        // TODO Auto-generated method stub
        return callServer("/email/labels", userKeySaisieNom1);
    }

    public String getNextEvents(String userKeySaisieNom2) throws IOException {
        // TODO Auto-generated method stub
        return callServer("/calendar/nextevents", userKeySaisieNom2);
    }

    public String getNbUnreadEmails(String userKeySaisieNom3) throws IOException {
        // TODO Auto-generated method stub

        return callServer("/email/nbunread", userKeySaisieNom3);
    }

    private String callServer(String url, String userKey) throws IOException {

        URL obj = new URL("http://localhost:8080" + url + "?userKey=" + userKey);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
