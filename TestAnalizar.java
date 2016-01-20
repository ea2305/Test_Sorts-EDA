/**
*@author Flyzx
*@version 0.1
*/
import util.analizar.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 import sorts.*;
  import util.AnalizaFile;
/**
*Clase Testea AnalizaArray
*/
public class TestAnalizar{
  /**
  *@param String[]: arreglo con las matriculas, String: tipo de ordenacion
  */
  private static void guardarMatriculas(String[]matriculas, String tipo){
    String ruta = "Datos/";
    String texto = "";
    int num = matriculas.length;
    for (int i=0; i<num; i++) {
      texto += matriculas[i]+"\n";
    }
    try{
      File archivo = new File(ruta+tipo+num+".txt");
      if(! archivo.exists()) {
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(texto);
        bw.close();
      }
    }catch(Exception e){}
  }
  /**
  *@param Integer[]: arreglo con las matriculas, String: tipo de ordenacion
  */
  private static void guardarMatriculas(Integer[]matriculas, String tipo){
    String ruta = "Datos/";
    String texto = "";
    int num = matriculas.length;
    for (int i=0; i<num; i++) {
      texto += matriculas[i].toString()+"\n";
    }
    try{
      File archivo = new File(ruta+tipo+num+".txt");
      if(! archivo.exists()) {
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(texto);
        bw.close();
      }
    }catch(Exception e){}
  }
  /**
  *@param: int: numero de matriculas a generar
  */
  private static void generarMatriculas(int num){
    GenerarMatriculas gm = new GenerarMatriculas();
    String[] matriculas = gm.generar(num);
    guardarMatriculas(matriculas, "Des");
    AnalizaArray aDes = new AnalizaArray(matriculas);
    System.out.println(aDes.calculoFuncion());//desordenado

    QuickSort myQuick = new QuickSort();
    AnalizaFile myReader = new AnalizaFile();
    Integer [] data_SortInteger = myReader.parseInformation(matriculas);;
    myQuick.sort(data_SortInteger);
    guardarMatriculas(data_SortInteger, "OA");
    AnalizaArray aOA = new AnalizaArray(data_SortInteger);
    System.out.println(aOA.calculoFuncion());//ordenado Ascendente
  }
  /**
  *metodo main
  *@param arreglo de datos de tipo String
  */
  public static void main(String[] args) {
    generarMatriculas(10);
    generarMatriculas(50);
    generarMatriculas(100);
    generarMatriculas(500);
  }
}
