
public class App {
    public static void main(String[] args) throws Exception {
        GenericTree gt = new GenericTree();
        gt.readFile("exemplo.txt");
        gt.distribuicaoTerras();
        gt.LevelOrderTraversal(gt.getRoot());
        System.out.println(gt.maisTerras());
        

    }

}
