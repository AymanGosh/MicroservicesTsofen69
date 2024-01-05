
// 4. **Object Streams (ObjectInputStream, ObjectOutputStream):**
//- Serializing and deserializing objects:

 import java.io.*;

 class Person implements Serializable {
     private String name;
     private int age;

     public Person(String name, int age) {
         this.name = name;
         this.age = age;
     }

     @Override
     public String toString() {
         return "Person{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }
 }

 public class ObjectStreamExample {
     public static void main(String[] args) {
         // Serialization
         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
             Person person = new Person("John", 30);
             oos.writeObject(person);
         } catch (IOException e) {
             e.printStackTrace();
         }

         // Deserialization
         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
             Person restoredPerson = (Person) ois.readObject();
             System.out.println("Restored Person: " + restoredPerson);
         } catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
 }
