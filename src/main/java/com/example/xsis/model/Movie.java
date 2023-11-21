package com.example.xsis.model;

import com.example.xsis.model.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "movie")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends BaseEntity {

    @NotNull
    @NotBlank
    @Column(length = 40)
    private String title;

    @NotNull
    @NotEmpty(message = "Please Enter the Description")
    private String description;

    @NotNull(message = "Please Enter the rating")
    private Float rating;

    private String image;

}
