package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.entities.concretes.PrLang;

public interface PrLangService {
	void add(PrLang prLang) throws Exception;
	void delete(int id);
	void update(PrLang prLang) throws Exception;
	List<PrLang> getAll();
	PrLang getById(int id);
}
