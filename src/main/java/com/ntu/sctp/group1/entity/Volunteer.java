package com.ntu.sctp.group1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name="volunteer")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @NotBlank(message = "Name cannot be blank!")
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @NotBlank(message = "Email cannot be blank!")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "organization")
    private String individual;

    @Column(name = "created_at", updatable = false)
    Timestamp createdAt = new Timestamp(new Date().getTime());

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "volunteer", cascade = CascadeType.ALL)
    private Profile profile;

//    @JsonIgnore
//    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL)
//    List<Availability> availabilities;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "enrolment_volunteer",
            joinColumns = @JoinColumn(name = "volunteer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "enrolment_id", referencedColumnName = "id")
    )
    private Set<Enrolment> enrolments;

}