package RIO.example.description;

//import java.util.Date;

import java.sql.Date;

public class YoungestOldestWorkers {
    public String type;
    public String name;
    public Date birthday;

    public YoungestOldestWorkers(String type, String name, Date birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "YoungestOldestWorkers{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
