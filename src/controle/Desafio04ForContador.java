package controle;

public class Desafio04ForContador {
    public static void main(String[] args) {
        System.out.println("===|Contagem Crescente|===");
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }

        System.out.println("===|Contagem Reversa|===");
        for(int i = 10; i >= 1; i--){
            System.out.println(i);
        }

        System.out.println("===|Contagem Pares|===");
        for(int i = 2; i <= 10; i +=2){
            System.out.println(i);
        }

        System.out.println("===|Contagem Impares|===");
        for(int i = 1; i <= 10; i +=2){
            System.out.println(i);
        }
    }
}
