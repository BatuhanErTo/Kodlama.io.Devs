package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.business.requests.prLangs.CreatePrLangRequest;
import kodlama.io.kodlama.io.Devs.business.requests.prLangs.DeletePrLangRequest;
import kodlama.io.kodlama.io.Devs.business.requests.prLangs.UpdatePrLangRequest;
import kodlama.io.kodlama.io.Devs.business.responses.prLangs.GetAllPrLangsResponse;
import kodlama.io.kodlama.io.Devs.business.responses.prLangs.GetByIdPrLangResponse;

public interface PrLangService {
	List<GetAllPrLangsResponse> getAll();
	void add(CreatePrLangRequest createPrLangRequest);
	void delete(DeletePrLangRequest deletePrLangRequest);
	void update(int id, UpdatePrLangRequest updatePrLangRequest);
	GetByIdPrLangResponse getById(int id);
}
