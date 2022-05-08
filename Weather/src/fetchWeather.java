
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;




public class fetchWeather {
	
	private static HttpURLConnection connection;
	
	static String userInput;
	
	
	
	
	 public static void main(String[] args){
		 
		 Scanner input = new Scanner(System.in);
			
			System.out.println("Enter a location name: ");
			

			
			userInput = input.next();
			
			
			if (userInput != "") {

				System.out.println("Fetching weather for " + userInput);
				
				//url = "https://weatherdbi.herokuapp.com/data/weather/" + userInput;
				
			//}
		 
		 
		 BufferedReader reader;
		 String line;
		 StringBuffer responseContent = new StringBuffer();
		 
		 try {
			URL url = new URL("https://weatherdbi.herokuapp.com/data/weather/" + userInput);
			 //URL url = new URL("https://weatherdbi.herokuapp.com/data/weather/hilton");
			 connection = (HttpURLConnection) url.openConnection();
			
			
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			//System.out.println(status);
			
			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
			}
			
			System.out.println(responseContent.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
				
//		 
//			HttpClient client = HttpClient.newHttpClient();
//			HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://weatherdbi.herokuapp.com/data/weather/" + userInput)).build();
//			client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//			.thenApply(HttpResponse::body)
//			.thenAccept(System.out::println)
//			.join();
//			
			
		 
	 } 
			
			
		 
	 }
	
	

}
