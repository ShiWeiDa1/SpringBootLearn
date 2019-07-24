package com.swd.springboot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author swd
 */
//使用jpa注解,配置映射关系
@Entity //告诉jpa这是一个实体类(和数据表映射的类)
@Table(name = "tbl_user")   //@table指定和那个数据表对应,如果省略默认表名是user
@JsonIgnoreProperties("hibernateLazyInitializer")//过滤掉Hibernate生成的属性
public class User  {
    /**
     * @Id 表示主键
     * @GeneratedValue 设置自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     *  @Column 和数据表对应的一个列,可以指定列的名字等属性,如果省略属性名就是列名
     */
    @Column(name = "last_name",length = 50)
    private String lastName;
    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
