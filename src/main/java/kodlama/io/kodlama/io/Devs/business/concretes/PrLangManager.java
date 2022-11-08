package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.PrLangService;
import kodlama.io.kodlama.io.Devs.business.requests.prLangs.CreatePrLangRequest;
import kodlama.io.kodlama.io.Devs.business.requests.prLangs.DeletePrLangRequest;
import kodlama.io.kodlama.io.Devs.business.requests.prLangs.UpdatePrLangRequest;
import kodlama.io.kodlama.io.Devs.business.responses.prLangs.GetAllPrLangsResponse;
import kodlama.io.kodlama.io.Devs.business.responses.prLangs.GetByIdPrLangResponse;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.PrLangRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.PrLang;

@Service
public class PrLangManager implements PrLangService{

	private PrLangRepository prLangRepository;
	@Autowired
	public PrLangManager(PrLangRepository prLangRepository) {
		this.prLangRepository = prLangRepository;
	}

	@Override
	public List<GetAllPrLangsResponse> getAll() {
		List<PrLang> prLangs = prLangRepository.findAll();
		List<GetAllPrLangsResponse> prLangsResponse = new ArrayList<GetAllPrLangsResponse>();
		for(PrLang prLang : prLangs) {
			GetAllPrLangsResponse responseItem = new GetAllPrLangsResponse();
			responseItem.setId(prLang.getId());
			responseItem.setName(prLang.getName());
			prLangsResponse.add(responseItem);
		}
		return prLangsResponse;
	}

	@Override
	public void add(CreatePrLangRequest createPrLangRequest) {
		PrLang prLang = new PrLang();
		prLang.setName(createPrLangRequest.getName());
		this.prLangRepository.save(prLang);
	}

	@Override
	public void delete(DeletePrLangRequest deletePrLangRequest) {
		this.prLangRepository.deleteById(deletePrLangRequest.getId());
		
	}

	@Override
	public GetByIdPrLangResponse getById(int id) {
		PrLang prLang = prLangRepository.getReferenceById(id);
		GetByIdPrLangResponse responseItem = new GetByIdPrLangResponse();
		responseItem.setId(prLang.getId());
		responseItem.setName(prLang.getName());
		return responseItem; 
	}

	@Override
	public void update(int id, UpdatePrLangRequest updatePrLangRequest) {
		List<PrLang> prLangs = prLangRepository.findAll();
		for(PrLang prLang : prLangs) {
			if (prLang.getId() == id) {
				prLang.setName(updatePrLangRequest.getName());
				prLangRepository.save(prLang);
				break;
			}
		}
		
	}
	
}
