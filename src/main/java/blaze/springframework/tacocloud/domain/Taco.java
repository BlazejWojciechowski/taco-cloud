package blaze.springframework.tacocloud.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date createdAt;
    @ManyToMany
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
