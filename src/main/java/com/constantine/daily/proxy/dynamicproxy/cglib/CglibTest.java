package com.constantine.daily.proxy.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * JDK动态代理与CGLIB动态代理对比
 * JDK动态代理：基于Java反射机制实现，必须要实现了接口的业务类才能用这种办法生成代理对象。
 * cglib动态代理：基于ASM机制实现，通过生成业务类的子类作为代理类。
 * JDK Proxy 的优势：
 *
 * 最小化依赖关系，减少依赖意味着简化开发和维护，JDK 本身的支持，可能比 cglib 更加可靠。
 * 平滑进行 JDK 版本升级，而字节码类库通常需要进行更新以保证在新版 Java 上能够使用。
 * 代码实现简单。
 *
 * 基于类似 cglib 框架的优势：
 *
 * 无需实现接口，达到代理类无侵入
 * 只操作我们关心的类，而不必为其他相关类增加工作量。
 * 高性能
 */
public class CglibTest {
    public static void main(String[] args) {
        LogInterceptor logInterceptor = new LogInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);   // 设置超类，cglib是通过继承来实现的
        enhancer.setCallback(logInterceptor);

        UserDao proxy = (UserDao) enhancer.create();   // 创建代理类
        proxy.select();
        proxy.update();

    }
}

