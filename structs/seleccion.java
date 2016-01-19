public class Seleccion{
	
		public int[] seleccion(int[] arreglo){
		int minimo;
		int aux,n=0;
		for(int i = 1; i<arreglo.length-1; i++){
			minimo = i;
			for(int j=i+1; j<arreglo.length; j++){
				if (arreglo[j]<arreglo[minimo]) {
					minimo = j;
				}
				n++;
			}
			aux = arreglo[i];
			arreglo[i] = arreglo[minimo];
			arreglo[minimo] = aux;
		}
		System.out.println("iteraciones seleccion: "+n);
		return arreglo;
	}
}
