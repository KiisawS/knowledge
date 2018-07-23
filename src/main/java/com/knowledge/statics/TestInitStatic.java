package com.knowledge.statics;

/*** 
 * @ClassName TestInitStatic
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/29 16:23
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public abstract class TestInitStatic {

    static int i = 1;

    static {
        //1
        System.out.println(i);
        i = 3;
    }

    {
        //3
        System.out.println(i);
        i = 10;
    }

    public TestInitStatic() {
        //10
        System.out.println(i);
        i = 2;
    }

    /**
     * 结果 :
     * 1
     * 3
     * 3
     * 10
     * 2
     * 5
     * @param args
     */
    public static void main(String []args) {
        //3
        System.out.println(i);

        //调用构造函数初始化
        new TestInitStatic() {
            void p() {
                //2
                System.out.println(i);
                i = 5;
            }
        }.p();

        //5
        System.out.println(i);
    }
}
