package com.oracle.xmlns.utils;

import java.awt.print.Book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import java.util.Base64;


public class RestUtils {
    public RestUtils() {
        super();
    }


public static int doPost (String payload , String methodUrl)
{
int responseCode = -1 ;
 try {
      URL url = new URL(methodUrl);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      //Set the request method to POST as required from the API
      conn.setRequestMethod("POST");
 
      // Set the conntent-Type to "application/json" as required from the API
      conn.setRequestProperty("conntent-Type", "application/json");
      conn.setDoOutput(true);
        String authString = "KAMAL" + ":" + "Kemo1401";
                String authStringEnc = new String(Base64.getEncoder().encode(authString.getBytes()));
                conn.setRequestProperty("Authorization", "Basic " + authStringEnc);  
 
      OutputStream os = conn.getOutputStream();
      //The book we want to create in JSON format
   
      os.write(payload.getBytes("UTF-8"));
      os.flush();
      os.close();
 
       responseCode = conn.getResponseCode();
 
      System.out.println("Response Code :" + responseCode);
 
      if (responseCode == HttpURLConnection.HTTP_CREATED) {
        System.out.println("Created book successfully.");
      } else {
        System.out.println("Created book failed.");
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
 finally
 {
     
         return responseCode; 
     }
}




    public static String doGet ( String methodUrl)
    {
   
        HttpURLConnection connection = null;
           BufferedReader reader = null;
           String json = null;
           try {
             URL resetEndpoint = new URL(methodUrl);
             connection = (HttpURLConnection) resetEndpoint.openConnection();
               
               String authString = "KAMAL" + ":" + "Kemo1401";
                       String authStringEnc = new String(Base64.getEncoder().encode(authString.getBytes()));
                       connection.setRequestProperty("Authorization", "Basic " + authStringEnc);  
             // Set request method to GET as required from the API
             connection.setRequestMethod("GET");
               connection.setDoOutput(true);
        
             // Read the response
             reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             StringBuilder jsonSb = new StringBuilder();
             String line = null;
             while ((line = reader.readLine()) != null) {
               jsonSb.append(line);
             }
             json = jsonSb.toString();
               json = json.replace(",","\r\n,");
        
            
           } catch (Exception e) {
             e.printStackTrace();
           }
           finally
           {
                return json;
           }
    }


public static void main(String [] args)
{
    System.out.println(doGet("https://egqn-test.scm.em3.oraclecloud.com/productManagementCommonApi/resources/11.12.1.0/items?q=ItemId=300000001615051;OrganizationCode=UGH&onlyData=true"));
    
    
    }


}