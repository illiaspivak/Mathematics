package sk.kosickaakademia.spivak.serialization;

import java.io.Serializable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//  w w  w  . j  a  v a  2s. co  m
class Person implements Serializable {
  private String name = "Unknown";
  private String gender = "Unknown";
  private double height = Double.NaN;

  public Person(String name, String gender, double height) {
    this.name = name;
    this.gender = gender;
    this.height = height;
  }

  @Override
  public String toString() {
    return "Name: " + this.name + ", Gender:   " + this.gender + ",  Height: "
        + this.height;
  }
}

public class Main {
  public static void main(String[] args) {
    Person p1 = new Person("John", "Male", 1.7);
    Person p2 = new Person("Wally", "Male", 1.7);
    Person p3 = new Person("Katrina", "Female", 1.4);

    File fileObject = new File("person.ser");

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
        fileObject))) {

      oos.writeObject(p1);
      oos.writeObject(p2);
      oos.writeObject(p3);

      // Display the serialized objects on the standard output
      System.out.println(p1);
      System.out.println(p2);
      System.out.println(p3);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}