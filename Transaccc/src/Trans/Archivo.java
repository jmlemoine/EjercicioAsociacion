package Trans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Archivo {

	private File fichero;
	private String contenido;
	
	public Archivo() {
			
	}
	
	public Archivo(File fichero) {
		this.fichero = fichero;
		this.contenido = "";
		leerContenido();
		
	}
	
	public void leerContenido() {
		String linea = null;
		FileReader f = null;
		BufferedReader b= null;
		
		try {
			f = new FileReader(this.fichero);
			b = new BufferedReader(f);
			
			try {
				while ((linea = b.readLine()) != null) {
					this.contenido = this.contenido + "" + linea + "\n";
				}
				
			}catch(IOException ex) {
				Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		}catch(FileNotFoundException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
	
	public void Lectura(String nombreArchivo) {
		File archivo;
		FileReader fr;
		BufferedReader br;
		
		try {
			archivo = new File(nombreArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();
			fr.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error"+e);
		}
		
	}
	
	public int getLineas() {
		if(this.contenido.equals("")) {
			return 0;
		}
		else {
			return this.contenido.split("\n").length;
		}
	}
	
	
	
}
