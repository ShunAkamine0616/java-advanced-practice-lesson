

public class Cat extends Animal{
	
	public Cat() {
		
	}
	
	public Cat(String name, int age) {
		super(name, age);
	}
	
	@Override
	public String introduceAge() {
		String msg = null;
		if(age == 0) {
			msg = "0～10代中盤";
		} else if(age == 1) {
			msg = "10代中盤";
		} else if(2 <= age && age <= 3) {
			msg = "20代";
		} else if(4 <= age && age <= 5) {
			msg = "30代";
		} else if(6 <= age && age <= 8) {
			msg = "40代";
		} else if(9 <= age && age <= 10) {
			msg = "50代";
		} else {
			msg = "60歳以上";
		}
			
		return "人間で言うと、" + msg + "です。";
	}
	
	@Override
	public String getFilePath() {
		return "c:\\work\\cat.txt";
	}
}
