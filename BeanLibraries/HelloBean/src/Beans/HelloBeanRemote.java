/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Remote;

/**
 *
 * @author sean
 */
@Remote
public interface HelloBeanRemote {

    String sayHello(final String name);
    
}
