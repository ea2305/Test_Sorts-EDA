/**
*@author Flyzx
*@version 0.1
*/
import util.analizar.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
  *@param: int: numero de matriculas a generar
  */
  private static void generarMatriculasDesordenadas(int num){
    GenerarMatriculas gm = new GenerarMatriculas();
    String[] matriculas = gm.generar(num);
    guardarMatriculas(matriculas, "Des");
    AnalizaArray aa = new AnalizaArray(matriculas);
    System.out.println(aa.calculoFuncion());
  }
  /**
  *metodo main
  *@param arreglo de datos de tipo String
  */
  public static void main(String[] args) {
    generarMatriculasDesordenadas(10);
    generarMatriculasDesordenadas(50);
    generarMatriculasDesordenadas(100);
    generarMatriculasDesordenadas(500);
  }
}
