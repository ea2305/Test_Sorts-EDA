/**
*@author Flyzx
*@version 0.1
*/
package util.analizar;
/**
*Clase Testea AnalizaArray
*/
public class GenerarMatriculas{
  //los primeros dos digitos de las matriculas
  private final String [] year = {
    "15","14","13","12","11","10","09","08"
  };
  //los dos digitos intermedios
  private final String [] wea = {
    "24","34","44","54"
  };
  //los dos ultimos digitos
  private final String [] num = {
    "00","01","02","03","04","05","06","07","08","09",
    "20","21","22","23","24","25","26","27","28","29",
    "30","31","32","33","34","35","36","37","38","39",
    "40","41","42","43","44","45","46","47","48","49"
  };
  /**
  *constructor vacio
  */
  public GenerarMatriculas(){
  }
  /**
  *@param arreglo con digitos
  *@return int: posicion aleatoria
  */
  public int getPosRandom(String[] arreglo){
    return (int)(Math.random() * (arreglo.length - 1));
  }
  /**
  *@return String: las matricula
  */
  public String getMatriculaRandom(){
    return(
      year[getPosRandom(year)]+
      wea[getPosRandom(wea)]+
      num[getPosRandom(num)]
    );
  }
  /**
  *@param int con el numero de matriculas a GenerarMatriculas
  *@return String[]: con las matriculas
  */
  public String[] generar(int n){
    String[] arrayMatriculas = new String[n];
    for (int i=0; i<n; i++) {
      arrayMatriculas[i] = getMatriculaRandom();
    }
    return arrayMatriculas;
  }
}
