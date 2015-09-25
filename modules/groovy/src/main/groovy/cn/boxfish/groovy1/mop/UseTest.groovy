package cn.boxfish.groovy1.mop

import org.junit.Test

/**
 * Created by LuoLiBing on 15/9/23.
 */
class UseTest {

    static String revert(String delegate) {
        return delegate.reverse()
    }

    @Test
    void test1() {
        use(UseTest, User1Test) {
            println "luolibing".revert()
        }
    }

    class User1Test {
        static String revert(String delegate) {
            return delegate.reverse()
        }
    }
}
