package com.company;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class Server extends Imple1{
    public Server(){}
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Imple1 obj=new Imple1();
        Interface1 skeleton=(Interface1) UnicastRemoteObject.exportObject(obj,0);
        Registry registry= LocateRegistry.createRegistry(6000);
        registry.bind("server",skeleton);
        System.out.println("Server is ready...");

    }
}
