package kodlama.io.kodlama.io.Devs.entities.concretes;

public class PrLang {
	private int id;
	private String name;
	public PrLang() {
		
	}
	public PrLang(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
