package kodlama.io.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.Devs.business.abstracts.PrLangService;
import kodlama.io.kodlama.io.Devs.entities.concretes.PrLang;

@RestController
@RequestMapping("/api/prLangs")
public class PrLangsController {
	PrLangService prLangService;
	@Autowired
	public PrLangsController(PrLangService prLangService) {
		this.prLangService = prLangService;
	}
	
	@GetMapping("/add")
	public void add(PrLang prLang) throws Exception{
		prLangService.add(prLang);
	}
	@GetMapping("/delete")
	public void delete(int id){
		prLangService.delete(id);
	}
	@GetMapping("/update")
	public void update(PrLang prLang) throws Exception{
		prLangService.add(prLang);
	}
	@GetMapping("/getall")
	public List<PrLang> getAll(){
		return prLangService.getAll();
	}
	@GetMapping("/getbyid")
	public PrLang getById(int id){
		return prLangService.getById(id);
	}
}
