package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.PrLangService;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.PrLangRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.PrLang;

@Service
public class PrLangManager implements PrLangService{

	PrLangRepository prLangRepository;
	@Autowired
	public PrLangManager(PrLangRepository prLangRepository) {
		this.prLangRepository = prLangRepository;
	}

	@Override
	public void add(PrLang prLang) throws Exception {
		for(PrLang checker : prLangRepository.getAll()) {
			if(checker.getName().contentEquals(prLang.getName())) {
				throw new Exception("It can't be as the same name of others");
			}
		}
		if(prLang.getName().trim().isEmpty()) {
			throw new Exception("It can't be empty or null");
		}
		prLangRepository.add(prLang);
	}

	@Override
	public void delete(int id) {
		prLangRepository.delete(id);
	}

	@Override
	public void update(PrLang prLang) throws Exception {
		for(PrLang checker : prLangRepository.getAll()) {
			if(checker.getName().contentEquals(prLang.getName())) {
				throw new Exception("It can't be as the same name of others");
			}
		}
		if(prLang.getName().trim().isEmpty()) {
			throw new Exception("It can't be empty or null");
		}
		prLangRepository.update(prLang);
	}

	@Override
	public List<PrLang> getAll() {
		return prLangRepository.getAll();
	}

	@Override
	public PrLang getById(int id) {
		return prLangRepository.getById(id);
	}

}
