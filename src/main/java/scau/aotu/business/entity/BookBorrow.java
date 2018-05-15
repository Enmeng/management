package scau.aotu.business.entity;

import scau.aotu.base.dao.annotation.Table;
import scau.aotu.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by AutoSSM.
 */
@Table(name = "tomato_book_borrow")
public class BookBorrow extends Unique {
    private String bookId;

    private String userId;

    private Date startTime;

    private Date endTime;

    private Enum status;

    public BookBorrow() {
    }

    public BookBorrow(String bookId, String userId, Date startTime, Date endTime, Enum status) {
        this.bookId = bookId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }


}
