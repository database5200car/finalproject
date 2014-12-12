package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class carJSON_description {
	private String year_urlApi = "https://api.edmunds.com/api/vehiclereviews/v2/{make}/{model}/{year}?fmt=json&api_key=m6sq4cdpbs2jufau38fqew99";
	private String get_id = "https://api.edmunds.com/api/vehicle/v2/{make}/{model}/{year}/styles?fmt=json&api_key=m6sq4cdpbs2jufau38fqew99";
	private String img_id = "https://api.edmunds.com/v1/api/vehiclephoto/service/findphotosbystyleid?styleId={id}&fmt=json&api_key=m6sq4cdpbs2jufau38fqew99";
	
	public car getCarMakeById(String id) {
		car c =new car();
		String get_img = img_id.replace("{id}", id);
		URL url;
		try {
			url = new URL(get_img);
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
			JSONArray root;
			
			
			JSONArray styles;
			try {
				root = (JSONArray) parser.parse(json);
				JSONObject zero = (JSONObject) root.get(0);
				JSONArray photos = (JSONArray) zero.get("photoSrcs");
				String img_url = photos.get(5).toString();
				img_url = "https://media.ed.edmunds-media.com"+img_url;
				c.setImg(img_url);
				System.out.println(img_url);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
		
	}
	public car getCarMakeBymmy( String make, String model, String year){
		car c = new car();
		String urlStr = year_urlApi.replace("{make}", make);
		urlStr = urlStr.replace("{model}", model);
		urlStr = urlStr.replace("{year}", year);
		
		get_id = get_id.replace("{make}", make);
		get_id = get_id.replace("{model}", model);
		get_id = get_id.replace("{year}", year);
		
		System.out.print(urlStr);
		System.out.print(get_id);
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
			URL url1 = new URL(get_id);
			HttpURLConnection connection1;
			connection1 = (HttpURLConnection) url1.openConnection();
			connection1.setRequestMethod("GET");
			InputStream stream1 = connection1.getInputStream();
			InputStreamReader reader1 = new InputStreamReader(stream1);
			BufferedReader buffer1 = new BufferedReader(reader1);
			String line1;
			String json1 = "";
			while((line1 = buffer1.readLine()) != null) {
				json1 += line1;	
			}
//			System.out.println(json);
			JSONParser parser = new JSONParser();
			System.out.println(json1);
			JSONParser parser1 = new JSONParser();
			
			JSONObject root;
			JSONObject root1;
			try {
				root = (JSONObject) parser.parse(json);
				//Long makes =   (Long) root.get("yearsCount");
//				JSONArray links = (JSONArray) root.get("links");
//				JSONObject rat = (JSONObject) links.get(0);
				Float averageRating = Float.parseFloat(root.get("averageRating").toString());
				Integer review_count = Integer.parseInt(root.get("reviewsCount").toString());
				int rc = (int) review_count;
				c.rating = averageRating;
				c.rev_count=rc;
				System.out.println(c.rating);
				/******for (int i=0;i<count;i++){
				JSONObject jsob = (JSONObject)years.get(i);
				c.setYear( jsob.get("year").toString());
				System.out.println(" "+c.getYear());}**********/
				
				root1 = (JSONObject) parser1.parse(json1);
				JSONArray styles = (JSONArray) root1.get("styles");
				JSONObject style_id = (JSONObject) styles.get(0);
//				JSONObject car_model = (JSONObject) style_id.get("model");
				Integer id_tempory = Integer.parseInt( style_id.get("id").toString());
				int id = (int) id_tempory;
				c.setStyle_id(id);
				System.out.println(c.getStyle_id());
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
		// TODO Auto-generated method stub
		carJSON_description cd = new carJSON_description();
		cd.getCarMakeBymmy("honda", "accord", "2013");
		cd.getCarMakeById("200434889");
	}

}
