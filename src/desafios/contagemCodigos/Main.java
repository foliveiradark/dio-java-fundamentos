package desafios.contagemCodigos;

import java.util.Scanner;

public  class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] codigos = scanner.nextLine().split(" ");
       String codigoBuscado = scanner.nextLine();

        int contador = 0;

        for(int i = 0; i < codigos.length; i++){
            if(codigos[i].equals(codigoBuscado)){
                contador++;
            }
        }

        System.out.println(contador);

        scanner.close();
    }
}
