package com.project.travelAgency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

   // @JsonIgnore
   // @OneToMany(mappedBy = "fromCity")
   // private List<Tour> fromTour;
//
   // @JsonIgnore
   // @OneToMany(mappedBy = "toCity")
   // private List<Tour> toTour;
    @OneToMany
    @JsonIgnore
    private List<Airport> airports;
    @OneToMany
    @JsonIgnore
    private List<Hotel> hotels;
   // @JsonIgnore
   // @ManyToOne//(mappedBy="country_id")
   // private Country country;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        City city = (City) o;
        return id != null && Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
