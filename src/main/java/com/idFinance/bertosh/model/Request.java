package com.idFinance.bertosh.model;

import com.idFinance.bertosh.constants.Status;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;
    @Column
    private float bid;
    @Column
    private Date dueDate;
    @Column
    private Status status;

    public Request() {

    }

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

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (id != request.id) return false;
        if (Float.compare(request.bid, bid) != 0) return false;
        if (name != null ? !name.equals(request.name) : request.name != null) return false;
        if (dueDate != null ? !dueDate.equals(request.dueDate) : request.dueDate != null) return false;
        return status != null ? status.equals(request.status) : request.status == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bid, name, dueDate, status);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bid=" + bid +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                '}';
    }
}
