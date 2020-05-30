package com.cui.bookreadingfeel.understandjvm;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/20 17:06
 * -server -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *  Java堆大小 -Xms20M -Xmx20M
 *  Java新生代大小 -Xmn10M   老年代大小等于20-10=10MB
 *  Java新生代中Eden区与一个Survivor区的空间比8：1
 *  Java8默认垃圾回收器
 *  -XX:+UseParallelGC 新生代使用ParallerGC，老年代使用Serial Old
 */
public class AllocationTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception{
        //Thread.sleep(1000000);
        byte[] alloction1, alloction2, alloction3, alloction4, alloction5, alloction6;
        alloction1 = new byte[2 * _1MB];
        alloction2 = new byte[2 * _1MB];
        alloction3 = new byte[1 * _1MB];
        Thread.sleep(1000);
        alloction4 = new byte[2 * _1MB];
        Thread.sleep(1000);
        alloction5 = new byte[4 * _1MB];
        Thread.sleep(100000);
        alloction6 = new byte[4 * _1MB];
        System.out.println(Runtime.getRuntime().totalMemory() / 1000000);
    }
    // 该程序运行后GC日志
    /**
     * 2020-05-20T17:26:48.609+0800: 10.122: [GC (Allocation Failure) [PSYoungGen: 7090K->1008K(9216K)] 7090K->5232K(19456K), 0.0051565 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     * Heap
     *  PSYoungGen      total 9216K, used 5303K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 8192K, 52% used [0x00000000ff600000,0x00000000ffa31e58,0x00000000ffe00000)
     *   from space 1024K, 98% used [0x00000000ffe00000,0x00000000ffefc040,0x00000000fff00000)
     *   to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
     *  ParOldGen       total 10240K, used 4224K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     *   object space 10240K, 41% used [0x00000000fec00000,0x00000000ff020020,0x00000000ff600000)
     *  Metaspace       used 3728K, capacity 4536K, committed 4864K, reserved 1056768K
     *   class space    used 410K, capacity 428K, committed 512K, reserved 1048576K
     */

    // 分析GC日志
    /**
     * 这是个YGC日志
     * 2020-05-20T17:26:48.609+0800: 10.122: [GC (Allocation Failure)
     * [PSYoungGen: 7090K->1008K(9216K)] 7090K->5232K(19456K), 0.0051565 secs]
     * [Times: user=0.00 sys=0.00, real=0.01 secs]
     *
     * 1, 2020-05-20T17:26:48.609+0800
     *    GC的时间戳,日期形式
     * 2, 10.122
     *    Java虚拟机启动以来经过的秒数
     * 3, [GC 与 [Full GC 与 [Full GC(System)
     *    说明了垃圾回收的停顿类型， 不是 用来区分新生代GC还是老年代GC的。
     *    有 Full ，说明此次GC发生了"Stop-The-World"
     *    有 Full GC(System) ， 说明是调用System.gc()方法触发的收集。
     * 4, (Allocation Failure)
     *    表明本次引起GC的原因是因为在年轻代中没有足够的空间能够存储新的数据了。
     * 5, [PSYoungGen
     *    表示GC发生的区域，与使用的GC收集器是密切相关的。
     *    [DefNew   Serial收集器
     *    [ParNew   ParNew收集器
     *    [PSYoungGen   Parallel Scavenge收集器
     * 6, 7090K->1008K(9216K)
     *    7090K YGC前新生代已使用容量
     *    1008K YGC后新生代已使用容量
     *    9216K 新生代总容量
     *    新生代总容量为9MB的原因，根据vm参数，eden为8M，S0为1M，S1为1M所以为9M，因为每次只用一个survivor区
     * 7, 7090K->5232K(19456K)
     *    7090K YGC前JVM堆总内存占用
     *    5232K YGC后JVM堆总内存占用
     *    19456K JVM堆总内存占用
     * 8, 0.0051565 secs
     *    YGC耗时 秒
     * 9, [Times: user=0.00 sys=0.00, real=0.01 secs]
     *    user=0.00 YGC用户耗时，（用户态消耗的CPU时间）
     *    sys=0.00  YGC系统耗时，（内核态消耗的CPU时间）
     *    real=0.01 YGC实际耗时，（操作从开始到结束所经过的墙钟时间）
     *    CPU时间与墙钟时间的区别是，墙钟时间包括各种非运算的等待耗时，例如等待磁盘IO，等待线程阻塞，
     *    而CPU时间不包括这些耗时，但当系统有多CPU或者多核的话，多线程操作会叠加这些时间，
     *    所以 user + sys > real,是正常的。
     */

    // 当老年代发生GC时经常会伴随至少一次的YGC（但并非绝对的，在Parallel Scavenge收集器的
    // 收集策略里就有直接进行YGC的策略选择过程）。


    /**
     * 这是个FULl GC日志
     * 2020-05-20T18:57:41.483+0800: 10.119: [Full GC (Ergonomics)
     * [PSYoungGen: 7288K->7090K(9216K)]
     * [ParOldGen: 8232K->8204K(10240K)] 15520K->15295K(19456K),
     * [Metaspace: 3727K->3727K(1056768K)], 0.0073423 secs]
     * [Times: user=0.00 sys=0.00, real=0.01 secs]
     *
     * 1, 2020-05-20T18:57:41.483+0800
     *    GC的时间戳,日期形式
     * 2,10.119
     *    Java虚拟机启动以来经过的秒数
     * 3, [Full GC 与[GC  与 [Full GC(System)
     *    说明了垃圾回收的停顿类型， 不是 用来区分新生代GC还是老年代GC的。
     *    有 Full ，说明此次GC发生了"Stop-The-World"
     *    有 Full GC(System) ， 说明是调用System.gc()方法触发的收集。
     * 4, [PSYoungGen
     *    Eden区
     * 5, 7288K->7090K(9216K)
     *    7288K GC前新生代已使用容量
     *    7090K GC后新生代已使用容量
     *    9216K 新生代总容量
     *    新生代总容量为9MB的原因，根据vm参数，eden为8M，S0为1M，S1为1M所以为9M，因为每次只用一个survivor区
     * 6, [ParOldGen
     *    Old区
     * 7, 8232K->8204K(10240K)
     *    8232K GC前Old区总内存占用
     *    8204K GC后Old区总内存占用
     *    10240K Old区总内存占用
     * 8, 15520K->15295K(19456K)
     *    15520K GC前JVM堆总内存占用
     *    15295K GC后JVM堆总内存占用
     *    19456K JVM堆总内存占用
     * 9, [Metaspace
     *    元空间
     * 10, 3727K->3727K(1056768K)
     *    3727K GC前元空间内存占用
     *    3727K GC后元空间内存占用
     *    1056768K 元空间总内存占用
     * 11, 0.0073423 secs
     *    GC耗时 秒
     * 12, [Times: user=0.00 sys=0.00, real=0.01 secs]
     *    user=0.00 GC用户耗时，（用户态消耗的CPU时间）
     *    sys=0.00  GC系统耗时，（内核态消耗的CPU时间）
     *    real=0.01 GC实际耗时，（操作从开始到结束所经过的墙钟时间）
     *    CPU时间与墙钟时间的区别是，墙钟时间包括各种非运算的等待耗时，例如等待磁盘IO，等待线程阻塞，
     *    而CPU时间不包括这些耗时，但当系统有多CPU或者多核的话，多线程操作会叠加这些时间，
     *    所以 user + sys > real,是正常的。
     */


    // GC日志参数
    /**
     * -XX:+PrintGC 输出GC日志
     * -XX:+PrintGCDetails 输出GC的详细日志
     * -XX:+PrintGCTimeStamps 输出GC的时间戳（以基准时间的形式）Java虚拟机启动以来经过的秒数
     * -XX:+PrintGCDateStamps 输出GC的时间戳（以日期的形式，如 2013-05-04T21:53:59.234+0800）
     * -XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
     * -Xloggc:../logs/gc.log 日志文件的输出路径
     */
    
}
