package builder;

import java.util.ArrayList;
import java.util.List;

public class CodeBuilder {
	
	GeneratedClass generatedClass;
	
	public CodeBuilder(String className) {
		this.generatedClass = new GeneratedClass(className);
		return;
	}

	public CodeBuilder addField(String name, String type) {
		this.generatedClass.attributes.add(new GeneratedAttributes(type, name));
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("public class ").append(this.generatedClass.className);
		sb.append(System.lineSeparator());
		sb.append("{");
		sb.append(System.lineSeparator());
		for (GeneratedAttributes attribute : this.generatedClass.attributes) {
			sb
			 .append("  ")
			 .append("public ")
			 .append(attribute.dataType)
			 .append(" ")
			 .append(attribute.attributeName)
			 .append(";")
			 .append(System.lineSeparator());
		}
		sb.append("}");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		CodeBuilder cb = new CodeBuilder("Foo");
//			      				.addField("name", "String")
//			      				.addField("age", "int");
		System.out.println(cb.toString());
		System.out.println("public class Foo\n{\n}");
	}
}

class GeneratedClass {
	String className;
	List<GeneratedAttributes> attributes;
	
	public GeneratedClass(String className) {
		this.className = className;
		this.attributes = new ArrayList<GeneratedAttributes>();
	}
}

class GeneratedAttributes {
	String dataType;
	String attributeName;
	
	public GeneratedAttributes(String dataType, String attributeName) {
		this.dataType = dataType;
		this.attributeName = attributeName;
	}
}