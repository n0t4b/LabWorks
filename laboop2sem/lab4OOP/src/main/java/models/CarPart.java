package models;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "car_parts")
public class CarPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_id")
    private Auto auto;

    public CarPart() {
    }

    public CarPart(String name, BigDecimal price, Auto auto) {
        this.name = name;
        this.price = price;
        this.auto = auto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "CarPart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", auto=" + auto +
                '}';
    }
}