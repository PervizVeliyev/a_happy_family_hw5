public class Main {

    public static void main(String[] args) {

        Pet dog = new Pet("dog","Danny",6,55,new String[]{"eat","run","bite"});
        Human mother = new Human("Arzu","Ismayilova",1975);
        Human father = new Human("Senan","Ismayilov",1975);
        Human child = new Human("Elnur","Ismayilov",2000,94,dog,mother,father,null);
        Human child1 = new Human("Emil","Ismayilov",1996,92,dog,mother,father,null);
        Human child2 = new Human("Elvin","Ismayilov",1996,92,dog,mother,father,null);
        Family family = new Family(mother, father);

        family.addChild(child);
        family.addChild(child1);
        family.addChild(child2);

        System.out.println(family.deleteChild(2));
        family.deleteChild(child1);
        System.out.println(family.countFamily());

        child.setSchedule(new String[][]{{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"},{"go","run","fall","stand","go","run","fall"}});
        System.out.println(child.getSchedule());
        family.setPet(dog);
        System.out.println(family);
        System.out.println(child);
        System.out.println(dog);

    }
}
