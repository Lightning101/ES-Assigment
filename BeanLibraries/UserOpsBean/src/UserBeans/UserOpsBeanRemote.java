/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserBeans;


import ORM_DB.Members;
import javax.ejb.Remote;

/**
 *
 * @author sean
 */
@Remote
public interface UserOpsBeanRemote {

    void saveMember(final Members member);
    
}
