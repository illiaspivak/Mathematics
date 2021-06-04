package sk.kosickaakademia.spivak.list;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private String fname;
    private String lname;
    private char gender;
    private int age;

    public Person(String fname, String lname, char gender, int age) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int hashCode(){
        Set<Character> vowels = new HashSet<Character>();
        for (char ch : "aeiouy".toCharArray()) {
            vowels.add(ch);
        }
        int result = 0;
        for(int i = 0; i < lname.length(); i++){
            char a = lname.charAt(i);
            if (vowels.contains(Character.toLowerCase(a))) {

            }else{
                result = result + (int)Math.pow(2, (lname.length() - i - 1));
            }
        }
        return result;
    }
}
