package ba.bitcamp.edibimamovic.labwork;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class KlixReader {
	public static void main(String[] args) throws ParserConfigurationException,
			MalformedURLException, SAXException, IOException {

		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document xmldoc = docReader.parse(new URL(
				"http://www.klix.ba/rss/svevijesti").openStream());
		NodeList xmlTitle = xmldoc.getElementsByTagName("title");
		NodeList xmlClanak = xmldoc.getElementsByTagName("clanak");
		HashMap<String, String> hm = new HashMap<String, String>();

		for (int i = 0, j = 2; i < xmlTitle.getLength()
				&& j < xmlClanak.getLength(); i++, j++) {
			String title = xmlTitle.item(j).getTextContent();
			String clanak = xmlClanak.item(i).getTextContent();

			hm.put(title, clanak);

		}
		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();
		String first = it.next();
		System.out.println(first);
		System.out.println(hm.get(first));

	}

}
