package beans;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@NoArgsConstructor
@Entity
@Table(name = "fav")
public class Movies {
	@Id
	@GeneratedValue
	@Column(name="TITLE")
	private String title;
	@Column(name="DIRECTOR")
	private String director;
	@Column(name="STUDIO")
	private String studio;
	@Column(name="RELEASEYEAR")
	private int releaseYear;
	@Column(name="COST")
	private double cost;
	
	public Movies(String title, String director, String studio, int year, double cost) {
		this.title = title;
		this.director = director;
		this.studio = studio;
		this.releaseYear = year;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Title: " + this.title + " || Director: " + this.director + " || Studio: " + this.studio + " || Release Year: " + this.releaseYear + " || Cost: $" + this.cost;
		}
}
