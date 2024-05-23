public class main {
    public static void main(String[] args) {

        Familytree familytree = new Familytree();

        Human human1 = new Human(Влад, Ваюк, 1999, Сергей, Инна, Male);
        Human human2 = new Human(Инна, Васюк, 1978, Валера, Галя, Famale);

        Familytree familtTree = new Familytree();

        Familytree.addHuman(human1);
        Familytree.addHuman(human2);

        human2.addChildren(Влад, Васюк);
    }
}
