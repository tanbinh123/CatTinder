package fi.taponen.cattinder.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.taponen.cattinder.domain.CatRepository;

@Controller
public class CatController {

	@Autowired
	private CatRepository crepository;
	
	@GetMapping(value = "/index")
	public String catList(Model model) {
		model.addAttribute("cats", crepository.findAll());
		return "catlist";
	}

}
