package org.example;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void Ejercicio1() {

        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        boolean aux = true;
        String Eleccionor = "";
        String Eleccionhum = "";
        int conthum = 0, contord = 0;

        for (int i = 0; i < 3; i++) {
            aux = true;

            while (aux) {

                System.out.println("Ronda: " + (i + 1));

                System.out.println("Elige piedra (r), papel (p), tijeras (s) ");
                String Eleccion = entrada.nextLine();

                String Eleccionf = Eleccion.toLowerCase();

                switch (Eleccionf) {
                    case "r":
                        Eleccionhum = "Piedra";
                        aux = false;
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

            int numord = random.nextInt(3);
            switch (numord) {
                case 0:
                    Eleccionor = "Piedra";
                    break;
                case 1:
                    Eleccionor = "Papel";
                    break;
                case 2:
                    Eleccionor = "Tijeras";
                    break;
                default:
            }

            System.out.println("El ordenador a elegido " + Eleccionor);

            if ((Eleccionhum.equals("Piedra") && Eleccionor.equals("Tijeras")) || (Eleccionhum.equals("Papel") && Eleccionor.equals("Piedra")) || (Eleccionhum.equals("Tijeras") && Eleccionor.equals("Papel"))) {
                System.out.println("Has ganado");
                conthum++;
            } else if ((Eleccionhum.equals("Piedra") && Eleccionor.equals("Papel")) || (Eleccionhum.equals("Papel") && Eleccionor.equals("Tijeras")) || (Eleccionhum.equals("Tijeras") && Eleccionor.equals("Piedra"))) {
                System.out.println("Has perdido");
                contord++;
            } else {
                System.out.println("EMPATE");
                i--;
            }
            System.out.println("Marcador Actual (pc-hum): "+contord+"-"+conthum);
            System.out.println("");
        }
        if (contord>conthum){
            System.out.println("Gana el ordenador");
        }
        else {
            System.out.println("Gana el usuario");
        }
    }

    public void Ejercicio2(){

        Scanner entrada = new Scanner(System.in);

        LocalDateTime hoy = LocalDateTime.now();
        int anyoact = hoy.getYear();
        int j = 0, anyon =0;
        boolean aux = true;

        while(aux){
            try {
                System.out.println("Introduce tu año de nacimiento: ");
                anyon = entrada.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Introduce el año en números ej:(1993) ");
                entrada.nextLine();
            }

        if (anyon>1900 && anyon<=anyoact) {
            for (int i = anyon; i <= anyoact; i++) {
                System.out.println(i + " - " + j + "años");
                j++;
            }
            aux=false;
        }
        else{
            System.out.println("El año de nacimiento debe ser superior a 1900 e inferior al año actual.");
        }
        }
    }
}

