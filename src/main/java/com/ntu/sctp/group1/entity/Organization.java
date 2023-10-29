package com.ntu.sctp.group1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name="organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @NotBlank(message = "Name cannot be blank!")
    @Column(name = "organization", nullable = false)
    private String organization;

    @Column(name = "number of volunteers")
    private Number volunteers;

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

}
