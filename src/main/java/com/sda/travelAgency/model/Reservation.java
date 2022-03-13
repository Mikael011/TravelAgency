package com.sda.travelAgency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "roomId")
    private String roomId;

    @Column(name = "userId")
    private Integer userId;

    @Column(name="startDate")
    private Date startDate;

    @Column(name="endDate")
    private Date endDate;

}
