package family_tree.family_tree_Angelina;

import family_tree.human.Human;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyMembers;

    public FamilyTree(List<Human> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public String displayFamilyTree() {
        StringBuilder sb = new StringBuilder();
        for (Human member : familyMembers) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        Collections.sort(familyMembers, new HumanComparatorByName());
    }

    public void sortByBirthDate() {
        Collections.sort(familyMembers, new HumanComparatorByBirthDate());
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(familyMembers);
    }
}
