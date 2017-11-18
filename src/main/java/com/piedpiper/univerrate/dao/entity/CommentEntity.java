package com.piedpiper.univerrate.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
public @Data
class CommentEntity {
    @Id
    @GenericGenerator(strategy = "uuid2", name="uuid_generator")
    @GeneratedValue(generator = "uuid_generator")
    @Column(name = "id")
    private String id;

    @Column(name = "author_email")
    private String authorEmail;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "content")
    private String content;

    @Column(name = "university_id")
    private String universityId;

    @Column(name = "rate")
    private int rate;

    @Column(name = "date")
    private long date;
}
