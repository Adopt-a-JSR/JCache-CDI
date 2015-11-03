package com.kodcu;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rahmanusta on 02.11.2015.
 */
public class Person implements Serializable {

    private Long id;
    private String name;
    private String status;


    public Person() {
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(long id) {
        this(id, "Person-" + id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (getId() != null ? !getId().equals(person.getId()) : person.getId() != null) return false;
        return !(getName() != null ? !getName().equals(person.getName()) : person.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    public void updateStatus() {
        setStatus("Cached " + ThreadLocalRandom.current().nextLong(1, 10000));
    }
}
