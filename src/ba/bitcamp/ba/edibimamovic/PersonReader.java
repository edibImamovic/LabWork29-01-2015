package ba.bitcamp.ba.edibimamovic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersonReader {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException {

		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();

		Document xmldoc = docReader.parse(new File("./FileXML/people.xml"));

		XPath xPath = XPathFactory.newInstance().newXPath();
		String expression = "/people/person";

		NodeList xmlPeople = (NodeList) xPath.compile(expression).evaluate(
				xmldoc, XPathConstants.NODESET);
		NodeList xmlChild = xmldoc.getElementsByTagName("child");

		LinkedList<Person> pupil = new LinkedList<Person>();

		for (int i = 0; i < xmlPeople.getLength(); i++) {

			Node current = xmlPeople.item(i);
			if (current instanceof Element) {
				Element currentElement = (Element) current;

				String name = currentElement.getAttribute("name");
				String lastName = currentElement.getAttribute("lastName");
				int age = Integer.parseInt(currentElement.getFirstChild()
						.getNodeValue());
				Person personTemp = new Person(name, lastName, age);

				NodeList xmlChildren = current.getChildNodes();
				for (int j = 0; j < xmlChildren.getLength(); j++) {
					Node currentChild = xmlChildren.item(j);
					if (currentChild instanceof Element) {
						Element currentChildElement = (Element) currentChild;
						String nameChild = currentChildElement
								.getAttribute("name");
						String lastNameChild = currentChildElement
								.getAttribute("lastName");
						int ageChild = Integer.parseInt(currentChildElement
								.getAttribute("age"));
						personTemp.addChild(new Person(nameChild,
								lastNameChild, ageChild));
					}
					pupil.add(personTemp);
				}
			}

		}

		Iterator<Person> irr = pupil.iterator();
		while (irr.hasNext()) {
			System.out.println(irr.next().toString());
		}

	}

}
