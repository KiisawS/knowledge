package com.knowledge.interface_;

/*** 
 * @ClassName MyAbsClass
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/8/7 11:02
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public abstract class MyAbsClass implements MyInterface{

    private String val;

    public MyAbsClass(String val) {
        this.val = val;
    }

    @Override
    public int getVal() {
        if (val == null) {
            return 0;
        }
        return val.length();
    }

    public abstract String getString();

    public static void main(String []args) {
        MyAbsClass myAbsClass = new MyAbsClass("1") {
            @Override
            public int getVal() {
                return super.getVal() + 2;
            }

            @Override
            public String getString() {
                return super.val;
            }
        };
        System.out.println(myAbsClass.getVal());
    }
}

abstract class SonC extends MyAbsClass {

    public SonC(String val) {
        super(val);
    }

    @Override
    public abstract String getString();

}
