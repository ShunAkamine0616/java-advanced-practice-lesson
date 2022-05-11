
public class Rabbit extends Animal {
public Rabbit() {
		
	}
	
	public Rabbit(String name, int age) {
		super(name, age);
	}
	
	@Override
	public String introduceAge() {
		String msg = null;
		if(age == 0) {
			msg = "0～10代中盤";
		} else if(age == 1) {
			msg = "10代中盤";
		} else if(2 == age) {
			msg = "20代";
		} else if(3 == age) {
			msg = "30代";
		} else if(4 == age) {
			msg = "40代";
		} else if(5 == age) {
			msg = "50代";
		} else {
			msg = "60歳以上";
		}
			
		return "人間で言うと、" + msg + "です。";
	}
	
	@Override
	public String getFilePath() {
		return "c:\\work\\rabbit.txt";
	}
}
