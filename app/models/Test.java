package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test extends Model {

    @Id
    public Long id;

    public String name;

    public static Finder<Long, Test> find = new Finder<>(Test.class);

}
