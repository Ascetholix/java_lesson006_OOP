import Unit.*;

import java.util.*;

public class Main {
    public static ArrayList<Person> arrayListWhite = new ArrayList<>();
    public static ArrayList<Person> arrayListDark = new ArrayList<>();
    public static ArrayList<Person>arrayListAll = new ArrayList<>();
    static final int UNITS =10 ; // количичество персонажей

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        arrayListDark.addAll(getUnit(UNITS, 1));
        arrayListWhite.addAll(getUnit(UNITS, 2));

        arrayListAll.addAll(arrayListWhite);
        arrayListAll.addAll(arrayListDark);

        sortList(arrayListAll);
//        printList(arrayListAll);

        while (true){

            check(arrayListAll);
            View.view();
//            scanner.nextLine();
            for (Person person: arrayListAll) {
                if(arrayListWhite.contains(person)) person.step(arrayListWhite,arrayListDark);
                else person.step(arrayListDark,arrayListWhite);

            }
//            check(arrayListWhite);
//            check(arrayListDark);

        }

//        System.out.println("💀");
    }

    /** Метод именование персонажей */
    private static String getName() {
        String name = String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
        return name;
    }

    /** Методы создание персонажей */
    private static ArrayList getUnit(int a, int group) {

        Random rnd = new Random();
        ArrayList<Person> arrayList = new ArrayList<>();
        int sideXTeam1 = 1;  // положения по Х команды 1
        int sideXTeam2 = 10; // положения по Х команды 2
        int columns = 1;   // положения в колоне
        if (group == 0) {
            for (int i = 0; i < a; i++) {
                int per =  rnd.nextInt(6);
                switch (per) {
                    case 0:
                        Crossbowman crossbowman = new Crossbowman(getName(), columns,sideXTeam1);
                        arrayList.add(crossbowman);
                        columns++;
                        break;
                    case 1:
                        Sniper sniper = new Sniper(getName(), columns,sideXTeam1);
                        arrayList.add(sniper);
                        columns++;
                        break;
                    case 2:
                        Monk monk = new Monk(getName(), columns,sideXTeam1);
                        arrayList.add(monk);
                        columns++;
                        break;
                    case 3:
                        Mag mag = new Mag(getName(), columns,sideXTeam1);
                        arrayList.add(mag);
                        columns++;
                        break;
                    case 4:
                        Spearman spearman = new Spearman(getName(), columns,sideXTeam1);
                        arrayList.add(spearman);
                        columns++;
                        break;
                    case 5:
                        Outlaw outlaw = new Outlaw(getName(), columns,sideXTeam1);
                        arrayList.add(outlaw);
                        columns++;
                        break;
                    case 6:
                        Farmer farmer = new Farmer(getName(), columns,sideXTeam1);
                        arrayList.add(farmer);
                        columns++;
                        break;
                }
            }

        }
        if (group == 1) {
            for (int i = 0; i < a; i++) {
                int per =  rnd.nextInt(4);
                switch (per) {
                    case 0:
                        Sniper sniper = new Sniper(getName(), columns,sideXTeam1);
                        arrayList.add(sniper);
                        columns++;
                        break;
                    case 1:
                        Mag mag = new Mag(getName(), columns,sideXTeam1);
                        arrayList.add(mag);
                        columns++;
                        break;
                    case 2:
                        Outlaw outlaw = new Outlaw(getName(), columns,sideXTeam1);
                        arrayList.add(outlaw);
                        columns++;
                        break;
                    case 3:
                        Farmer farmer = new Farmer(getName(), columns,sideXTeam1);
                        arrayList.add(farmer);
                        columns++;
                        break;

                }
            }

        }
        if (group == 2) {
            for (int i = 0; i < a; i++) {
                int per = rnd.nextInt(4);
                switch (per) {
                    case 0:
                        Crossbowman crossbowman = new Crossbowman(getName(), columns,sideXTeam2);
                        arrayList.add(crossbowman);
                        columns++;
                        break;
                    case 1:
                        Monk monk = new Monk(getName(), columns,sideXTeam2);
                        arrayList.add(monk);
                        columns++;
                        break;
                    case 2:
                        Spearman spearman = new Spearman(getName(), columns,sideXTeam2);
                        arrayList.add(spearman);
                        columns++;
                        break;
                    case 3:
                        Farmer farmer = new Farmer(getName(), columns,sideXTeam2);
                        arrayList.add(farmer);
                        columns++;
                        break;
                }
            }
        }

        return arrayList;
    }

    /** Метод вывода*/
    private static void printList(ArrayList<Person> arrayList) {
        System.out.println("******************************************************************************************************");
        System.out.println("    Класс   |    Имя    | Атака | Урон | Hp | Зашита | Speed | Выстр/Маг/Дос | Координаты | Статус  ");
        System.out.println("******************************************************************************************************");


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf("%10s\t  %9s %4d\t %d-%d\t %.0f\t %4d\t %5d\t %8d\t %3s\t x:%d y:%d\t  %s\t \n",
                    arrayList.get(i).getInfo(),arrayList.get(i).getName(),arrayList.get(i).getAttack(),arrayList.get(i).getDamageMin(),
                    arrayList.get(i).getDamageMax(),arrayList.get(i).getHp(),arrayList.get(i).getDef(),arrayList.get(i).getSpeed(),
                    arrayList.get(i).getData(),"", arrayList.get(i).getPosition()[0], arrayList.get(i).getPosition()[1], arrayList.get(i).getState());
        }
        System.out.println("******************************************************************************************************");
    }

    /** Метод сортировки*/
    private static void sortList(ArrayList<Person> arrayList){
        arrayList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getSpeed()==o2.getSpeed()) return (int) (o1.getHp() - o2.getHp());
                else return o2.getSpeed() - o1.getSpeed();
            }
        });
    }
    /**Метод проверки если персонаж умер все поля 0*/
    private static void check(ArrayList<Person> arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getState().equals("Die")){
                arrayList.get(i).setAttack(0);
                arrayList.get(i).setHp(0);
                arrayList.get(i).setDef(0);
                arrayList.get(i).setDamageMax(0);
                arrayList.get(i).setDamageMin(0);
                arrayList.get(i).setSpeed(0);
                arrayList.get(i).setName("++++");
                arrayList.get(i).setData(0);
                arrayList.get(i).setEmoji("\uD83D\uDC80");

            }
        }
    }
}