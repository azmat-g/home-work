package tests.reqres.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColorPojo {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;
}
