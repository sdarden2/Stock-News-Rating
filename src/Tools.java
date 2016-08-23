import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.stream.JsonParser;


public class Tools {

	public static ArrayList<String> getUrlsFromJsonString(String jsonString) /*Don't forget to remove static*/
	{
	
		ArrayList<String> urlList = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new StringReader(jsonString));
		JsonParser parser = Json.createParser(reader);
		
		while (parser.hasNext())
		{
			JsonParser.Event event = parser.next();
			if (event == JsonParser.Event.KEY_NAME)
			{
				String key = parser.getString();
				if (key.equalsIgnoreCase("url"))
				{
					event = parser.next();
					if (event == JsonParser.Event.VALUE_STRING)
					{
						String url = parser.getString();
						urlList.add(url);
					}
					
				}
			}
		}
		return urlList;
	}
}
