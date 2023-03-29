package controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import beans.Movies;
@Configuration

public class BeanConfiguration {
	@Bean
	public Movies film() {
		Movies film = new Movies("Star Wars Episode III: Revenge of the Sith", "George Lucas", "LucasFilm/20th Century Fox", 2005, 113000000.00 );
		return film;
		}
	
}
	
	