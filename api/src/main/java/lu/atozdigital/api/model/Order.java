package lu.atozdigital.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.Instant;
import java.util.List;


import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OrderEcommerce")
public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long orderId;
    private String uuid;
    private Instant createdDate;
    @ManyToMany(fetch = LAZY)
    @JoinTable(
            name = "order_article",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id"))
    @JsonManagedReference
    private List<Article> articles;
}
