package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.responses.technologies.GetAllTechnologyResponse;

public interface TechnologyService {
	void add(CreateTechnologyRequest createTechnologyRequest);
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	void update(int id, UpdateTechnologyRequest updateTechnologyRequest);
	List<GetAllTechnologyResponse> getAll();
}
