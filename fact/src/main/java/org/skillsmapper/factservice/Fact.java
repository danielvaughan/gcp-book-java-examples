package org.skillsmapper.factservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    private String skill;

    protected Fact() {
    }

    public Fact(String type, String skill) {
        this.type = type;
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSkill() {
        return skill;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }

    public void setSkill(final String skill) {
        this.skill = skill;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
