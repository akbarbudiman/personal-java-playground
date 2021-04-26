package builder;

public class OtherObjectBuilder {

	public static void main(String[] args) {
		OtherPerson abay = OtherPerson.build().withName("abay").withAge(25);
		System.out.println(abay);
	
		OtherPerson moya = OtherPerson.build().withName("moya");
		System.out.println(moya);
		
		OtherPerson someone = OtherPerson.build().withAge(50);
		System.out.println(someone);
	}
	
}

class OtherPerson {
	String name;
	int age;

	public static OtherPerson build() {
		return new OtherPerson();
	}
	
	public OtherPerson withName(String name) {
		this.name = name;
		return this;
	}
	
	public OtherPerson withAge(int age) {
		this.age = age;
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello,");
		if (this.name != null) sb.append(String.format(" I am %s.", this.name));
		if (this.age > 0) sb.append(String.format(" I am %d years old.", this.age));
		return sb.toString();
	}
}