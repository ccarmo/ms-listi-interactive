package com.dev.clibank;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {

        System.out.println(" -----------        CLIBANK         -----------");

        Scanner leia = new Scanner(System.in);
        int escolha;

        do {
            System.out.println();
            System.out.println(" Realizar login? ");
            System.out.println(" Opção 1 - Sim");
            //System.out.println(" Opção 2 - Não");
            System.out.print(" Digite: ");
            escolha = leia.nextInt();
            if (!(escolha == 1 || escolha == 2)) {
                System.out.println(" ----------- Essa opção não existe, digite novamente. ----------- ");
            }
            System.out.println(" ----------- Bem vindo! ----------- ");

            System.out.println();


        } while (!(escolha == 1 || escolha == 2));

    }


}
