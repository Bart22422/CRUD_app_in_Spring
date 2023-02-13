package web.model;


import javax.persistence.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "userTableDate")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Date age;

    public User() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User" + "\n" + "name: \t" + getName() + "\n" + "last name: \t" + getLastName() + "\n" + "birthday: \t" + getAge();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        obj = new User();
        return ((User) obj).getName().equals(this.getName()) && ((User) obj).getLastName().equals(this.getLastName()) && ((User) obj).getAge().equals(this.getAge());
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (age == null ? 0 : age.hashCode());
        result = 31 * result + (lastName == null ? 0 : lastName.hashCode());

        return result;
    }
}
