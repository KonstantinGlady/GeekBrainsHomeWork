package homeWork3;

import java.util.HashMap;
import java.util.Objects;

public class PhoneBook  {

   private   String name;
   private   Integer phoneNumber;
   private   HashMap<Integer, String> phBook = new HashMap<>();// cделаем ключом номер, потому что уникальный, имена же могут дублироваться



    public void get(String name) {
        for (Object o : phBook.keySet()) {
            if (phBook.get(o).equals(name)){
                System.out.println("name: "+ name + " number: "+ o);
            }

        }
    }

    public void add(String name, Integer phoneNumber) { phBook.put(phoneNumber, name); }

  /*  @Override   // написано в методичке, что не будет работать без equals и hashCode. Работает. Насколько понимаю при такой простой реализации обрабатывается корректно и на более низком уровне без оверрайдов
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(name, phoneBook.name) &&
                Objects.equals(phoneNumber, phoneBook.phoneNumber) ;
    }*/

   /* @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }*/
}
