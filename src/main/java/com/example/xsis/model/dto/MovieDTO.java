package com.example.xsis.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieDTO {
    @Column(length = 40)
    private String title;

    private String description;

    private Float rating;

    private String image;
}
