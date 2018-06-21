/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Stateless;

/**
 *
 * @author sean
 */
@Stateless
public class HelloBean implements HelloBeanRemote {

    @Override
    public String sayHello(final String name) {
        return "Hello "+name+" nice to meet you";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
