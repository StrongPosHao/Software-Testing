/***********************************************************************
 * Module:  EndEvent.java
 * Author:  邵闫利
 * Purpose: Defines the Class EndEvent
 ***********************************************************************/

package ynu.edu.module.bpmn;

import java.util.*;

/** @pdOid 6ea4e186-fa57-4ff9-8c3d-1459021bf785 */
public class EndEvent extends CommonElement {
   /** outGoing设置为null，name设置为end
    * 
    * 
    * @param id 
    * @param inComing
    * @pdOid 89b59190-2baa-43fe-a33c-af4d7a7b79ba */
   public EndEvent(String id, String inComing) {
    super.id = id;
    super.name = "end";
    super.inComing = inComing;
    super.outGoing = null;
   }
   
   /** @pdOid 27b6e959-348f-43ff-8023-93d1c1f7c343 */
   public String toString() {
    return "Type:"+this.getClass().getName()+"\n id: "+id+"\n inComing: "+inComing+"\n outGoing: "+outGoing+"\n name:"+name;
   }

}