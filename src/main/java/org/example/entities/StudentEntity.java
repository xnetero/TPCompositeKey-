package org.example.entities;

import javax.persistence.*;

@Entity
public class StudentEntity {


    @EmbeddedId
    private StudentId studentId;



    public StudentId getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentId studentId) {
        this.studentId = studentId;
    }

    @Column(name = "name_student")
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "rue",column = @Column(name = "Rue_student")),
            @AttributeOverride(name = "avenue",column = @Column(name = "avenue_student")),
            @AttributeOverride(name = "number",column = @Column(name = "number_student")),
    })
    private Adresse adresse;

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "StudentEntity{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }
}
