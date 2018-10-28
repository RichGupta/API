package utility;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import testData.apiData;

public class JSONDataReader extends readConfig {
	private final String customerFilePath = getTestDataResourcePath()+"/data.json";
	private apiData data;
	
	public JSONDataReader(){
		data = getParameters();
	}
	
	private apiData getParameters() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			apiData fetchedCity = gson.fromJson(bufferReader,apiData.class);
			return fetchedCity;
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}

	public final String getCity(){
		String citi = data.q;
		return citi;
	}

	public final String appID(){
		String ID = data.appid;
		return ID;
	}
}
