package org.cloud.ormDemo.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_employee")
public class Employee {
    private long id;
    private String name;
    private String address;
    private int age;

    public Employee() {
        super();
    }

    public Employee(String name, String address, int age) {
        super();
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Employee(long id, String name, String address, int age) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", address=" + address + ", age=" + age + "]";
    }
}
