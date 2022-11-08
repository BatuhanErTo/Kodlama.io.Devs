package kodlama.io.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.Devs.business.abstracts.PrLangService;
import kodlama.io.kodlama.io.Devs.business.requests.prLangs.CreatePrLangRequest;
import kodlama.io.kodlama.io.Devs.business.requests.prLangs.DeletePrLangRequest;
import kodlama.io.kodlama.io.Devs.business.requests.prLangs.UpdatePrLangRequest;
import kodlama.io.kodlama.io.Devs.business.responses.prLangs.GetAllPrLangsResponse;
import kodlama.io.kodlama.io.Devs.business.responses.prLangs.GetByIdPrLangResponse;

@RestController
@RequestMapping("/api/prLangs")
public class PrLangsController {
	PrLangService prLangService;
	@Autowired
	public PrLangsController(PrLangService prLangService) {
		this.prLangService = prLangService;
	}
	
	@PostMapping("/add")
	public void add(CreatePrLangRequest prLangRequest){
		prLangService.add(prLangRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeletePrLangRequest prLangRequest) {
		prLangService.delete(prLangRequest);
	}
	
	@PutMapping("/update")
	public void update(int id, UpdatePrLangRequest prLangRequest) {
		prLangService.update(id,prLangRequest);
	}

	@GetMapping("/getall")
	public List<GetAllPrLangsResponse> getAll(){
		return prLangService.getAll();
	}
	@GetMapping("/getbyid")
	public GetByIdPrLangResponse getById(int id){
		return prLangService.getById(id);
	}
}
