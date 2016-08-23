
import java.io.*;
import javax.json.*; //maven install
import javax.json.stream.*; //for JsonParser
import java.util.ArrayList;
public class Test {
/*Extract urls from json*/
	/*Want to add getUrlsFromJsonString to NewsMain so you can list all the urls retrieved by AlchemyNews*/
	
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
		public static void main (String [] args) throws IOException, FileNotFoundException
		{
			File f = new File("json.output");
			int length = (int)f.length();
			char [] c = new char[length];
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);
			bf.read(c,0,length);
			String jsonString = new String(c);
			
			ArrayList<String> urls = getUrlsFromJsonString(jsonString);
			for (String s: urls)
			{
				System.out.printf("%s\n",s);
			}
			
		}
}
