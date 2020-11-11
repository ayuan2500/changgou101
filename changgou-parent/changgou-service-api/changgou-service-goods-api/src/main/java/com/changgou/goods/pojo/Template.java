package com.changgou.goods.pojo;

import javax.persistence.*;
import java.io.Serializable;

/***
 * @ClassName Template
 * @Description 模板pojo类
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 16:02:00
 */
@Table(name = "tb_template")    //跟数据库的表建立关系
public class Template implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; //id

    @Column(name = "name")
    private String name;    //模板名称

    @Column(name = "spec_num")
    private Integer specNum;    //规格数量

    @Column(name = "para_num")
    private Integer paraNum;    //参数数量

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specNum=" + specNum +
                ", paraNum=" + paraNum +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpecNum() {
        return specNum;
    }

    public void setSpecNum(Integer specNum) {
        this.specNum = specNum;
    }

    public Integer getParaNum() {
        return paraNum;
    }

    public void setParaNum(Integer paraNum) {
        this.paraNum = paraNum;
    }
}
