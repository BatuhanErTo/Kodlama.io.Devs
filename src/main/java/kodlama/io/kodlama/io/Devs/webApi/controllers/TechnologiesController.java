package kodlama.io.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.kodlama.io.Devs.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.responses.technologies.GetAllTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	TechnologyService technologyService;
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		technologyService.add(createTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyService.delete(deleteTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(id, updateTechnologyRequest);
	}
	@GetMapping("/getall")
	public List<GetAllTechnologyResponse> getAll() {
		return technologyService.getAll();
	}
	
}
