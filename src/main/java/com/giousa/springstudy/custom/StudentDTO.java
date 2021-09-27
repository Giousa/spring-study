package com.giousa.springstudy.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO extends BaseDTO {

    private UserDTO userInfo;

    private String methods;
}
