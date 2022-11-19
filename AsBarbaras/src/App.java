
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nBÁRBARO QUE POSSUI MAIS TERRAS É...");
        GenericTree gt = new GenericTree();
        gt.readFile("exemplo.txt");
        gt.distribuicaoTerras();
        System.out.println("\nÁRVORE GENEALÓGICA 1: " + gt.maisTerras());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        GenericTree gt1 = new GenericTree();
        gt1.readFile("ArvoreUm.txt");
        gt1.distribuicaoTerras();
        System.out.println("\nÁRVORE GENEALÓGICA 2: " + gt1.maisTerras());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        GenericTree gt2 = new GenericTree();
        gt2.readFile("ArvoreDois.txt");
        gt2.distribuicaoTerras();
        System.out.println("\nÁRVORE GENEALÓGICA 3: " + gt2.maisTerras());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        GenericTree gt3 = new GenericTree();
        gt3.readFile("ArvoreTres.txt");
        gt3.distribuicaoTerras();
        System.out.println("\nÁRVORE GENEALÓGICA 4: " + gt3.maisTerras());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        GenericTree gt4 = new GenericTree();
        gt4.readFile("ArvoreQuatro.txt");
        gt4.distribuicaoTerras();
        System.out.println("\nÁRVORE GENEALÓGICA 5: " + gt4.maisTerras());
        
    }

}
