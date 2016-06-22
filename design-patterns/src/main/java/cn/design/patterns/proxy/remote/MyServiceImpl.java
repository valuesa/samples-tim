package cn.design.patterns.proxy.remote;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by LuoLiBing on 16/6/22.
 */
public class MyServiceImpl extends UnicastRemoteObject implements MyService {

    @Override
    public String sayHello(String name) throws RemoteException {
        System.out.println("hello " + name);
        return "hello " + name;
    }

    protected MyServiceImpl() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            MyService myService = new MyServiceImpl();
            Naming.rebind("RemoteHello", myService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
