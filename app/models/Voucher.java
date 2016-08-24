package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Voucher could be used in order to spend points {@link Customer} earned in exchange for some benefits during purchase.
 * <p>
 * Created by abozic on 8/18/16.
 */
@Entity
@SequenceGenerator(name = "voucher_seq", sequenceName = "voucher_seq")
public class Voucher extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voucher_seq")
    @Constraints.Required
    private int voucherId;
    @Constraints.Required
    private String name;
    private String description;
    private String imageUrl;
    @Constraints.Required
    private double points;
    private boolean active;
    @Column(columnDefinition = "timestamp default now()")
    private Date creationDate;
    @Constraints.Required
    private Date expiryDate;

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public static Model.Finder<Integer, Voucher> find = new Model.Finder<>(Voucher.class);

    public static Page page(int page, int pageSize, String sortBy, String order, String filter) {
        if (page < 1) page = 1;
        List<Voucher> data = Voucher.find.all();
        long total = data.size();
        return new Page(data, total, page, pageSize);
    }

    public static class Page {
        private final int pageSize;
        private final long totalRowCount;
        private final int pageIndex;
        private final List<Voucher> list;

        public Page(List<Voucher> data, long total, int page, int pageSize) {
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

        public List<Voucher> getList() {
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
}
