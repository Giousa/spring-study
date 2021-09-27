package com.giousa.springstudy.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO {

    private Integer id;

    private String name;

}
