package com.allan.snowflake;

/**
 * 使用单例模式生成ID
 * 懒汉式
 */
public class SingletonCreateId {
    /**
     * 私有构造方法,避免外部创建实例
     */
    private SingletonCreateId() {
    }

    private static IdSequenceUtils ID_INSTANCE = null;

    private static IdGeneratorUtils ID_INSRANCE = null;

    /**
     * 唯一序列ID
     *
     * @return  格式：123803454937235460
     */
    public static synchronized IdSequenceUtils getInstance() {
        if (ID_INSTANCE == null) {
            ID_INSTANCE = new IdSequenceUtils();
            System.out.println("******第一次创建 IdSequenceUtils****");
        }
        return ID_INSTANCE;
    }

    /**
     * 唯一序列ID
     *
     * @return 格式：201812081512052164096
     */
    public static synchronized IdGeneratorUtils getIdGenerator() {
        if (ID_INSRANCE == null) {
            ID_INSRANCE = new IdGeneratorUtils();
            System.out.println("******第一次创建 IdGeneratorUtils()****");
        }
        return ID_INSRANCE;
    }

}
