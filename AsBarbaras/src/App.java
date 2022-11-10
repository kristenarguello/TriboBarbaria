public class App {
    public static void main(String[] args) throws Exception {
        GenericTree gt = new GenericTree();
        gt.add("Thor", null);
        gt.add("Deld","Thor");
        gt.add("Jocg","Thor");
        gt.add("Alfee", "Thor");
        gt.add("Delren","Thor");
        gt.add("Dior","Jocg");
        gt.add("Gruto","Jocg");
        gt.add("Docm","Jocg");
        gt.add("Delsc","Jocg");
        gt.add("Cristi","Jocg");
        gt.add("Pacmon","Jocg");
        gt.add("Diorman","Delren");
        gt.add("Neppan","Delren");
        gt.add("Klod","Delren");
        gt.add("Mirtp","Delren");

        gt.valoresUltimoNivel();
        
    }
    //dizer qual o que tem mais terras no maior nivel (ultima geracao)
}
