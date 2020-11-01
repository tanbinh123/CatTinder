package fi.taponen.cattinder.web;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fi.taponen.cattinder.domain.BreedRepository;
import fi.taponen.cattinder.domain.Cat;
import fi.taponen.cattinder.domain.CatRepository;

@Controller
public class CatController {

	@Autowired
	private CatRepository crepository;
	
	@Autowired
	private BreedRepository brepository;
	
	
	//Log in
	@GetMapping(value ="/login")
	public String logIn(Model model) {
		model.addAttribute("title", "Log In");
		return "login";
	}
	
	// View list
	@GetMapping(value = {"/", "/index"})
	public String catList(Model model) {
		model.addAttribute("title", "Cat List");
		model.addAttribute("cats", crepository.findAll());
		model.addAttribute("breeds", brepository.findAll());
		return "catlist";
	}
	
	//Add
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/add")
	public String addCat(Model model) {
		model.addAttribute("title", "Add a New Cat");
		model.addAttribute("cat", new Cat());
		model.addAttribute("breeds", brepository.findAll());
		return "addcat";
	}
	
	//Edit
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/edit/{id}")
	public String editCat(@PathVariable("id") Long catId, Model model) {
		model.addAttribute("title", "Edit Cat");
	//	model.addAttribute("cat", crepository.findById(catId));
		crepository.findById(catId).ifPresent(o -> model.addAttribute("cat", o)); // unwrap the object to allow image preview in Edit
		model.addAttribute("breeds", brepository.findAll());
		return "editcat";
	}
	
	//Save new or changed
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/save")
	public String save(@Valid Cat cat, BindingResult bindingResult,
			@RequestParam("image") MultipartFile file,
			 Model model) throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("breeds", brepository.findAll());
			return "editcat";
		}
		//save image upload path to Cat.imageUrl
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		cat.setImageUrl(fileName); 
		Cat savedCat = crepository.save(cat); 
		String uploadDir = "./cat-images/" + savedCat.getId();
		
		//get the path for uploading the file
		//String uploadDir = "src/main/resources/static/images/cat-images/" + savedCat.getId();
		Path uploadPath = Paths.get(uploadDir);
		if (!Files.exists(uploadPath)) { 
			Files.createDirectories(uploadPath);
		}
		
		// Save image file
		try (InputStream inputStream = file.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			System.out.println(filePath.toFile().getAbsolutePath()); // check uploading absolute path
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Could not save uploaded file: " + fileName, ioe);
		}	
		
		return "redirect:index";
	}
	
	//Delete
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long catId, Model model) {
		crepository.deleteById(catId);
		return "redirect:../index";
	}
	//Get all with REST
	@GetMapping("/cats")
	public @ResponseBody List<Cat> catListRest() {
		return (List<Cat>) crepository.findAll();
	}
}
