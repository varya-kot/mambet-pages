package api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;


public class PostSession {




    public static void main(String[] args) {

        String siteName = "https://www.google.com/";
        String email = "example@example.com";
        String password = "password";

    }




    private void sendPost(String siteName, String email, String password) {

        HttpURLConnection connection = null;

        try {

            connection = (HttpURLConnection) new URL(siteName).openConnection();


            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("http.agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36");


            String data = "email=" + email + "&password=" + password;


            connection.setDoOutput(true);
            connection.setDoInput(true);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(data);
            wr.flush();
            wr.close();

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {

                    response.append(inputLine);

                }

                System.out.println(response.toString());

            }


        }

        catch (IOException exc) {

            exc.printStackTrace();

        }


        finally {

            if (connection != null) {

                connection.disconnect();

            }
        }
    }

}
