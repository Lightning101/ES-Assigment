/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserBeans;

import Model.MemberModel;
import javax.ejb.Stateless;
import ORM_DB.Members;

/**
 * Used for simple member database transaction
 * @author sean
 */
@Stateless
public class UserOpsBean implements UserOpsBeanRemote {

    // Process all relavent database acctions for members
    private static MemberModel memberMod = new MemberModel();
    
    public UserOpsBean()
    {
        memberMod.createConnection();
        
    }
    /**
     * Adds User to the Database
     * @param member : member needed to be added
     */
    @Override
    public void saveMember(final Members member) {
        memberMod.saveMember(member);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
