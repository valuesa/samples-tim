package cn.boxfish.groovy1.list

import org.junit.Test

/**
 * Created by TIM on 2015/8/20.
 */
class ListTest {

    @Test
    void timesTest() {
        3.times { println it}
        0.step(10, 2) {
            println it
        }
    }
}
