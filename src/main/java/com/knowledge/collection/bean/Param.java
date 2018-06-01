package com.knowledge.collection.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * @ClassName Param
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/1 19:26
 * <p>Company: 杭州传化货嘀科技有限公司</p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Param implements Comparable {

    private int code;
    private String value;

    @Override
    public String toString() {
        return "SetParam{" +
                "code=" + code +
                ", value='" + value + '\'' +
                '}' + super.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        return code == ((Param) o).getCode();
    }

    @Override
    public int hashCode() {
        return (code >> 5 - 1) + ((value != null) ? value.hashCode() : 0);
    }

    /**
     * 用于TreeSet排序
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        int code = ((Param) o).getCode();
        return this.code - code;
    }
}
