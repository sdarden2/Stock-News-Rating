import java.util.ArrayList;
public class Company {

	private String companyName;
	private String stockSymbol;
	private ArrayList<Float> newsRatings;
	
	public Company(String name, String symbol)
	{
		companyName = name;
		stockSymbol = symbol;
	}
	
	public String getName(){return companyName;}
	public String getSymbol(){return stockSymbol;}
	public void setName(String name){companyName = name;}
	public void setSymbol(String symbol){stockSymbol = symbol;}
	
	/*Rating will be between 1 and -1*/
	public void addNewsRating(Float rating)
	{
		newsRatings.add(rating);
	}
	
}

