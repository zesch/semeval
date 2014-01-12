

/* First created by JCasGen Sat Jan 11 20:05:49 CET 2014 */
package semeval2012.task7.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Jan 12 11:49:07 CET 2014
 * XML source: /home/zesch/git/semeval/semeval2012/semeval2012.task7/src/main/resources/desc/type/Copa.xml
 * @generated */
public class Alternative extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Alternative.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Alternative() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Alternative(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Alternative(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Alternative(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: offset

  /** getter for offset - gets 
   * @generated */
  public String getOffset() {
    if (Alternative_Type.featOkTst && ((Alternative_Type)jcasType).casFeat_offset == null)
      jcasType.jcas.throwFeatMissing("offset", "semeval2012.task7.type.Alternative");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Alternative_Type)jcasType).casFeatCode_offset);}
    
  /** setter for offset - sets  
   * @generated */
  public void setOffset(String v) {
    if (Alternative_Type.featOkTst && ((Alternative_Type)jcasType).casFeat_offset == null)
      jcasType.jcas.throwFeatMissing("offset", "semeval2012.task7.type.Alternative");
    jcasType.ll_cas.ll_setStringValue(addr, ((Alternative_Type)jcasType).casFeatCode_offset, v);}    
  }

    