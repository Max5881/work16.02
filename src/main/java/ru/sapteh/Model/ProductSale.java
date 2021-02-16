package ru.sapteh.Model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "productSale")
@Entity
public class ProductSale {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date dateTime;

    @Column
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "productSales")
    Product product;
    @Override
    public String toString() {
        return "ProductSale{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", quantity=" + quantity +
                '}';
    }
}
