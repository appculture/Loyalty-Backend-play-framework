package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Customer contains all profile information's related to actual client.
 * <p>
 * Created by abozic on 8/18/16.
 */
@Entity
public class Customer extends Model {

    @Id
    @GeneratedValue(generator = "uuid")
    private String customerId;
    @NotNull
    private String fullName;
    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private double points;
    @Formats.DateTime(pattern = "dd.MM.yyyy")
    private Date birthDate;
    /**
     * User ID represent external system ID, ID might be filled during import of the data.
     */
    private String userId;
    @Column(columnDefinition = "timestamp default now()")
    private Date creationDate;

    public static Finder<String, Customer> find = new Finder<>(Customer.class);

    public Customer(String fullName, String email, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void insert() {
        if (customerId == null) customerId = UUID.randomUUID().toString();
        super.insert();
    }

    /**
     * Return a page of computer
     *
     * @param page     Page to display
     * @param pageSize Number of computers per page
     * @param sortBy   Computer property used for sorting
     * @param order    Sort order (either or asc or desc)
     * @param filter   Filter applied on the name column
     */
    public static Page page(int page, int pageSize, String sortBy, String order, String filter) {
        if (page < 1) page = 1;
        List<Customer> data = Customer.find.all();
        long total = data.size();
//        Customer.find.where().
//        Long total = (Long)JPA.em()
//                .createQuery("select count(c) from Computer c where lower(c.name) like ?")
//                .setParameter(1, "%" + filter.toLowerCase() + "%")
//                .getSingleResult();
//        @SuppressWarnings("unchecked")
//        List<Customer> data = JPA.em()
//                .createQuery("from Computer c where lower(c.name) like ? order by c." + sortBy + " " + order)
//                .setParameter(1, "%" + filter.toLowerCase() + "%")
//                .setFirstResult((page - 1) * pageSize)
//                .setMaxResults(pageSize)
//                .getResultList();
        return new Page(data, total, page, pageSize);
    }


    public static class Page {
        private final int pageSize;
        private final long totalRowCount;
        private final int pageIndex;
        private final List<Customer> list;

        public Page(List<Customer> data, long total, int page, int pageSize) {
            this.list = data;
            this.totalRowCount = total;
            this.pageIndex = page;
            this.pageSize = pageSize;
        }

        public long getTotalRowCount() {
            return totalRowCount;
        }

        public int getPageIndex() {
            return pageIndex;
        }

        public List<Customer> getList() {
            return list;
        }

        public boolean hasPrev() {
            return pageIndex > 1;
        }

        public boolean hasNext() {
            return (totalRowCount / pageSize) >= pageIndex;
        }

        public String getDisplayXtoYofZ() {
            int start = ((pageIndex - 1) * pageSize + 1);
            int end = start + Math.min(pageSize, list.size()) - 1;
            return start + " to " + end + " of " + totalRowCount;
        }

    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
