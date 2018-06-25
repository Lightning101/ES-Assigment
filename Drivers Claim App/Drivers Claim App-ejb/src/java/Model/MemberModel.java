/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import HibernateConnection.NewHibernateUtil;
import ORM_DB.Members;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Harshana-PC
 */
public class MemberModel {
    //Used to hold connection
    static Session session = null;
    
    public void saveMember(Members employee) {
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }
     
    public void closeConnection()
    {
        if(session != null)
        {
            if(session.isOpen())
            {
                try
                {
                    
                    session.close();
                    session = null;
                }catch(HibernateException e)
                {
                    System.err.println("Unable to close connection Reason\n"+e);
                }
            }
        }
    }
    
    public void createConnection()
    {
        try{
        
           if(session == null)
                session = NewHibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
           System.err.println("Unable to open connection Reason\n" + e);
           session = null;
        }
        
    }

}
