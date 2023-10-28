package com.ntu.sctp.group1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="profile")
public class Profile {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    
    @Column(name = "interests")
    private String interests = "";

    @Column(name = "hobbies")
    private String hobbies = "";

    @Column(name = "professional_experience")
    private String professionalExperience = "";

    @Column(name = "profile_picture")
    private String profilePicture = "";

    @Column(name="created_at", updatable= false)
    Timestamp createdAt = new Timestamp(new Date().getTime());

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @OneToOne
    @JoinColumn(name = "volunteer_id", referencedColumnName = "id")
    private Volunteer volunteer;
}
