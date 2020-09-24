package fi.taponen.cattinder.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.taponen.cattinder.domain.BreedRepository;
import fi.taponen.cattinder.domain.Cat;
import fi.taponen.cattinder.domain.CatRepository;

@Controller
public class CatController {

	@Autowired
	private CatRepository crepository;
	
	@Autowired
	private BreedRepository brepository;
	
	// View list
	@GetMapping(value = {"/", "/index"})
	public String catList(Model model) {
		model.addAttribute("title", "Cat List");
		model.addAttribute("cats", crepository.findAll());
		model.addAttribute("breeds", brepository.findAll());
		return "catlist";
	}
	
	//Add
	@GetMapping(value = "/add")
	public String addCat(Model model) {
		model.addAttribute("title", "Add a New Cat");
		model.addAttribute("cat", new Cat());
		model.addAttribute("breeds", brepository.findAll());
		return "addcat";
	}
	
	//Edit
	@GetMapping(value = "/edit/{id}")
	public String editCat(@PathVariable("id") Long catId, Model model) {
		model.addAttribute("title", "Edit Cat");
		model.addAttribute("cat", crepository.findById(catId));
		model.addAttribute("breeds", brepository.findAll());
		return "editcat";
	}
	
	//Save new or changed
	@PostMapping(value = "/save")
	public String save(Cat cat) {
		crepository.save(cat);
		return "redirect:index";
	}
	
	//Delete
	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long catId, Model model) {
		crepository.deleteById(catId);
		return "redirect:../index";
	}

}
