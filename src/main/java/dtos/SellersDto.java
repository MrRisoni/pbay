package dtos;

import lombok.Data;

@Data
public class SellersDto {
    private Integer id;
    private String title;
    private CountryDto countryObj;

}
