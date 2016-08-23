package models;

import com.avaje.ebean.Model;
import org.mindrot.jbcrypt.BCrypt;
import play.Logger;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User of the system.
 * Created by abozic on 8/19/16.
 */

@Entity
public class User extends Model {

    @Column(name = "fullName")
    private String fullName;
    @Id
    @Constraints.Required
    private String username;
    @Constraints.Required
    private String password;
    private UserType type;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String validate() {
        Logger.debug("in User\'s validate");

        if (authenticate(username, password) == null) {
            return "Invalid email or password";
        }
        return null;
    }

    public static Model.Finder<String,User> find = new Model.Finder<>(User.class);

    public static User authenticate(String username, String password) {

        User user = User.find.where().eq("username", username).findUnique();
        String hashedPassword = user == null ? "" : user.password;

        if (user != null && BCrypt.checkpw(password, hashedPassword)) {
            return user;
        } else {
            return null;
        }

    }

}
