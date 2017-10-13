/***********************************************************************
 * Module:  Choreography.java
 * Author:  邵闫利
 * Purpose: Defines the Class Choreography
 ***********************************************************************/

package ynu.edu.module.bpmn;

import java.util.*;

/** @pdOid c0491f64-a3a0-46e4-bc05-a27e2bc7d0be */
public class Choreography extends CommonElement {
   /** @param id 
    * @param inComming 
    * @param outGoing 
    * @param name
    * @pdOid 914cb895-ca44-446d-a40c-4687a8323445 */
   public Choreography(String id, String inComming, String outGoing, String name) {
    super.id = id;
    super.inComing = inComming;
    super.outGoing = outGoing;
    super.name = name;
   }
   
   /** @pdOid 96cb85b2-e16e-40c6-8d24-e12bcdf17d96 */
   public String toString() {
    return "Type:"+this.getClass().getName()+"\n id: "+id+"\n inComing: "+inComing+"\n outGoing: "+outGoing+"\n name:"+name;
   }

}