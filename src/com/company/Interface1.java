package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
public interface Interface1  extends Remote {
    public List<Kebele> getKebele() throws RemoteException, ClassNotFoundException;
    public List<VitalRegistrationEvent> getVitaRegistrationEvent() throws RemoteException;
    public List<Herqa> getHerqa() throws RemoteException;
    public List<Bank> getBank() throws RemoteException;
    public  List<KebeLogin> getKebeLogin() throws RemoteException;
    public  List<HerqaLogin> getHerqaLogin() throws RemoteException;
    public  List<BankLogin> getBankLogin() throws RemoteException;
    public  List<VitalLogin> getVitalLogin() throws RemoteException;
}
