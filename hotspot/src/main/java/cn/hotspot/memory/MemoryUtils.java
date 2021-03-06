package cn.hotspot.memory;

/**
 * Created by LuoLiBing on 17/1/19.
 * 运行时数据
 * 1 PC             程序计数器
 * 2 Stacks         java虚拟机堆栈
 * 3 Heap           堆
 * 4 Method Area    方法区也叫永久代(Permanent Generation)
 * 5 Run-Time Method Area 运行时常量池
 * 6 Native Method stacks 本地方法栈
 */
public class MemoryUtils {

    /**
     * 运行时数据区域
     * JVM在执行java程序的过程中会把它所管理的内存划分为若干不同的数据区域. 这些区域都各有用途, 以及不同的创建和销毁的时间,
     * 有的区域随着虚拟机进程的启动而存在, 有些区域则依赖于用户线程的启动和结束而建立和销毁.
     *
     * JVM公共部分:
     * 1 方法区        (Method Area)
     * 2 堆           (Heap)
     * 3 执行引擎
     * 4 本地库接口
     *
     * 线程隔离的数据:
     * 1 虚拟机栈       (VM stack)
     * 2 本地方法栈      (Native Method stack)
     * 3 程序计数器      (Program Counter Register)
     */
    public void runtimeData() {

    }


    /**
     * 1 程序计数器 PC
     * 是一块较小的内存空间, 可以看作是当前线程所执行的字节码的行号指示器.
     * 字节码解释器工作时就是通过改变这个计数器的值来选取下一条需要执行的字节码指令, 分支|循环|跳转|异常处理|线程恢复等基础功能都需要计数器来完成
     * 在多线程轮流切换并分配处理器执行时间时, 在任何一个确定的时刻, 一个处理器(多核算多个)都只会执行一条线程中的指令. 因此, 为了线程切换后能恢复到正确的执行位置
     * 每条线程都需要有一个独立的程序计数器, 各条线程之间计算器互不影响, 独立存储(线程私有).
     *
     * 如果线程正在执行一个java方法, 这个计数器记录的是正在执行的虚拟机字节码指令的地址; 如果正在执行的是Native方法, 这个计数器为空.
     * PC是唯一JAVA虚拟机规范中没有规定任何OOME情况的区域.
     *
     */
    public void pc() {

    }


    /**
     * 2 java虚拟机栈(线程私有)
     *
     * 它的生命周期与线程相同, 虚拟机栈描述的是JAVA方法执行的内存模型;
     *
     * JAVA虚拟机堆栈
     * 每个Java虚拟机线程都有一个私有的Java虚拟机堆栈, 与线程同时创建.  Java虚拟机堆栈存储栈帧, 类似于C语言的堆栈: 它保存局部变量和部分结果, 并且在方法调用和返回中起作用.
     * 因为Java虚拟机堆栈从来不被直接操作, 除了push和pop帧, 帧可以被堆分配. Java虚拟机堆栈内存不需要是连续的.
     * Java虚拟机规范允许java虚拟机堆栈具有固定大小或者根据计算的需要动态地扩展和收缩. 如果Java虚拟机堆栈是固定大小的, 则当创建该堆栈时, 可以独立地选择每个Java虚拟机堆栈的大小.
     * Java虚拟机实现可以为程序员或用户提供对Java虚拟机堆栈的初始大小的控制, 以及在动态扩展或收缩Java虚拟机堆栈的情况下控制最大和最小大小.
     *
     * 一下异常与Java堆栈相关:
     * 1 如果线程中计算需要的堆栈大小比最大的Java虚拟机堆栈还大时, 将抛出StackOverflowError异常.
     * 2 如果Java虚拟机堆栈可以动态扩展, 并尝试扩展, 但是可用的内存不足以实现扩展, 或者如果没有足够的内存可用于为新线程创建初始Java虚拟机堆栈, 则抛出OutOfMemoryError异常
     *
     *
     * 每个方法在执行的同时都会创建一个栈帧用于存储
     * 1 局部变量表
     * 2 操作数栈
     * 3 动态链接
     * 4 方法出口等.
     * 栈帧的作用于存储数据和部分结果, 以及执行动态链接, 方法的返回值和异常调度. 每一次方法调用都会创建一个栈帧, 当栈帧的方法调用完成时, 栈帧被销毁, 无论是正常完成还是突然完成(抛出未捕获的异常).
     * 栈帧是从创建该帧的线程的Java虚拟机堆栈中分配的, 每个帧都有自己的局部变量数组, 它自己的操作数栈, 以及对当前方法类的运行时常量池的引用.
     * 可以使用附加的实现特定信息(例如调试信息)来扩展帧. 局部变量数组和操作数堆栈的大小在编译时确定, 并与用于与帧相关的方法的代码一起提供. 因此帧数据结构的大小仅取决于Java虚拟机的实现, 并且用于这些结构的存储器可以在方法调用时同时分配.
     * 只有一个帧, 即执行方法的帧, 在给定控制线程中是活动的. 这个帧称为当前帧, 方法称为当前方法. 类称为当前类. 局部变量和操作数栈的操作通常参考当前帧.
     * 如果帧的方法调用另一个方法或者其方法完成, 则帧停止为当前帧. 当调用方法时, 将创建一个新帧, 并在控制转移到新方法时变为当前框架. 在方法返回时, 当前帧将方法调用的结果返回到前一帧. 然后当前一帧变为当前帧, 同时丢弃当前帧.
     * 注意, 由线程创建的帧对于该线程是本地的, 并且不能被任何其他线程引用.
     *
     * 每一个方法从调用直至执行完成的过程, 就对应着一个栈帧在虚拟机中入栈到出栈的过程.
     *
     *
     *
     */
    public void jvmstacks() {

    }


