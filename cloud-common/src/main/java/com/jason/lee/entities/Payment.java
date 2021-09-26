package com.jason.lee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author huanli9
 * @description
 * @date 2021/3/9 23:31
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Min(value = 10)
    private Long id;

    @NotBlank
    @Length(min = 3, max = 5, message = "编号长度为3到5位")
    private String serial;
}