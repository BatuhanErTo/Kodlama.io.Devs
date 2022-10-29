package kodlama.io.kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.entities.concretes.PrLang;

public interface PrLangRepository {
	void add(PrLang prLanguage);
	void delete(int id);
	void update(PrLang prLanguage);
	List<PrLang> getAll();
	PrLang getById(int id);
}
