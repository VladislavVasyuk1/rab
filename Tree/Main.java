import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        String filePyt = "tree.txt";
        Familytree tree = testTree();
        //Familytree tree = load(filePyt);
        System.out.println(tree);

        save(tree, filePyt);
        
}      
private static Familytree load(String filepyt) {
            Writeble writeble = new FileHandler();
            return (Familytree) writeble.read(filepyt);
        }


        private static void save(Familytree tree, String filepyt) {
            Writeble writeble = new FileHandler();
            writeble.save(tree, filepyt);
            }


        private static Familytree testTree(){

        Familytree tree = new Familytree();

        Human human1 = new Human("Влад", "Васюк",LocalDate.of(1999, 10, 4) , Gender.Male);

        Human human2 = new Human("Инна","Васюк",LocalDate.of(1978, 6, 12), Gender.Female);

        Human human3 = new Human("Сергей","Васюк",LocalDate.of(1975, 3, 30), Gender.Male);


        human2.addChild(human1);
        human1.addFather(human3);
        
        tree.addHuman(human1);
        tree.addHuman(human2);
        tree.addHuman(human3);

        return tree;
        } 
}
