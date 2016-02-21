import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;


public class Json {
	private String url="https://api.jcdecaux.com/vls/v1/stations?contract=";
	public Gson gson;
	private String api_key = "224a6ef2403e0937c113ae37822e3c642e4d8c2b"; // ma clé
	private String contract_name = "Paris"; // notre ville
	private Station[] result;
	public Json() {
		String json = null;
		try{
		json = readUrl(url+contract_name+ "&apiKey=" + api_key);
		}
		catch (Exception e){
			System.err.println(e);
			System.out.println("probleme lecture url");
		}
		gson = new Gson();
		result=gson.fromJson(json, Station[].class);
		
	}
	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	
	public Station[] getResult(){
		return result;
	}
}
