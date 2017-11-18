package com.piedpiper.univerrate.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "university")
@AllArgsConstructor
@NoArgsConstructor
public @Data
class UniversityEntity {

    @Id
    @GenericGenerator(strategy = "uuid2", name="uuid_generator")
    @GeneratedValue(generator = "uuid_generator")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "ownership")
    private String ownership;

    @Column(name = "governing_body")
    private String governingBody;

    @Column(name = "type")
    private String type;

    @Column(name = "region")
    private String region;

    @Column(name = "address")
    private String address;
}
