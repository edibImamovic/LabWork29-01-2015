package ba.bitcamp.ba.edibimamovic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class test {

	public static void main(String[] args) {

		Person p1 = new Person("Edib", "Imamovic", 30);
		Person p2 = new Person("Jesenko", "Gavric", 23);
		Person p3 = new Person("Adnan", "Spahic", 22);
		Person p4 = new Person("Gorjan", "Kalauzovic", 55);
		Person p5 = new Person("Benjamin", "Talic", 24);
		Person p6 = new Person("Hikmet", "Durgutovic", 22);

		p1.addChild(new Person("Jesenko", null, 22));
		p2.addChild(new Person("Jesenko", null, 22));
		p3.addChild(new Person("Jesenko", "Gavrilo", 33));
		p6.addChild(new Person("Jesenko", "Gavrilo", 33));
		LinkedList<Person> ls = new LinkedList<Person>();
		ls.add(p1);
		ls.add(p2);
		ls.add(p3);
		ls.add(p4);
		ls.add(p5);
		ls.add(p6);
		System.out.println(ls.toString());

		try {
			Person.personToXML(ls,
					new FileOutputStream("./FileXML/NewFile.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
