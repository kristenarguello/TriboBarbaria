public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nBÁRBARO QUE POSSUI MAIS TERRAS É...");
        GenericTree gt = new GenericTree();
        gt.readFile("exemplo.txt");
        gt.distribuicaoTerras();
        //gt.LevelOrderTraversal(gt.getRoot());
        System.out.println("\nÁRVORE GENEALÓGICA DE EXEMPLO: " + gt.maisTerras());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        GenericTree gt1 = new GenericTree();
        gt1.readFile("ArvoreUm.txt");
        gt1.distribuicaoTerras();
        //gt1.LevelOrderTraversal(gt1.getRoot());
        System.out.println("\nÁRVORE GENEALÓGICA 1: " + gt1.maisTerras());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        GenericTree gt2 = new GenericTree();
        gt2.readFile("ArvoreDois.txt");
        gt2.distribuicaoTerras();
        //gt2.LevelOrderTraversal(gt2.getRoot());
        System.out.println("\nÁRVORE GENEALÓGICA 2: " + gt2.maisTerras());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        GenericTree gt3 = new GenericTree();
        gt3.readFile("ArvoreTres.txt");
        gt3.distribuicaoTerras();
        //gt3.LevelOrderTraversal(gt3.getRoot());
        System.out.println("\nÁRVORE GENEALÓGICA 3: " + gt3.maisTerras());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        GenericTree gt4 = new GenericTree();
        gt4.readFile("ArvoreQuatro.txt");
        gt4.distribuicaoTerras();
        //gt4.LevelOrderTraversal(gt4.getRoot());
        System.out.println("\nÁRVORE GENEALÓGICA 4: " + gt4.maisTerras());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        
        GenericTree gt5 = new GenericTree();
        gt5.readFile("ArvoreCinco.txt");
        gt5.distribuicaoTerras();
        //gt5.LevelOrderTraversal(gt5.getRoot());
        System.out.println("\nÁRVORE GENEALÓGICA 5: " + gt5.maisTerras());
    }

}
