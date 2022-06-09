package zf.task.hiperspring.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private int id;

@Column(name = "name")
    private String name;

@Column(name = "surname")
    private String surname;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "car_model")
    private Car car_model;


    public User(){}

    public User(int id, String name, String surname, Car car_model) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.car_model = car_model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Car getCar_model() {
        return car_model;
    }

    public void setCar_model(Car car_model) {
        this.car_model = car_model;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", car_model=" + car_model +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(car_model, user.car_model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, car_model);
    }
}
