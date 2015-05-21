package TPV_Moviles.Librerias;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Clientes;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class json {

	public static void generajsonCliente() {// Guarda Json de empleado fijo
		String PATH = null;
	      try {
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          xstreamjson.alias("Clientes", Clientes.class);
	          
	          JFileChooser fileChooser = new JFileChooser();
	          fileChooser.setAcceptAllFileFilterUsed(false);
	          fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
	            
	          int seleccion = fileChooser.showSaveDialog(null);
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();

	                if (!PATH.endsWith(".json")) {
	                    PATH = PATH + ".json";
	                }

	                Gson gson = new Gson();
	                String json = gson.toJson(Singletons.efi);
	                FileWriter fileXml = new FileWriter(PATH);
	                fileXml.write(json.toString());
	                fileXml.close();

	                JOptionPane.showMessageDialog(null,
	                        "Archivo JSON guardado con exito", "Archivo JSON",
	                        JOptionPane.INFORMATION_MESSAGE);
	            }
	        } catch (HeadlessException | IOException e) {
	            JOptionPane.showMessageDialog(null, "Error al grabar el JSON",
	                    "Error", JOptionPane.ERROR_MESSAGE);
	        }

	}

	public static ArrayList<Clientes> abrir_jsonCliente() {// Abre Json de empleados fijos
															
		ArrayList<Clientes> clie = new ArrayList<Clientes>();
		String PATH = null;
		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("empleafijo", Clientes.class);

			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				clie = (ArrayList<Clientes>) xstream.fromXML(new FileReader(PATH));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return clie;
	}
}