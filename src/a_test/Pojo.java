package a_test;

import java.util.Date;

public class Pojo {
    public Pojo(int id, Date date, Byte delete) {
        this.id = id;
        this.date = date;
        this.delete = delete;
    }

    int id;
    Date date;
    Byte delete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte getDelete() {
        return delete;
    }

    public void setDelete(Byte delete) {
        this.delete = delete;
    }
}
