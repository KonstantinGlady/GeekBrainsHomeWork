package homeWork3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        //TODO 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся). Найти и вывести список
        // уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.


        ArrayList<String> arrayList = new ArrayList<>(20);
        ArrayList<String> arrayNoDuplicate = new ArrayList<>(20);
        arrayList.add("ведро");
        arrayList.add("нос");
        arrayList.add("утро");
        arrayList.add("ведро");
        arrayList.add("лес");
        arrayList.add("вьюга");
        arrayList.add("лес");
        arrayList.add("трава");
        arrayList.add("веревка");
        arrayList.add("лес");
        arrayList.add("нос");
        arrayList.add("субмарина");
        arrayList.add("правда");
        arrayList.add("лень");
        arrayList.add("утро");
        arrayList.add("прививка");
        arrayList.add("лот");

        //   System.out.println(arrayList);

        Collections.sort(arrayList);
        System.out.println("Original array ");
        System.out.println(arrayList);
        System.out.println(" \n Show elements of array with duplicates: ");

        int count = 0;
        String name = "";

        for (int i = 0; i < arrayList.size(); i++) {

            String nameInArray = arrayList.get(i);

            if (!(arrayNoDuplicate.contains(nameInArray))) {

                arrayNoDuplicate.add(nameInArray);

                if (count >= 1 && name != nameInArray) {
                    System.out.println(name + ":  " + (count + 1) + " times in array");

                }
                count = 0;
                name = arrayList.get(i);

            } else {
                count += 1;
            }

        }
        System.out.println("\n Array without duplicates: ");
        System.out.println(arrayNoDuplicate);

        //TODO 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный
        // справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть,
        // что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все
        // телефоны.

        System.out.println("");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Smith",982234234);
        phoneBook.add("Wiles",982654234);
        phoneBook.add("Smith",988735234);
        phoneBook.add("Bond",987754234);
        phoneBook.add("King",982999934);

        phoneBook.get("Smith");
        System.out.println("");
        phoneBook.get("Bond");
    }


}
