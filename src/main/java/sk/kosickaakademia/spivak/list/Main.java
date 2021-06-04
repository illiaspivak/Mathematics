package sk.kosickaakademia.spivak.list;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Illia", "Spivak",'m',25));
        list.add(new Person("Tetiana", "Pokhidniak",'f',20));
        list.add(new Person("Ruslan", "Zinevich",'m',25));
        list.add(new Person("Aleksandr", "Spivak",'m',32));
        list.add(new Person("Denys", "Lutyj",'m',23));
        list.add(new Person("Anrdiana", "Mukha",'f',21));
        list.add(new Person("Gabriela", "Mukha",'f',21));
        list.add(new Person("Andrej", "Spivak",'m',57));
        list.add(new Person("Elena", "Spivak",'f',56));
        list.add(new Person("Vitalij", "Havrilenko",'m',26));



        System.out.println("All persons");
        printNames(list);
        System.out.println();

        System.out.println("Only female");
        List<Person> listFemale;
        listFemale=list.stream().filter( obj ->   obj.getGender()=='f' ).collect(Collectors.toList());
        printNames(listFemale);
        System.out.println();

        System.out.println("Sort age");
        Collections.sort(list,(o1, o2)-> o1.getAge()-o2.getAge());
        printNames(list);
        System.out.println();

        System.out.println("Sort last name");
        Collections.sort(list,(o1, o2)-> (o1.getLname()+o1.getFname()).compareTo(o2.getLname()+o2.getFname()));
        printNames(list);
        System.out.println();


        System.out.println("Random");
        Collections.shuffle(list);
        printNames(list);
        System.out.println();

        List<Person> listAge20;
        listAge20=list.stream().filter( obj ->   obj.getAge() < 21 ).collect(Collectors.toList());
        System.out.println("Age < 21");
        printNames(listAge20);
        System.out.println();

        System.out.println("HashCode");
        for(Person temp:list){
            System.out.println(temp.getLname() + " " + temp.hashCode() + "; ");
        }

        System.out.println();
        System.out.println("Uloha 02.06");
        System.out.println("Hashcode IlliaSpivak " + hashCode("$%^  tgfir 564 oy"));



    }

    private static void printNames(List<Person> list) {
        list.forEach((obj)->{
            System.out.println(obj.getFname().charAt(0)+". "+obj.getLname()+" ("+obj.getAge()+")");
        });
    }

    public static int hashCode(String name){
        Set<Character> vowels = new HashSet<Character>();
        for (char ch : "aeiouy".toCharArray()) {
            vowels.add(ch);
        }
        int result = 0;
        for(int i = 0; i < name.length(); i++){
            char a = name.charAt(i);
            if (vowels.contains(Character.toLowerCase(a))) {

            }else{
                result = result + (int)Math.pow(2, (name.length() - i - 1));
            }
        }
        return result;
    }


}
