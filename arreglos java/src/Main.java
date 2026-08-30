/**
 * ENUNCIADO DEL PROGRAMA:
 * Crear un sistema en Java que gestione estructuras de datos (Vectores y Matrices) 
 * utilizando Herencia. Se debe implementar:
 * 1. Clase Arreglo (Padre) con lector de datos.
 * 2. Clase Vector (Hija) con métodos para crear, llenar, mostrar, búsqueda secuencial, 
 * inserción al final y borrado por índice.
 * 3. Clase Matriz (Hija) con métodos para crear, llenar y mostrar en formato 2D.
 * 4. Un menú principal interactivo para el usuario.
 */

import java.util.Scanner; // Importamos la librería para capturar datos desde el teclado
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] vector = new int[15];

        System.out.println("======================================");
        System.out.println("     PROGRAMA DE OPERACIONES VECTOR");
        System.out.println("======================================");

        // 1. Llenar el vector
        System.out.println("\n--- INGRESO DE LOS 15 NUMEROS ---");

        for (int i = 0; i < vector.length; i++) {

            while (true) {

                System.out.print("Ingrese el numero " + (i + 1) + " (10 - 100): ");
                int numero = scanner.nextInt();

                if (numero >= 10 && numero <= 100) {
                    vector[i] = numero;
                    break;
                } else {
                    System.out.println("Numero fuera del rango.");
                    System.out.println("Debe ingresar un valor entre 10 y 100.");
                }
            }
        }

        // Mostrar vector
        System.out.println("\n--- VECTOR INGRESADO ---");

        for (int i = 0; i < vector.length; i++) {
            System.out.println("Posicion [" + i + "] = " + vector[i]);
        }

        // 2. Buscar un valor
        System.out.println("\n--- BUSQUEDA DE UN VALOR ---");

        System.out.print("Ingrese el numero que desea buscar: ");
        int buscar = scanner.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < vector.length; i++) {

            if (vector[i] == buscar) {
                System.out.println(
                    "El numero " + buscar +
                    " se encuentra en la posicion " + i
                );

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println(
                "El numero " + buscar +
                " no se encuentra en el vector."
            );
        }

        // 3. Mayor y menor
        int mayor = vector[0];
        int menor = vector[0];

        for (int i = 1; i < vector.length; i++) {

            if (vector[i] > mayor) {
                mayor = vector[i];
            }

            if (vector[i] < menor) {
                menor = vector[i];
            }
        }

        System.out.println("\n--- MAYOR Y MENOR ---");
        System.out.println("Numero mayor: " + mayor);
        System.out.println("Numero menor: " + menor);

        // 4. Buscar multiplos
        System.out.println("\n--- MULTIPLOS DE UN NUMERO ---");

        System.out.print("Ingrese el numero X: ");
        int x = scanner.nextInt();

        boolean hayMultiplos = false;

        System.out.println("Multiplos de " + x + " encontrados:");

        for (int i = 0; i < vector.length; i++) {

            if (x != 0 && vector[i] % x == 0) {

                System.out.println(
                    "Valor: " + vector[i] +
                    " - Posicion: " + i
                );

                hayMultiplos = true;
            }
        }

        if (!hayMultiplos) {
            System.out.println(
                "No hay multiplos de " + x +
                " en el vector."
            );
        }

        // 5. Suma
        int suma = 0;

        for (int i = 0; i < vector.length; i++) {
            suma += vector[i];
        }

        System.out.println("\n--- SUMA DE LOS VALORES ---");
        System.out.println("Suma total: " + suma);

        // 6. Promedio
        double promedio = (double) suma / vector.length;

        System.out.println("\n--- PROMEDIO ---");
        System.out.printf("Promedio: %.2f%n", promedio);

        // Nuevo vector para valores superiores al promedio
        int[] mayoresPromedio = new int[vector.length];
        int cantidad = 0;

        for (int i = 0; i < vector.length; i++) {

            if (vector[i] > promedio) {
                mayoresPromedio[cantidad] = vector[i];
                cantidad++;
            }
        }

        System.out.println("\n--- VALORES POR ENCIMA DEL PROMEDIO ---");

        if (cantidad == 0) {

            System.out.println(
                "No hay numeros mayores que el promedio."
            );

        } else {

            for (int i = 0; i < cantidad; i++) {
                System.out.println(mayoresPromedio[i]);
            }

            System.out.println(
                "Cantidad de numeros por encima del promedio: "
                + cantidad
            );
        }

        System.out.println("\n======================================");
        System.out.println("       PROGRAMA FINALIZADO");
        System.out.println("======================================");

        scanner.close();
    }
}