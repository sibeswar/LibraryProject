package com.techsoltrackers.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "USER")
@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    Long userId;

    @NotBlank
    @Column(name="USER_NAME")
    String userName;

    @NotBlank
    @Column(name="EMAIL_ID")
    String emailId;
}
