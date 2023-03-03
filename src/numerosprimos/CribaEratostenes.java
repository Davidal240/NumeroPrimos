package numerosprimos;    
    
public class CribaEratostenes 
{ 
/**
 * Genera todos los números primos hasta un valor máximo especificado.
 * @param max Valor máximo hasta el cual se generarán los números primos.
 * @return Un array de enteros que contiene todos los números primos generados.
 */
public static int[] generarPrimos(int max) {
    if (max < 2) {
        return new int[0];
    }
    
    // Inicializa un array de booleanos con tamaño max+1
    boolean[] esPrimo = new boolean[max + 1];
    for (int i = 2; i <= max; i++) {
        esPrimo[i] = true;
    }
    
    // Marca los múltiplos de los números primos
    for (int i = 2; i <= Math.sqrt(max); i++) {
        if (esPrimo[i]) {
            for (int j = i * i; j <= max; j += i) {
                esPrimo[j] = false;
            }
        }
    }
    
    // Cuenta el número de números primos generados
    int numPrimos = 0;
    for (int i = 2; i <= max; i++) {
        if (esPrimo[i]) {
            numPrimos++;
        }
    }
    
    // Crea un array de enteros para almacenar los números primos
    int[] primos = new int[numPrimos];
    int indice = 0;
    for (int i = 2; i <= max; i++) {
        if (esPrimo[i]) {
            primos[indice] = i;
            indice++;
        }
    }
    
    return primos;
}

}







