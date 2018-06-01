package com.knowledge.collection.set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

/***
 * @ClassName MyHashSet
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/1 16:31
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class MyHashSet {

    public static void main(String []args) {
        hashSet();
        treeSet();
    }

    static void treeSet() {
        Set<SetParam> setParams = new TreeSet<>();
        init(setParams);
        print(setParams);
    }

    static void init(Set<SetParam> setParams) {
        SetParam setParam;
        for (int i = 0; i < 15; i+=2) {
            setParam = new SetParam();
            setParam.setCode(i);
            setParam.setValue("value:"+i);
            setParams.add(setParam);
        }
        setParam = new SetParam(0,"String");
        setParams.add(new SetParam(11, "ss"));
        setParams.add(setParam);
    }

    static void print(Set<SetParam> setParams) {
        System.out.println(setParams.size());
        System.out.println(setParams.toString());
        for (SetParam setParam : setParams) {
            System.out.println(setParam);
        }
    }

    static void hashSet() {
        Set<SetParam> setParams = new HashSet<>(16);
        init(setParams);
        print(setParams);
    }



    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class SetParam implements Comparable{
        private int code;
        private String value;

        @Override
        public String toString() {
            return "SetParam{" +
                    "code=" + code +
                    ", value='" + value + '\'' +
                    '}'+super.toString();
        }


        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            return code == ((SetParam)o).getCode();
        }

        @Override
        public int hashCode() {
            return (code >> 5 - 1)  + ((value != null)?value.hashCode():0);
        }

        /**
         * 用于TreeSet排序
         * @param o
         * @return
         */
        @Override
        public int compareTo(Object o) {
            int code = ((SetParam)o).getCode();
            return this.code - code;
        }
    }


}
