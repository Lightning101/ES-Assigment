/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import HibernateConnection.NewHibernateUtil;
import ORM_DB.Members;
import ORM_DB.Users;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Chamath Ravin
 */
public class MemberModel {
   public void saveEmployee(Members member) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(member);//Insert member
        transaction.commit();
        session.close();
    }

    public List<Members> showAllEmployees() {
        List<Members> employeeList = new ArrayList();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From members");
        employeeList = query.list();
        return employeeList;
    }

    public void updateEmployee(int id, String ename, String enumber) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Members empdetails = (Members)session.load(Members.class, id);
//        empdetails.setEname(ename);
//        empdetails.setEnumber(enumber);
        session.update(empdetails);
        transaction.commit();
        session.close();  
    }
 
    public void deleteEmployee(Members employee) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
    }
    public void Login(String username, String password) {
//        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
    }
    public void Logout() {
        
    }

  
}
