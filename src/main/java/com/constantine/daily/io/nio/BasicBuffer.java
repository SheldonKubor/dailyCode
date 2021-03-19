package com.constantine.daily.io.nio;

import java.nio.IntBuffer;

/**
 * @description: buffer 案例
 * @author: mjh
 * @created: 2021/03/18 20:44
 * @version: V1.0
 */
public class BasicBuffer {
    public static void main(String[] args) {
        // 创建一个 Buffer, 一个可以存放 5 个整数的 Buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);
        // 向 Buffer 中存放数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i);
        }
        // 从 Buffer 读取数据
        // 对 Buffer 进行读写切换
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
