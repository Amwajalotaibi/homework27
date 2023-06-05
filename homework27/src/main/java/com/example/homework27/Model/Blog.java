package com.example.homework27.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    private int id;

    private String title;

    private String body;

    private Integer userId;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "blogId",referencedColumnName = "id")
    private User user;
}
