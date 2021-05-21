package com.jtc.india;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class Jtc30 {
public static void main(String[] args) {
Transaction tx=null;
try{
SessionFactory sf=CHibernateUtil.getSessionFactory();
Session session=sf.openSession();
tx=session.beginTransaction();
System.out.println("1.All the Customers");
List<Customer> clist1=session.getNamedQuery("JTCAllCustomers").list();
for(Customer c:clist1){
System.out.println(c);
}
System.out.println("2.All Active the customers");
List<Customer> clist2=session.getNamedQuery("JTCActiveCustomers").list();
for(Customer c:clist2){
System.out.println(c);
}
System.out.println("3.Emails of All the Customers");
List<String> elist=session.getNamedQuery("EmailsOfAllCustomers").list();
for(String str:elist){
System.out.println(str);
}
System.out.println("3.Emails and Status of All the Customers");
List<Object[]> eplist=session.getNamedQuery("EmailsAndstatusOfAllCustomers").list();
for(Object obj[]:eplist){
for(Object o:obj){
System.out.println(o+"\t");
}
System.out.println("");
}
tx.commit();
session.close();
}catch(Exception e){
e.printStackTrace();
if(tx!=null)
tx.rollback();
}
}
}

