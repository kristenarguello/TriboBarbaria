
public class App {
    public static void main(String[] args) throws Exception {
        GenericTree gt = new GenericTree();
        gt.readFile("exemplo.txt");
        gt.distribuicaoTerras();
        System.out.println("\nBarbaro que possui mais terras na árvore genealógica 1:");
        System.out.println(gt.maisTerras());

        GenericTree gt1 = new GenericTree();
        gt1.readFile("ArvoreUm.txt");
        gt1.distribuicaoTerras();
        System.out.println("\nBarbaro que possui mais terras na árvore genealógica 2:");
        System.out.println(gt1.maisTerras());

        GenericTree gt2 = new GenericTree();
        gt2.readFile("ArvoreDois.txt");
        gt2.distribuicaoTerras();
        System.out.println("\nBarbaro que possui mais terras na árvore genealógica 3:");
        System.out.println(gt2.maisTerras());

        GenericTree gt3 = new GenericTree();
        gt3.readFile("ArvoreTres.txt");
        gt3.distribuicaoTerras();
        System.out.println("\nBarbaro que possui mais terras na árvore genealógica 4:");
        System.out.println(gt3.maisTerras());

        // GenericTree gt4 = new GenericTree();
        // gt4.readFile("exemplo.txt");
        // gt4.distribuicaoTerras();
        // System.out.println("\n\nBarbaro que possui mais terras na árvore genealógica 5:");
        // System.out.println(gt4.maisTerras());
        
    }

}