    /**
     * 三 堆heap
     * Java虚拟机具有在所有Java虚拟机线程之间共享的堆. 堆是运行时数据区, 从中分配所有类实例和数组的内存.
     * 但是随着JIT编译器的法阵与逃逸分析技术逐渐成熟, 栈上分配, 标量替换优化技术奖会导致一些微妙的变化发生. 所有的对象都分配在堆上也渐渐变得不是那么绝对了.
     * 堆是在JVM启动时创建的, 对象的堆存储由GC进行回收; 对象从不显式释放. JVM假设没有特定类型的GC, 并且可以根据实现者的系统需求来选择GC技术.
     * 堆可以是固定大小的, 或者可以根据计算的需要进行扩展, 并且如果更大的堆变得不必要, 则可以收缩. 堆的内存不需要是连续的.
     * JVM实现可以提供程序员或用户对堆的初始大小的控制, 以及如果堆可以动态地扩展或收缩, 则控制最大和最小堆大小.
     *
     * 如果计算需要比自动存储管理系统可用的更多的堆, Java虚拟机将抛出OutOfMemoryError.
     *
     * Java堆是GC管理的主要区域, 因此也可以称作GC堆.
     */
    public void heap() {

    }


    /**
     * 四 方法区 method Area(逻辑堆的一部分, 别名Non-heap非堆), 存储类信息, 常量, 静态变量, 即使编译器编译后的机器码等数据.
     * JVM具有所有线程共享的方法区域, 方法区域类似于用于操作系统过程中的常规编译代码或类似于"文本"段的存储区域. 它存储每类结构, 例如运行时常量池, 字段和方法数据, 以及方法和构造函数的代码, 包括在类和实例初始化和接口初始化中使用的特殊方法.
     * 方法区域在虚拟机启动时创建. 虽然方法区域在逻辑上是堆的一部分, 但简单的实现可能选择不进行垃圾回收或压缩它. 方法区域的内存不需要是连续的.
     * Jvm可以设置方法区的初始大小, 以及控制最大和最小方法区大小. 如果方法区域中的内存不能用于满足分配请求, JVM将抛出OutOfMemoryError异常.
     *
     * 方法区可以进行类型卸载, 常量池回收
     */
    public void methodArea() {

    }


    /**
     * 五 运行时常量池: Run-Time Constant Pool
     * 运行时常量池是类文件中constant_pool表的每类或每个接口的运行时表示. 它包含集中变量, 从编译时一直的数字字面量到必须在运行时解析的方法和字段引用.
     * 运行时常量池提供与用于常规编程语言的符号表的函数类似的函数, 尽管它包含比典型符号表更宽的数据范围.
     * 每个运行时常量池从JVM的方法区分配, 类或接口的运行时常量池在JVM创建类或接口时构建.
     * 当创建类或接口时, 如果运行时常量池的构造需要比JVM的方法区中可用的更多的内存, JVM将抛出OutOfMemoryError异常
     *
     */
    public void runTimeConstantPool() {

    }


    /**
     * 六 本地方法栈
     * JVm实现可以使用称为C栈的常规栈来支持本地方法(Java之外的语言编写的方法). 本地方法栈也可以通过诸如C语言中实现用于JVM的指令集的解释器来使用.
     * 不能加载本地方法并且本身不依赖于常规栈的JVM实现不需要提供本地方法堆栈. 如果提供, 本地方法栈通常在每个线程创建时为每个线程分配.
     * 同样可以设置本地方法栈的大小.
     *
     * 有些虚拟机(Sun HotSpot)直接把本地方法栈和虚拟机栈合二为一.
     */
    public void nativeMethod() {

    }


    /**
     * 七 直接内存
     * 直接内存并不是虚拟机运行时数据区的一部分, 也不是JVM规范中定义的内存区域. NIO中通道和缓冲Buffer, 可以直接分配内存, 并且不受GC控制. 当内存不足时也会抛出OutOfMemoryError异常.
     */
    public void directMemory() {

    }
}
