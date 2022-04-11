package api.dto.request.pet;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagsItem {

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private BigDecimal id;

}