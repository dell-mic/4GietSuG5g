package Testing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class My_JFrame extends JFrame {
	
	FileWriter writer;
	File file;
	JTextField path;
	JComboBox cb_freigabe, cb_satzstatus, cb_sieger, cb_gegnerzug;
	// Header Information für das XML-Dokument
	String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
	
	
	public My_JFrame(){
		super("XML-Creator");
		this.setSize(300,300);
		Container content = this.getContentPane();
		content.setLayout(new GridLayout(0,2,2,4));
		this.create_elements(content);


		
		// Programm wird beim Schließen des Fensters beendet
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
	 * Generierung eines Textdokuments im XML-Format
	 * @param freigabe Übergabeparameter für die Dropdownbox "Freigabe"
	 * @param satzstatus Übergabeparameter für die Dropdownbox "Satzstatus"
	 * @param gegnerzug Übergabeparameter für die Dropdownbox "Gegnerzug"
	 * @param sieger Übergabeparameter für die Dropdownbox "Sieger"
	 * @throws IOException
	 */
	public void generate_XML(String freigabe, String satzstatus, String gegnerzug, String sieger) throws IOException{
		
			    // erstellt das Dokument in dem vorgegebenen Pfad
				file = new File("C:\\Users\\D053384\\Desktop\\server_xml.txt");
				

				// Erstellt eine neues Dokument. Ist bereits ein Dokument vorhande, wird es gelöscht
				writer = new FileWriter(file, false);
				// Zwischenspeicherung der Eingaben
				
				//XML zusammensetzen
				writer.write("<content>"+ header + 
							"<freigabe>" + freigabe + "</freigabe>"+
							"<satzstatus>" + satzstatus + "</status>"+
							"<gegnerzug>" + gegnerzug + "</gegnerzug>"+
							"<sieger>" + sieger + "</sieger>"+ "</content>");
				
			
				writer.close();	
				System.out.println(cb_freigabe.getSelectedItem());
	}
	/**
	 * Erstellt die Elemente in dem Frame
	 * @param cont Übergabeparameter von der Content-Pane
	 */
	public void create_elements(Container cont){
		
		
		path = new JTextField();
		cont.add(path);
		// erstellt Label und das zugehörige Dropdownbox
		JLabel lb_freigabe = new JLabel("Freigabe");
		cont.add(lb_freigabe);
		//Bereich für die Dopdownbox
		String[] choose_freigabe = { "true", "false"};
		cb_freigabe = new JComboBox(choose_freigabe);
		// Startwert wird gewählt
		cb_freigabe.setSelectedIndex(0);
		cont.add(cb_freigabe);
		// Ausgewählten Datensatz wird in einen String umwandelt
		final String temp_freigabe = (String) cb_freigabe.getSelectedItem();
		
		// analog zu freigabe
		JLabel lb_satzstatus = new JLabel("Satzstatus");
		cont.add(lb_satzstatus);
		String[] choose_satzstatus = {"Satz spielen", "beendet"};
		cb_satzstatus = new JComboBox(choose_satzstatus);
		cb_satzstatus.setSelectedIndex(0);
		cont.add(cb_satzstatus);
		final String temp_satzstatus = (String) cb_satzstatus.getSelectedItem();
		
		// analog zu freigabe
		JLabel lb_gegnerzug = new JLabel("Gegnerzug");
		cont.add(lb_gegnerzug);
		String[] choose_gegnerzug = {"1", "2","3","4","5","6"};
		cb_gegnerzug = new JComboBox(choose_gegnerzug);
		cb_gegnerzug.setSelectedIndex(0);
		cont.add(cb_gegnerzug);
		final String temp_gegnerzug = (String) cb_gegnerzug.getSelectedItem();
		
		// analog zu freigabe
		JLabel lb_sieger = new JLabel("Sieger");
		cont.add(lb_sieger);
		String[] choose_sieger = {"offen", "SpielerX", "SpielerO"};
		cb_sieger = new JComboBox(choose_sieger);
		cb_sieger.setSelectedIndex(0);
		cont.add(cb_sieger);
		final String temp_sieger = (String) cb_sieger.getSelectedItem();
		
		
		JButton create = new JButton("creat XML");
		create.setSize(20, 100);
		cont.add(create);
		// Button-Click-Event wird erstellt
		create.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	// Aufruf der Methode generate_XML mit den eingabefeldern als Parameter
                try {
					generate_XML(temp_freigabe, 
								temp_satzstatus, 
								temp_gegnerzug, 
								temp_sieger);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
		
	}
	
	

		
	
}
