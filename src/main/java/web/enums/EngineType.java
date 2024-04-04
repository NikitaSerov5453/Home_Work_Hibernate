package web.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EngineType {

    ELECTRIC("Electric motor"),

    GASOLINE("Petrol engine"),

    DIESEL("Diesel engine"),

    HYBRID("Hybrid engine");

    private final String value;
}
