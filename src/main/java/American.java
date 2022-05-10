public class American extends Human {
	
	public American() {
		super();
		language = "英語";
	}
	
	public American(String name, String language) {
		super(name, language);
		
	}
	public String returnBirthPlaceInfo() {
		return "出身地：アメリカ。アメリカの公用語は「英語」です。";
	}
	
}
