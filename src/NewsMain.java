import java.io.*;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentsResult;
import com.ibm.watson.developer_cloud.service.AlchemyService;

import java.util.StringJoiner;



import java.util.*;


public class NewsMain {
	
	
		/*--Still working on this method... purpose is to make the API call to AlchemyDataNews,
		 *to parse the json, and return a list of links returned by the API call
		 */
		public static ArrayList<String> getUrls(AlchemyDataNews service, Company company,long start_time, long end_time)
		{
			/*for test start: 1470960000
			 * end: 1471534500
			 */
			ArrayList<String> urls = new ArrayList<String>();
			
			String fields = "enriched.url.url,enriched.url.title,enriched.url.enrichedTitle.docSentiment";
			
			Map<String,Object> params = new HashMap<String,Object>();   
			
			/*Get 10 articles between monday aug 15 - thurs aug 18*/
			params.put(AlchemyDataNews.START, Long.toString(start_time));
			params.put(AlchemyDataNews.END, Long.toString(end_time));
			params.put(AlchemyDataNews.COUNT, 10);
			params.put(AlchemyDataNews.RETURN,fields);
			/*put search parameters*/
			params.put("q.enriched.url.enrichedTitle.entities.entity","|text=" + company.getName() + ",type=company|");
			
			
			DocumentsResult results=  service.getNewsDocuments(params).execute();
			String jsonResults = results.toString();
			urls = Tools.getUrlsFromJsonString(jsonResults);
			return urls;
		}
	
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
	
			
			AlchemyDataNews service = new AlchemyDataNews();
			service.setApiKey(API_KEY);
			
			ArrayList<String> urls = getUrls(service,new Company("RLJ Entertainment","RLJE"),1470960000,1471534500);
			for (String s: urls)
			{
				System.out.printf("%s\n",s);
			}
			/*
			Map<String,Object> params = new HashMap<String,Object>();
			
			String company_name = "SunEdison Semiconductor";
			String fields = "enriched.url.url,enriched.url.title,enriched.url.enrichedTitle.docSentiment";
					*/		   
			/*Get 10 articles between monday aug 15 - thurs aug 18*/
			/*
			params.put(AlchemyDataNews.START, "1470960000");
			params.put(AlchemyDataNews.END, "1471534500");
			params.put(AlchemyDataNews.COUNT, 10);
			params.put(AlchemyDataNews.RETURN,fields); */
			/*put search parameters*/
			/*
			params.put("q.enriched.url.enrichedTitle.entities.entity","|text=" + company_name + ",type=company|");
			
			
			DocumentsResult results=  service.getNewsDocuments(params).execute();
			
			*/
			
			
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
