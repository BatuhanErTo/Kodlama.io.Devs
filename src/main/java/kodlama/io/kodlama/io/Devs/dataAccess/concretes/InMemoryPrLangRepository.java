package kodlama.io.kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.PrLangRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.PrLang;
@Repository
public class InMemoryPrLangRepository implements PrLangRepository{

	List<PrLang> prLangs;
	
	public InMemoryPrLangRepository() {
		prLangs = new ArrayList<PrLang>();
		prLangs.add(new PrLang(1,"Pascal"));
	}

	@Override
	public void add(PrLang prLanguage) {
		prLangs.add(prLanguage);
	}

	@Override
	public void delete(int id) {
		prLangs.removeIf(pl->pl.getId()==id);
	}

	@Override
	public void update(PrLang prLanguage) {
		for(PrLang checker : prLangs) {
			if(checker.getId() == prLanguage.getId()) {
				checker.setName(prLanguage.getName());
			}
		}
	}

	@Override
	public List<PrLang> getAll() {
		return prLangs;
	}

	@Override
	public PrLang getById(int id) {
		return prLangs.stream().filter(pl->pl.getId()==id).findFirst().orElse(null);
	}

}
