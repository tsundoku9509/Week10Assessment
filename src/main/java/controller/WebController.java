package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import beans.Movies;
import repository.GeekRepository;

@Controller
public class WebController {
	@Autowired
	GeekRepository repo;

	@GetMapping({ "/", "viewAll" })
	public String viewAllMovies(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewMovie(model);
		}
		
		model.addAttribute("movies", repo.findAll());
		return "results";
	}

	@GetMapping("/inputMovies")
	public String addNewMovie(Model model) {
		Movies m = new Movies();
		model.addAttribute("newMovie", m);
		return "input";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateMovie(@PathVariable("id") long id, Model model) {
		Movies m = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + m.toString());
		model.addAttribute("newMovie", m);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseMovie(Movies m, Model model) {
		repo.save(m);
		return viewAllMovies(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteMovie(@PathVariable("id") long id, Model model) {
		Movies m = repo.findById(id).orElse(null);
	    repo.delete(m);
	    return viewAllMovies(model);
	}
}