package web.entity;


import web.enums.EngineType;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "power")
    private Integer power;

    @Column(name = "engine_type")
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    public Car setId(Long id) {
        this.id = id;
        return this;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

    public Car setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Car setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }

    public Car setEngineType(String engineType) {
        this.engineType = EngineType.valueOf(engineType);
        return this;
    }
}
