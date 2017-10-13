/***********************************************************************
 * Module:  BPMNData.java
 * Author:  邵闫利
 * Purpose: Defines the Class BPMNData
 ***********************************************************************/

package ynu.edu.data.BPMN;

import ynu.edu.module.bpmn.BpmnElement;
import java.util.*;
import java.util.Map.Entry;

/**  * 采用哈希表加链表的方式存储一个BPMN图，该数据结构中只存储信息，不表示连接关系。
 *  * 哈希表以一个String为键，以一个链表为值。
 *  * 该String表示链表中存取的BPMN元素的种类，链表用于存储该类元素的相关信息。
 *  *
 * 
 * 
 * 
 * @pdOid 5be8a203-436e-4511-ab03-13cc37cd2791 */
public class BPMNData <T> {
   /** @pdOid 78fdaf8d-beb9-4d10-9769-3059b540daec */
   private Hashtable<String, LinkedList<T>> data;
   
   /** @pdOid 581e12b1-a0e3-4082-b44a-4cbafeafad52 */
   public BPMNData() {
    data = new Hashtable();
   }
   
   /** @param name
    * @pdOid e65a0319-6171-43e2-9251-05d16ee2fca6 */
   public boolean addBPMNHead(String name) {
      // TODO: implement
      return false;
   }
   
   /** 用于将BPMN元素存入该数据结构中。
    * 
    * 
    * @param Element 
    * @param BPMNElement 
    * @param BPMBElement
    * @pdOid 2560f3e7-9c19-4e55-a959-61bdde9a69c2 */
   public boolean addBPMNElement(T Element) {
      
    String name = Element.getClass().getName();
    if(data.containsKey(name)) 
    {
     LinkedList<T> dataInner = data.get(name); 
     if(!dataInner.contains(Element)) 
     {
      return dataInner.add(Element);
     }
     else 
     {
      return false;
     }
    }
    else 
    {
     LinkedList<T> dataInner = new LinkedList<>();
     data.put(name, dataInner);
     dataInner.add(Element);
     return true;
    }
   }
   
   /** @pdOid d8b5ac42-9cf9-40ca-be53-ba40b6065a47 */
   public String toString() {
      StringBuilder sb = new StringBuilder();
      for(Entry<String, LinkedList<T>> e:data.entrySet()) 
      {
   	   sb.append(e.getKey()+" : \n");
   	   for(T bpmnElement:e.getValue()) 
   	   {
   		   sb.append(bpmnElement.toString()+"\n");
   	   }
      }
   return sb.toString();
      
     }
   
   /** @pdOid e3cddbb7-cdb5-469a-8d62-79c3d8494e42 */
   public Hashtable<String, LinkedList<T>> getData() {
   	return (Hashtable<String, LinkedList<T>>) data.clone();
   }

}