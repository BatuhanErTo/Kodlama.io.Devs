package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.kodlama.io.Devs.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.responses.technologies.GetAllTechnologyResponse;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.PrLangRepository;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.PrLang;
import kodlama.io.kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
	
	private TechnologyRepository technologyRepository;
	private PrLangRepository prLangRepository;
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository,PrLangRepository prLangRepository) {
		this.technologyRepository = technologyRepository;
		this.prLangRepository = prLangRepository;
	}
	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		PrLang prLang = prLangRepository.findById(createTechnologyRequest.getPrLangId()).get();
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		technology.setPrLang(prLang);
		technologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyRepository.deleteById(deleteTechnologyRequest.getId());		
	}

	@Override
	public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
		List<Technology> technologies = technologyRepository.findAll(); 
		for(Technology techonology : technologies) {
			if (techonology.getId() == id) {
				techonology.setName(updateTechnologyRequest.getName());
				technologyRepository.save(techonology);
				break;
			}
		}
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll(); 
		List<GetAllTechnologyResponse> technologyResponses = new ArrayList<GetAllTechnologyResponse>();
		for(Technology techonology : technologies) {
			GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
			responseItem.setId(techonology.getId());
			responseItem.setName(techonology.getName());
			technologyResponses.add(responseItem);
		}
		return technologyResponses;
	}

}
