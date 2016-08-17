import java.io.*;
import java.util.Scanner;
public class NewsMain {

		
		public static void main(String [] args) throws IOException
		{
			String CRED_NAME = "";
			String CRED_KEY = "";
			try
			{
				FileReader creds = new FileReader("credentials.txt");
				BufferedReader br = new BufferedReader(creds);
				CRED_NAME = br.readLine().trim();
				CRED_KEY = br.readLine().trim();
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
			
			System.out.printf("CRED NAME: %s\n",CRED_NAME);
			System.out.printf("CRED KEY: %s\n",CRED_KEY);
			
		}
}
