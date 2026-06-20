public class PetMachine {

    private boolean clean = true;

    private int water = 30;

    private int shampoo = 10;

    private Pet pet;

    public void takeShower(){
        if (!this.clean){
            System.out.println("A máquina está suja! Para colocar o pet é necesário limpá-la");
            return;
        }

        if (this.pet == null){
            System.out.println("Coloque o pet na máquina para iniciar o banho");
            return;
        }

        if (pet.isClean()) {
            System.out.println("O pet já está limpo.");
            return;
        }

        if (water < 10) {
            System.out.println("Água insuficiente para dar banho.");
            return;
        }

        if (shampoo < 2) {
            System.out.println("Shampoo insuficiente para dar banho.");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);

        System.out.println("O pet " + pet.getName() + " está limpo.");
    }

    public void addWater(){
        if (water == 30){
            System.out.println("A capacidade de água na máquina está no máximo");
            return;
        }

        int space = 30 - water;
        int amount = Math.min(2, space);

        water += amount;

        System.out.println("Foram adicionados " + amount + " litro(s) de água.");
    }

    public void addShampoo(){
        if (shampoo == 10){
            System.out.println("A capacidade de Shampoo na máquina está no máximo");
            return;
        }

        int space = 10 - shampoo;
        int amount = Math.min(2, space);

        shampoo += amount;
        System.out.println("Foram adicionados " + amount + " litro(s) de Shampoo.");
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet(){
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.clean){
            System.out.println("A máquina está suja! Para colocar o pet é necesário limpá-la");
            return;
        }

        if (hasPet()){
            System.out.println("O pet " + this.pet.getName() + " está na máquina nesse momento.");
            return;
        }

        this.pet = pet;
        System.out.println("O pet " + pet.getName() + " foi colocado na máquina.");
    }

    public void removePet(){
        if(!hasPet()){
            System.out.println("Não há pet na máquina.");
            return;
        }

        clean = pet.isClean();
        System.out.println("O pet " + this.pet.getName() + " foi retirado da máquina");

        this.pet = null;
    }

    public void wash(){
        if (hasPet()) {
            System.out.println("Não é possível limpar a máquina enquanto há um pet nela.");
            return;
        }

        if (clean){
            System.out.println("A máquina já está limpa.");
            return;
        }

        if (water < 3 || shampoo < 1){
            System.out.println("Não há recursos suficientes para limpar a máquina. Verifique o abastecimento.");
            return;
        }

        this.water -= 3;
        this.shampoo -= 1;
        this.clean = true;
        System.out.println("A máquina foi limpa com sucesso!");
    }

}
