package util;

import java.io.*;
/**
* Clase para la creacion de string con los datos de un archivo
* Obteniendolos con la clase "getLines" y almacenada en el string:
* BufferString, para su posterior uso.
* Creadores::
* @author Elihu Alejandro Cruz Albores
* @author Luis Fernando Herrera Pimentel
* @author Carlos Maximiliano Ortiz Escobar
* @version 1.6
*/

public class AnalizaFile{
	
	String NAME_FILE;//Atributo almacenador de nombre de archivo
	int Number_lines;//Obtine el numero de lineas del archivo,
					 // una vez llamada la funcion getLines.
						 
	String Buffer;//Buffer de la lectura de el archivo Memoria Volatil :c
	
	String BufferString;// Cadena que contiene los datos del archivo, 
							 // en un String separado por saltos de linea '\n'

	File Archivo;//Variable para la apertura del archivo
	FileReader Frd;
	private boolean fileRead;//Indica estatdo de lectura	

	public AnalizaFile(){//Constructor por defecto
	
		this.NAME_FILE = "";
		this.Number_lines = -7;
		this.Buffer = "";
		this.BufferString = ""; 
		this.Archivo = null;
		this.Frd = null;
		this.fileRead = false;
	}

	public AnalizaFile(String NAME_STR){//Contructor que recibe el nombre del archivo
		
		this.Number_lines = -7;
		this.Buffer = "";
		this.BufferString = ""; 
		this.Archivo = null;
		this.Frd = null;
		this.NAME_FILE = NAME_STR;
		this.fileRead = false;
	}
	
	/**
	*@param Ningun valor
	*/
	public void OpenFile()throws IOException{//Apertura y cierre de archivo. Sub-funcion, brindar el numero de lineas

		this.Number_lines = 0;
		try{
			
			Archivo = new File(NAME_FILE);
			Frd = new FileReader(Archivo);
			BufferedReader Brd = new BufferedReader(Frd);
			
			while(((Buffer = Brd.readLine()) != null)){

				BufferString = BufferString + Buffer + "\n";
				this.Number_lines++;
			}	
			this.fileRead = true;//Cambiar a estado leeido.
			
		}catch(IOException fnot){//En caso de un Error "El archivo no existe" 
		
			System.out.println("Error: archivo [" + this.NAME_FILE + "] no encontrado");
			System.out.println("Inserte el nombre del archivo por medio del constructor.");
			System.out.println("Tambien puede apoyarse de setFileName para indicar un nuevo nombre.");
			
			this.Number_lines = -1;
			
		}finally{
			if(this.fileRead)//caso de cierre.
				Frd.close();//Finalizamos apertura de archivo	
		}
	}

	/**
	*@param Ningun valor
	*@return un valor entero
	*/
	public int getLines()throws IOException{//Realiza la lectura de el archivo y obtiene el numer de lineas 
						  //Separados por \n , es llamado para obtener los datos.
						  
		if(!this.fileRead && Number_lines == -7)//Evitar lectura innecesaria						  	
			OpenFile();
			
		return Number_lines ;
	}

	/**
	*@return Cadena de caracters de la primer linea
	*/
	public String getFirstLine()throws IOException{//Obtiene la primer linea de un archivo
		
		if(this.Number_lines == -7)	
			this.Number_lines = getLines();
	
		String DateToSend [] = BufferString.split("\n");

		return DateToSend[0];

	}
	
	/**
	*@param Ningun valor
	*@return Cadena de caracters de la ultima linea
	*/
	public String getLastLine()throws IOException{//Obtiene la ultima linea de un archivo

		if(this.Number_lines == -7)
			this.Number_lines = getLines();

		String DateToSend [] = BufferString.split("\n");

		return DateToSend[Number_lines-1];

	}

	/**
	*@param String Credits : Recive nombre del archivo
	*@return Cadena con los nombres de los autores
	*/
	public String creditos(String Credits)throws IOException{
		
		AnalizaFile credits = new AnalizaFile(Credits);
		int t = credits.getLines();
		if(t != -1)
			for(int i = 0 ; i < t; i++)
				System.out.println(credits.getAnyLine(i));
				
		return credits.BufferString;
	}

	/**
	*@param Cadena de caracteres que contiene el nombre del archivo
	*/
	public void setFileName(String nFile){//Contructor que recibe el nombre del archivo
		this.NAME_FILE = nFile;//Agregamos nuevo nombre.
		this.Number_lines = -7;//Reiniciamos lecutra.
		this.fileRead = false;
		this.BufferString = "";
	}
	
	/**
	* @param Dato entero indicando posicion
	* @return String con datos 
	*/
	public String getAnyLine(int N)throws IOException{//Obtiene la primer linea de un archivo

		if(this.Number_lines == -7)
			this.Number_lines = getLines();
	
		String BUfferAsunder [] = BufferString.split("\n");

		return BUfferAsunder[N];
        
	}
    
    public String getAllFile() throws IOException{
        if(this.Number_lines == -7)
            this.Number_lines = getLines();
            
        return BufferString;
    }

	public void writeFile(String outFile,String put){
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		try
		{
			fichero = new FileWriter(outFile);
			pw = new PrintWriter(fichero);
			
				pw.println(put);
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			// Nuevamente aprovechamos el finally para 
			// asegurarnos que se cierra el fichero.
			if (null != fichero)
				fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
    
    public int getNumberLines(){
        return Number_lines;
    }
}

