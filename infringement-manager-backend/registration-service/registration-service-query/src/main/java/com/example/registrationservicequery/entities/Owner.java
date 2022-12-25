package com.example.registrationservicequery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Owner {
    @Id
    private String id;
    private String CIN;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER)
    List<Vehicle> vehicleList= new ArrayList<>();
}
