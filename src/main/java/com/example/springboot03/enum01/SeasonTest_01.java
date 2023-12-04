package com.example.springboot03.enum01;

/**
 * @author yanhao
 * @data 2023/12/4
 */
public class SeasonTest_01 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        // 1、toString()
        System.out.println(summer.toString());

        System.out.println("枚举类的父类是：" + Season1.class.getSuperclass());

        // 2、values()
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        System.out.println("-----------------");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        // 3、valueOf
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();
    }
}


interface Info {
    void show();
}

/**
 * Enum类的主要方法：
 * 1、values()方法：返回枚举类的对象数组，该方法可以很方便的遍历所有的枚举值
 * 2、valueOf(String str)方法：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的"名字"。
 * 如果不是，会有运行时异常：IllegalArgumentException.
 * 3、toString()方法：返回当前枚举类对象常量的名称
 */
// 使用enum定义枚举类
enum Season1 implements Info {
    // 1、提供当前枚举类的多个对象, 多个对象之间用逗号隔开
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("夏天--热热热");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };
    // 1、声明season 的属性
    private final String seasonName;
    private final String seasonDesc;

    // 2、私有化类的构造器，并给对象属性初始化
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

/*    @Override
    public void show() {
        System.out.println("这是一个季节");
    }*/
}