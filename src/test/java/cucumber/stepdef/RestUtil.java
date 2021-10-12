package cucumber.stepdef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class RestUtil {

    String appURL="http://localhost:8080/student";
    private HttpURLConnection conn;
    int responseCode=0;

    public void getRequest() {
        try {
            URL url = new URL(appURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            responseCode=conn.getResponseCode();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("Get Request output :: \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void postRequest(Map<Object,Object> testData) {
        try {
            URL url = new URL(appURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            String input = StudentJson.getTestData(testData);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            responseCode=conn.getResponseCode();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("Post request output :\n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteRequest(Map<Object,Object> testData) {
        try {
            URL url = new URL(appURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            String input = StudentJson.getTestData(testData);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            responseCode=conn.getResponseCode();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("DELETE request output :\n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void putRequest(Map<Object,Object> testData) {
        try {
            URL url = new URL(appURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            String input = StudentJson.getTestData(testData);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            responseCode=conn.getResponseCode();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("PUT request output :\n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void terminateSession(){
        conn.disconnect();
    }

}
