package family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> children;
    private Human mother;
    private Human father;
    private Human spouse;

    // Конструктор без родителей
    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    // Конструктор с родителями
    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(name, gender, birthDate);
        this.mother = mother;
        this.father = father;
        if (mother != null) mother.addChild(this); // Добавление ребенка к матери
        if (father != null) father.addChild(this); // Добавление ребенка к отцу
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public String toString() {
        String spouseName = (spouse != null) ? spouse.getName() : "no";
        String childrenInfo = hasChildren() ? String.valueOf(children.size()) : "no";
        return String.format("%s (%s), born on %s, mother: %s, father: %s, spouse: %s, children: %s",
                name, gender, birthDate, mother != null ? mother.getName() : "no",
                father != null ? father.getName() : "no", spouseName, childrenInfo);
    }
}
