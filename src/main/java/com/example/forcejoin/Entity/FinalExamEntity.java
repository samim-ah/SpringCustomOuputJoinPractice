package com.example.forcejoin.Entity;

import javax.persistence.*;


@Entity
@Table(name = "finalexam")
public class FinalExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slno;
    private String candidateName;
    private String candidatesurname;
    private int mark;

    public FinalExamEntity() {
    }

    public FinalExamEntity(String candidateName, String candidatesurname, int mark) {
        this.candidateName = candidateName;
        this.candidatesurname = candidatesurname;
        this.mark = mark;
    }

    public int getSlno() {
        return slno;
    }

    public void setSlno(int slno) {
        this.slno = slno;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidatesurname() {
        return candidatesurname;
    }

    public void setCandidatesurname(String candidatesurname) {
        this.candidatesurname = candidatesurname;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinalExamEntity that = (FinalExamEntity) o;

        if (mark != that.mark) return false;
        if (candidateName != null ? !candidateName.equals(that.candidateName) : that.candidateName != null)
            return false;
        return candidatesurname != null ? candidatesurname.equals(that.candidatesurname) : that.candidatesurname == null;
    }

    @Override
    public int hashCode() {
        int result = candidateName != null ? candidateName.hashCode() : 0;
        result = 31 * result + (candidatesurname != null ? candidatesurname.hashCode() : 0);
        result = 31 * result + mark;
        return result;
    }
}
