package com.offcn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name="tb_user")


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name",nullable = true,length = 20)
    private String name;
    @Column(name = "age",nullable = true,length = 4)
    private Integer age;


}
