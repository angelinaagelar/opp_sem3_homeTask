package family_tree;

import family_tree.family_tree_Angelina.FamilyTree;
import family_tree.Writer.FileHandler;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main_Angelina {
    final static String filePath = "src/family_tree/Writer/tree.txt";

    public static void main(String[] args) {
        // Создание бабушек и дедушек по линии Гомера
        Human grandMotherHomer = new Human("Mona Simpson", Gender.FEMALE, LocalDate.of(1940, 7, 11));
        Human grandFatherHomer = new Human("Abraham Jay-Jebediah 'Abe' Simpson", Gender.MALE, LocalDate.of(1939, 8, 8));

        // Создание родителей
        Human homer = new Human("Homer Filipp Simpson", Gender.MALE, LocalDate.of(1962, 7, 10), grandMotherHomer, grandFatherHomer);

        // Создание бабушек и дедушек по линии Маржори
        Human grandMotherMarge = new Human("Jacqueline Gurney", Gender.FEMALE, LocalDate.of(1941, 4, 11));
        Human grandFatherMarge = new Human("Clancy Bouvier", Gender.MALE, LocalDate.of(1937, 2, 8));

        // Создание родителей
        Human marge = new Human("Marjiorie Jacqueline (Marge) Simpson", Gender.FEMALE, LocalDate.of(1964, 10, 2), grandMotherMarge, grandFatherMarge);

        // Создание детей
        Human bart = new Human("Bartholomew Jo-Jo 'Bart' Simpson", Gender.MALE, LocalDate.of(1990, 12, 15), marge, homer);
        Human lisa = new Human("Lisa Marie Simpson", Gender.FEMALE, LocalDate.of(1993, 9, 17), marge, homer);
        Human maggie = new Human("Margaret Lenny 'Maggie' Simpson", Gender.FEMALE, LocalDate.of(1999, 2, 27), marge, homer);

        // Установить супругов
        homer.setSpouse(marge);
        marge.setSpouse(homer);

        // Создание списка членов семьи
        List<Human> familyMembers = new ArrayList<>();
        familyMembers.add(homer);
        familyMembers.add(marge);
        familyMembers.add(grandMotherHomer);
        familyMembers.add(grandFatherHomer);
        familyMembers.add(grandMotherMarge);
        familyMembers.add(grandFatherMarge);
        familyMembers.add(bart);
        familyMembers.add(lisa);
        familyMembers.add(maggie);

        // Создание и вывод семейного дерева
        FamilyTree familyTree = new FamilyTree(familyMembers);
        familyTree.sortByBirthDate(); // Сортируем по дате рождения перед выводом
        String familyTreeInfo = familyTree.displayFamilyTree();

        // Сохранение и загрузка семейного дерева
        FamilyTree tree = load();
        if (tree != null) {
            tree.sortByBirthDate(); // Сортируем после загрузки
        }
        save(tree);

        // Вывод информации о семейном дереве
        System.out.println(familyTreeInfo);
    }

    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler(filePath);
        return (FamilyTree) fileHandler.read();
    }

    private static void save(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.save(familyTree);
    }
}