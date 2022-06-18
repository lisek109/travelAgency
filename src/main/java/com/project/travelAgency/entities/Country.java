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
public class Country {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;


    private String continents;

  //  @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
  //  @JsonIgnore
  //  @ToString.Exclude
  //  private List<City> cities;




    public Country(String name, String continents) {
        this.continents = continents;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Country country = (Country) o;
        return id != null && Objects.equals(id, country.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
