package builder;

public class SimpleObjectBuilder {

	public static void main(String[] args) {
		PersonBuilder pb = new PersonBuilder();
		
		Person abay = pb
					  .withName("abay")
					  .withAge(25)
					  .build();
		System.out.println(abay);
		
		Person moya = pb
					  .withName("moya")
					  .build();
		System.out.println(moya);
		
		Person someone = pb
						 .withAge(50)
						 .build();
		System.out.println(someone);
	}
	
}

class Person {
	String name;
	int age;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello,");
		if (this.name != null) sb.append(String.format(" I am %s.", this.name));
		if (this.age > 0) sb.append(String.format(" I am %d years old.", this.age));
		return sb.toString();
	}
}

class PersonBuilder {
	private Person person = new Person();
	
	PersonBuilder withName(String name) {
		this.person.name = name;
		return this;
	}
	
	PersonBuilder withAge(int age) {
		this.person.age = age;
		return this;
	}
	
	Person build() {
		Person personForResponse = person;
		person = new Person();
		return personForResponse;
	}
	
}