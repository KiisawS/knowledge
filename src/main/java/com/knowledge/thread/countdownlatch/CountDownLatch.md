


###解释一下CountDownLatch概念?
实现线程之间的等待.

CountDownLatch
通过一个计数器来实现的,计数器的初始值为线程的数量.每当一个线程完成了自己的任务后，计数器的值就会减1.当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务.
````
CountDownLatch伪代码:
//Main thread start
//Create CountDownLatch for N threads
//Create and start N threads
//Main thread wait on latch
//N threads completes there tasks are returns
//Main thread resume execution
````
###CountDownLatch 和CyclicBarrier的不同之处?
1. CountDownLatch一般用于某个线程A等待若干个子线程执行完任务后,线程A才继续执行;
CyclicBarrier一般用于一组线程互相等待至某个状态,然后这一组线程再同时执行.
2. CountDownLatch的计数器不可重新设置,所以不可重用;
而CyclicBarrier维护了内部的计数器,可重用.
###给出一些CountDownLatch使用的例子?
1. 上学考试,每个学生交卷时间不一样,但老师只有在学生全部交卷或者到考试结束时间后,才会整理试卷,贴封条,下班,陪父母老婆孩子.
2. 长途汽车,每位乘客上车后,可用座位减1,直到座位为0,司机发车.
3. LOL,进入游戏时,只有全部加载100%,才会正式进入游戏.
###CountDownLatch 类中主要的方法?
1. await()
2. await(long time,TimeUtil timeUtil)
3. countDown()