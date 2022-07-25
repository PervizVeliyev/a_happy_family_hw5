public class Main {

    public static void main(String[] args) {

        Pet dog = new Pet("dog","Danny",6,55,new String[]{"eat","run","bite"});
        Human mother = new Human("Arzu","Ismayilova",1975);
        Human father = new Human("Senan","Ismayilov",1975);
        Human child = new Human("Elnur","Ismayilov",2000,94,dog,mother,father,new String[7][7]);
        Family family = new Family(mother, father);
        family.addChild(child);
        family.setPet(dog);
        System.out.println(family);

        System.out.println(child);
        System.out.println(dog);

    }
}
