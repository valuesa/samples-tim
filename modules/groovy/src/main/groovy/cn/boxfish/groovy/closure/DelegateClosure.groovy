package cn.boxfish.groovy.closure

import org.junit.Test

/**
 * Created by TIM on 2015/8/12.
 */
class DelegateClosure {

    @Test
    void run() {
        def cl = { getDelegate() }
        def cl2 = { delegate }
        assert cl() == cl2()
        assert cl() == this
        def enclosed = {
            { -> delegate}.call()
        }
        assert enclosed() == enclosed
    }

    class Person {
        String name
    }

    class Thing {
        String name
    }

    @Test
    void run1() {
        def p = new Person(name: 'Tim')
        def t = new Thing(name: "Bing")
        def upperCasedName = { delegate.name.toUpperCase() }
        upperCasedName.delegate = p
        println upperCasedName()
        upperCasedName.delegate = t
        println upperCasedName()

        def target = p
        def upperCasedNameUsingVar = { target.name.toUpperCase() }
        assert upperCasedNameUsingVar() == 'TIM'
    }

    @Test
    void delegationStrategy() {
        def p = new Person(name: 'Liu')
        def cl = { name.toUpperCase() }
        cl.delegate = p
        println cl()
    }

    class Person1 {
        String name
        def pretty = { "my name is $name" }
        String toString() {
            pretty()
        }
    }

    class Thing1 {
        String name
    }

    @Test
    void run2() {
        def p = new Person1(name: 'Luominghao')
        def t = new Thing1(name: 'Heguixiang')
        println p.toString()
        p.pretty.delegate = t
        println p.toString()

        p.pretty.resolveStrategy = Closure.DELEGATE_FIRST
        println p.toString()
    }

    class Person2 {
        String name
        int age
        def fetchAge = { age }
    }

    class Thing2 {
        String name
    }

    @Test
    void run3() {
        def p = new Person2(name: 'Jessica', age: 42)
        def t = new Thing2(name: 'Tim')
        def cl = p.fetchAge
        cl.delegate = p
        println cl()

        cl.delegate = t
        println cl()

        cl.resolveStrategy = Closure.DELEGATE_ONLY
        cl.delegate = p
        println cl()

        cl.delegate = t
        try {
            cl()
            assert false
        } catch (MissingPropertyException ex) {

        }
    }

}
