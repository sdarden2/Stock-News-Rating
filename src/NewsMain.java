import java.io.*;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;

import java.util.Scanner;
import java.util.*;
public class NewsMain {

		
	
		public static void main(String [] args)
		{
			String API_NAME = "";
			String API_KEY = "";
			try
			{
				FileReader creds = new FileReader("credentials.txt");
				BufferedReader br = new BufferedReader(creds);
				API_NAME = br.readLine().trim();
				API_KEY = br.readLine().trim();
			}			
			catch (FileNotFoundException e1)
			{
				ErrorHandle.handle("credentials file not found",e1,ErrorType.FATAL);
			}
			catch(IOException e2)
			{
				ErrorHandle.handle("could not open BufferedReader or could not read file", e2, ErrorType.FATAL);
			}
			catch (NullPointerException e3)
			{
				ErrorHandle.handle("could not read lines from file (file should have 2 lines)",e3,ErrorType.FATAL);
			}
	
			
			AlchemyLanguage service = new AlchemyLanguage();
			service.setApiKey(API_KEY);
			/*
			Map<String,Object> params = new HashMap<String,Object>();
			params.put(AlchemyLanguage.URL, "https://en.wikipedia.org/wiki/Apple_Inc.");
			
			DocumentSentiment sentiment = service.getSentiment(params).execute();
			Entities entities = service.getEntities(params).execute();
			TypedRelations relations = service.getTypedRelations(params).execute();
			
			System.out.printf("Sentiment\n\n%s\n",sentiment);
			System.out.printf("Entities\n\n%s\n",entities);
			System.out.printf("Typed Relations\n\n%s\n",relations);
			*/
		}
}
