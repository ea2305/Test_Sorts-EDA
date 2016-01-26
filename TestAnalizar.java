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
    AnalizaFile myReader = new AnalizaFile();
    QuickSort myQuick = new QuickSort();

    GenerarMatriculas gm = new GenerarMatriculas();
    String[] matriculas = gm.generar(num);
    Integer [] data_SortInteger = myReader.parseInformation(matriculas);

    guardarMatriculas(data_SortInteger, "Des");
    AnalizaArray aDes = new AnalizaArray(data_SortInteger);
    System.out.println(aDes.calculoFuncion());//desordenado
    System.out.println("desordenado con n: "+num);
    testOrdenamiento(data_SortInteger);
    System.out.println("-----------------------------------");

    myQuick.sort(data_SortInteger);
    guardarMatriculas(data_SortInteger, "OA");
    AnalizaArray aOA = new AnalizaArray(data_SortInteger);
    System.out.println(aOA.calculoFuncion());//ordenado Ascendente
    System.out.println("ordenado Ascendente con n: "+num);
    testOrdenamiento(data_SortInteger);
    System.out.println("-----------------------------------");

    int longitud = data_SortInteger.length;
    Integer[] descendente = new Integer[longitud];
    for (int i=0; i<longitud; i++) {
      descendente[i] = data_SortInteger[longitud-1-i];
    }
    guardarMatriculas(descendente, "OD");
    AnalizaArray aOD = new AnalizaArray(descendente);
    System.out.println(aOD.calculoFuncion());//ordenado descendente
    System.out.println("ordenado descendente con n: "+num);
    testOrdenamiento(descendente);
    System.out.println("-----------------------------------");
  }
  /**
  *@param arreglo con datos
  *@return arrglo con datos
  */
  private static Integer[] copyArray(Integer[] data_SortInteger){
    int longitud = data_SortInteger.length;
    Integer[] nuevo = new Integer[longitud];
    for (int i=0; i<longitud; i++) {
      nuevo[i] = data_SortInteger[longitud-1-i];
    }
    return nuevo;
  }
  /**
  *@param arreglo de datos de tipo Integer
  */
  private static void testOrdenamiento(Integer[] data_SortInteger){
    Integer[] nuevo;

    nuevo = copyArray(data_SortInteger);
    HeapSort myHeap = new HeapSort();
    myHeap.heapSort(nuevo);
    System.out.println("complejidad HeapSort: " + myHeap.getIndex());

    nuevo = copyArray(data_SortInteger);
    Insercion insercion = new Insercion();
    insercion.ordenarInsercion(nuevo);
    System.out.println("complejidad Insercion: " + insercion.getCount());

    nuevo = copyArray(data_SortInteger);
    MergeSort myMerge = new MergeSort();
    myMerge.mergeSort(nuevo);
    System.out.println("complejidad MergeSort: " + myMerge.getIndex());

    nuevo = copyArray(data_SortInteger);
    Seleccion seleccion=new Seleccion();
    Integer[] data = seleccion.seleccion(nuevo);
    System.out.println("complejidad Seleccion: " + seleccion.getIndex());

    nuevo = copyArray(data_SortInteger);
    QuickSort myQuick = new QuickSort();
    myQuick.sort(nuevo);
    System.out.println("complejidad QuickSort: " + myQuick.getIndex());
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
    generarMatriculas(1000);
    generarMatriculas(5000);
  }
}
