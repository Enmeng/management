package scau.aotu.business.entity;

import scau.aotu.base.dao.annotation.Table;
import scau.aotu.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by AutoSSM.
 */
@Table(name = "tomato_book_purchase")
public class BookPurchase extends Unique {
    private String bookname;

    private String type;

    private String author;

    private Double price;

    private String publish;

    private Date pubdate;

    private Integer count;

    private String remarks;

    private Enum status;

    public BookPurchase() {
    }

    public BookPurchase(String bookname, String type, String author, Double price, String publish, Date pubdate, Integer count, String remarks, Enum status) {
        this.bookname = bookname;
        this.type = type;
        this.author = author;
        this.price = price;
        this.publish = publish;
        this.pubdate = pubdate;
        this.count = count;
        this.remarks = remarks;
        this.status = status;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }


}
