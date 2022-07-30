import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Pet pet;
    private Human[] children;

    static {
        System.out.println("A new family is being loaded");
    }

    {
        System.out.println("A new family object is created");
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human[] getChildren() {
        if(children == null) {
            children = new Human[1];
        }
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", pet=" + pet +
                ", children=" + Arrays.toString(children) +
                '}';
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) && father.equals(family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    public void addChild(Human child){
        Human[] tempArray;
        tempArray = new Human[this.getChildren().length + 1];
        for(int i = 0; i < this.getChildren().length; i++){
            tempArray[i] = this.getChildren()[i];
        }

        tempArray[this.getChildren().length] = child;
        this.setChildren(tempArray);
        child.setFamily(this);
        this.deleteChild(null);
    }

    public boolean deleteChild(int index) {
        try {
            Human[] tempArray = new Human[this.getChildren().length - 1];

            for (int i = 0, j = 0; i < this.getChildren().length; i++) {
                if (i != index) tempArray[j++] = this.getChildren()[i];
            }
            this.getChildren()[index].setFamily(null);
            this.setChildren(tempArray);

            return true;
        }
        catch (Exception e) {
            return false;
        }
    }


    public void deleteChild(Human child){
        int minus = 0;
        for(int i = 0; i < this.getChildren().length; i++){
            if(this.getChildren()[i] == null){
                minus++;
                continue;
            }
            if(this.getChildren()[i].equals(child)) {
                child.setFamily(null);
                minus++;
                this.getChildren()[i] = null;
            }
        }
        Human[] tempArray = new Human[this.getChildren().length - minus];
        for (int i = 0, j = 0; i < this.getChildren().length; i++) {
            if (this.getChildren()[i] != null) tempArray[j++] = this.getChildren()[i];
        }
        this.setChildren(tempArray);

    }

    public int countFamily() {
        return this.getChildren().length + 2;
    }
}
