package com.sda.travelAgency.dto.reservation;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ReservationCreateDto {

    @NotBlank(message = "Name is mandatory!")
    private String roomId;

    @NotBlank(message = "Name is mandatory!")
    private Integer userId;

    private Date startDate;

    private Date endDate;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
