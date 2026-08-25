package leetcode.editor.cn;

/**
 * @author 25212
 * @description TODO
 * @date 2026/8/20 19:37
 */
// 单例模式，双重校验锁
public class Singleton{
    // 1. volatile 防止指令重排序
    private static volatile Singleton instance;
    // 2. 私有构造方法，防止外部 new
    private Singleton() {
    }

    public static Singleton getInstance() {

        // 第一次检查：避免每次都进入 synchronized
        if (instance == null) {

            synchronized (Singleton.class) {

                // 第二次检查：防止多个线程重复创建对象
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
