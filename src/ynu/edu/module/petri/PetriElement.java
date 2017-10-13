/***********************************************************************
 * Module:  PetriElement.java
 * Author:  邵闫利
 * Purpose: Defines the Class PetriElement
 ***********************************************************************/

package ynu.edu.module.petri;

import java.util.*;
import ynu.edu.data.GNode;

/** @pdOid 320bae5c-7fcf-4f9f-a340-0dd3d3dd1c56 */
public abstract class PetriElement extends ynu.edu.data.GNode {
   /** @pdOid e307a2b3-a398-48e7-818c-e5947c060634 */
   
   /** @pdOid 8658a991-af67-461b-9941-fd1a7dfd5f7d */
   public String getId() {
      return id;
   }
   
   /** @param newId
    * @pdOid cb1685ba-f2f5-462e-beec-79c51f284dff */
   public void setId(String newId) {
      id = newId;
   }

}