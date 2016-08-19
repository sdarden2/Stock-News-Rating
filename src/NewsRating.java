/*Represents a single News rating returned from the Watson API*/
public class NewsRating {
		private float rating;
		
		public NewsRating(float rating)
		{
			this.rating = rating;
		}
	
		public float getRating(){return rating;}
		public void setRating(float rating){this.rating = rating;}

}
