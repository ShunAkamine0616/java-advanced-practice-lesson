public class Japanese extends Human {
	public Japanese() {
		super();
		language = "日本語";
	}
	
	public Japanese(String name, String language) {
		super(name, language);
	}
	
	public String returnBirthPlaceInfo() {
		return "出身地：日本。日本の公用語は「日本語」です。";
	}
}
