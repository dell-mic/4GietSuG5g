package io;

import java.io.File;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import general.*;

/**
 * Erstellt ein ServerResponse-Objekt auf Grundlage einer eingelesenen XML-Datei
 * @author Michi
 *
 */
public class SimpleXMLParser {
	final File file;

	/**
	 * Konstruktor
	 * 
	 * @param file
	 *            Zu parsende XML-Datei
	 */
	public SimpleXMLParser(File file) {
		this.file = file;
	}

	/**
	 * Liest alle relevanten Werte aus einer Kommunikationsdatei aus und
	 * speichert diese in einem ServerResponse Objekt.
	 * 
	 * @return ServerResponse Auf Grundlage der gelesenen XML-Datei
	 */
	public ServerResponse parse() {
            String nodename = null;
            Boolean freigabe = null;
            String satzstatus = null;
            int gegnerzug = -1;
            String sieger = null;
            ServerResponse result = null;
            
            try {
                    // Datei einlesen
                    Debug.log(2, "Lese Datei ein...");
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document doc = db.parse(file);
                    Node root = doc.getDocumentElement();

                    // Ueberpruefen, ob root-Node "content" vorhanden ist
                    if (root.getNodeName().equalsIgnoreCase("content")) {
                            // alle ChildNodes auslesen
                            NodeList nodes = root.getChildNodes();
                            for (int i = 0; i < nodes.getLength(); i++) {
                                    // aktuelle Node zwischenspeichern
                                    Node node = nodes.item(i);
                                    // falls die Node Text beinhaltet (entspricht einer ChildNode), dann diesen auslesen
                                    if (node.hasChildNodes()) {
                                            nodename = node.getNodeName();
                                            if (nodename.equalsIgnoreCase("freigabe")) freigabe = Boolean.parseBoolean(node.getTextContent());
                                            else if (nodename.equalsIgnoreCase("satzstatus")) satzstatus = node.getTextContent();
                                            else if (nodename.equalsIgnoreCase("gegnerzug")) gegnerzug = Integer.parseInt(node.getTextContent());
                                            else if (nodename.equalsIgnoreCase("sieger")) sieger = node.getTextContent();
                                    }
                            }
                            
                            // Rueckgabewert setzen
                            result = new ServerResponse(freigabe, satzstatus, gegnerzug, sieger);
                            Debug.log(2, String.format("XML Datei erfolgreich eingelesen (Freigabe=%b;Satzstatus=%s;Gegnerzug=%d;Sieger=%s).", freigabe, satzstatus, gegnerzug, sieger));
                    }
                    else Debug.error("Fehler beim Einlesen der XML Datei: Konnte \"content\" Root-Node nicht finden!");
            } catch (Exception e) {
                    Debug.error("XML Datei war ungueltig: " + e.getLocalizedMessage());
                    return null;
            }
            
            return result;
    }
}
