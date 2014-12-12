package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class carJSON {
	private String year_urlApi = "https://api.edmunds.com/api/vehicle/v2/{{make}}/{{model}}/years?fmt=json&year=2013&api_key=m6sq4cdpbs2jufau38fqew99";
	public car getCarMakeByYear( String make, String model){
		car c = new car();
		String urlStr = year_urlApi.replace("{{make}}", make);
		urlStr = urlStr.replace("{{model}}", model);
		System.out.print(urlStr);
		
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection;
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream stream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line;
			String json = "";
			while((line = buffer.readLine()) != null) {
				json += line;
			}
			System.out.println(json);
			JSONParser parser = new JSONParser();
			
			JSONObject root;
			try {
				root = (JSONObject) parser.parse(json);
				Long makes =   (Long) root.get("yearsCount");
				JSONArray years = (JSONArray) root.get("years");
				Integer count1 = Integer.parseInt(makes.toString());
				int count = (int) count1;
				System.out.println(count);
				JSONObject[] job = new JSONObject[count];
				car [] cars = new car[count];
				/*------for (int i=0;i<count;i++){
					job [i] = (JSONObject)years.get(i);
					//JSONObject styles = (JSONObject) job[i].get("styles");
					//JSONObject name = (JSONObject) styles.get(0);
					 * 
					cars[i].setYear( job[i].get("year").toString());
					//cars[i].setName(name.get("name").toString());
					System.out.println(cars[i].getName()+" "+cars[i].getYear());
				}*******/
				for (int i=0;i<count;i++){
				JSONObject jsob = (JSONObject)years.get(i);
				c.setYear( jsob.get("year").toString());
				System.out.println(" "+c.getYear());}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	public static void main(String[] args) {
		carJSON cj = new carJSON();
		cj.getCarMakeByYear("Subaru", "Outback");

	}
	
}
