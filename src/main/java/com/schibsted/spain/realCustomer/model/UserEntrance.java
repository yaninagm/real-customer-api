package com.schibsted.spain.realCustomer.model;


import javax.persistence.*;

@Entity
@Table(name = "userEntrance")
public class UserEntrance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long entranceByDay;
    private Long entranceByMonth;
    private Long historyEntrance;

    @Column (name = "id", nullable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column (name = "user_id", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column (name = "entrance_by_day", nullable = true)
    public Long getEntranceByDay() {
        return entranceByDay;
    }

    public void setEntranceByDay(Long entranceByDay) {
        this.entranceByDay = entranceByDay;
    }

    @Column (name = "entrance_by_month", nullable = true)
    public Long getEntranceByMonth() {
        return entranceByMonth;
    }

    public void setEntranceByMonth(Long entranceByMonth) {
        this.entranceByMonth = entranceByMonth;
    }

    @Column (name = "history_entrance", nullable = true)
    public Long getHistoryEntrance() {
        return historyEntrance;
    }

    public void setHistoryEntrance(Long historyEntrance) {
        this.historyEntrance = historyEntrance;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
