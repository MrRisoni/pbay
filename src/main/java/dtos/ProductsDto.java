package dtos;

import lombok.Data;

@Data
public class ProductsDto {
    private Long id;
    private String title;
    private String otherTitle;
    private String description;
    private short isPreOwned;
    private ProductsCategoryDto categoryObj;

}
