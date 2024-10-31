package org.example;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void Ejercicio1() {

        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        boolean aux = true; //Utilizamos un booleano para el while para controlar posibles errores.
        String Eleccionor = "";
        String Eleccionhum = "";
        int conthum = 0, contord = 0;

        for (int i = 0; i < 3; i++) {  //Ahora en nuestro bucle for haremos que se repita 3 veces (mejor de 3)
            aux = true; // Asignamos en cada recorrido del for el booleano aux a true para que entre en el while.

            while (aux) {

                System.out.println("Ronda: " + (i + 1)); // Para que no muestre ronda 0 le sumamos 1.

                System.out.println("Elige piedra (r), papel (p), tijeras (s) ");
                String Eleccion = entrada.nextLine();

                String Eleccionf = Eleccion.toLowerCase(); // Pasamos la eleccion leida a minuscula para evitar posibles fallos.

                switch (Eleccionf) { //Realizamos un switch para coger una variable con el valor que haya introducido el jugador, si no coincide con ninguna el default hará que se repita desde el while.
                    case "r":
                        Eleccionhum = "Piedra";
                        aux = false; // Con aux false en las posibles soluciones correctas haremos que no se repita si la elección es correcta.
                        break;
                    case "p":
                        Eleccionhum = "Papel";
                        aux = false;
                        break;
                    case "s":
                        Eleccionhum = "Tijeras";
                        aux = false;
                        break;
                    default:
                        System.out.println("Entrada no valida prueba con (r,p,s)");
                }
            }

            int numord = random.nextInt(3); // con un random haremos que la maquina elija que jugar.
            switch (numord) { // Con un switch pasamos el int random a una elección.
                case 0:
                    Eleccionor = "Piedra";
                    break;
                case 1:
                    Eleccionor = "Papel";
                    break;
                case 2:
                    Eleccionor = "Tijeras";
                    break;
                default: //Default vacio ya que el numero random siempre será 0,1 o 2.
            }

            System.out.println("El ordenador a elegido " + Eleccionor);

            //Realizamos un If con los casos donde gana el usuario, un elseif donde gana la maquina y el resto de casos son empates, else.
            if ((Eleccionhum.equals("Piedra") && Eleccionor.equals("Tijeras")) || (Eleccionhum.equals("Papel") && Eleccionor.equals("Piedra")) || (Eleccionhum.equals("Tijeras") && Eleccionor.equals("Papel"))) {
                System.out.println("Has ganado");
                conthum++;
            } else if ((Eleccionhum.equals("Piedra") && Eleccionor.equals("Papel")) || (Eleccionhum.equals("Papel") && Eleccionor.equals("Tijeras")) || (Eleccionhum.equals("Tijeras") && Eleccionor.equals("Piedra"))) {
                System.out.println("Has perdido");
                contord++;
            } else {
                System.out.println("EMPATE");
                i--; // Si son empate no queremos que la ronda cuento por lo tanto le quitamos al contador i uno.
            }
            System.out.println("Marcador Actual (pc-hum): "+contord+"-"+conthum);
            System.out.println("");
        }
        //Una vez hemos terminado mostrará por pantalla quien ha ganado, como es un mejor de 3 nunca habrá empate.
        if (contord>conthum){
            System.out.println("Gana el ordenador");
        }
        else {
            System.out.println("Gana el usuario");
        }
    }

    public void Ejercicio2(){

        Scanner entrada = new Scanner(System.in);

        LocalDateTime hoy = LocalDateTime.now(); //Asignamos la variable hoy con la fecha actual, y procedemos a sacar una variable con el año solo.
        int anyoact = hoy.getYear();
        int j = 0, anyon =0;
        boolean aux = true;

        while(aux){ // Un buvle while con booleano aux para controlar errores.
            try { //try-catch para controlar que no introduzcan letras en el año.
                System.out.println("Introduce tu año de nacimiento: ");
                anyon = entrada.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Introduce el año en números ej:(1993) ");
                entrada.nextLine();
            }

        if (anyon>1900 && anyon<=anyoact) { //Comparamos que el año no sea menor que 1900 ni superior al año actual.
            for (int i = anyon; i <= anyoact; i++) { //Si se cumple realiza un bucle que va mostrando los años desde que nacio hasta el año actual, mostrado que edad tiene/tendrá
                System.out.println(i + " - " + j + "años");
                j++;
            }
            aux=false; //Una vez salimos del bucle asignamos el booleano a falso para que no se repita.
        }
        else{
            System.out.println("El año de nacimiento debe ser superior a 1900 e inferior al año actual.");
            //Por último el caso donde no se cumple con la orquillas de fecha no hace falta asignar aux=true para que se repita, ya que solo será falso cuando siga el camino correcto.
        }
        }
    }
}

