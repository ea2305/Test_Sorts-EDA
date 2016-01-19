/**
*@author Flyzx
*@version 0.1
*/
import util.analizar.*;
/**
*Clase Testea AnalizaArray
*/
public class TestAnalizar{
  /**
  *metodo main
  *@param arreglo de datos de tipo String
  */
  public static void main(String[] args) {

    GenerarMatriculas gm = new GenerarMatriculas();
    String[] matriculas = gm.generar(100);
    for (int i=0; i<matriculas.length; i++) {
      System.out.println(matriculas[i]);
    }
    AnalizaArray aa = new AnalizaArray(matriculas);
    System.out.println(aa.calculoFuncion());
  }
}
