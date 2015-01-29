package ba.bitcamp.ba.edibimamovic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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

public class XpathXML {

	public static void main(String[] args) throws XPathExpressionException {
		File xmlFile = new File("/Users/edibimamovic/Desktop/Plakar.xml");

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document xmlDocument = db.parse(xmlFile);
			XPathFactory xpf = XPathFactory.newInstance();
			XPath xpath = xpf.newXPath();

			String productCountString = xpath.evaluate(
					"count(/products/product)", xmlDocument);
			System.out.printf("Broj proizvoda : %s\n", productCountString);
			//
			// String firstCountString = xpath.evaluate("", xmlDocument);
			// System.out.printf("Url prvog proizvoda : %s\n",
			// firstCountString);

			Scanner s = new Scanner(System.in);
			while (true) {
				System.out.println("Unesite XPath");
				String xPathExspression = s.nextLine();
				if (xPathExspression.isEmpty()) {
					break;
				}

				// String result = xpath.evaluate(xPathExspression,
				// xmlDocument);
				// System.out.printf("Reultat je: %s\n", result);

				NodeList result = (NodeList) xpath.evaluate(xPathExspression,
						xmlDocument, XPathConstants.NODESET);
				for (int i = 0; i < result.getLength(); i++) {
					Node n = result.item(i);
					Element el = (Element) n;

					System.out.println(el.getAttribute("ïd"));
				}

			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
