

/* First created by JCasGen Mon Dec 09 20:44:27 CET 2013 */
package semeval2014.task4.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Dec 09 21:20:57 CET 2013
 * XML source: /home/zesch/git/semeval/semeval2014/semeval2014.task4/src/main/resources/desc/type/AspectTypes.xml
 * @generated */
public class AspectCategory extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(AspectCategory.class);
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
  protected AspectCategory() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public AspectCategory(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public AspectCategory(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public AspectCategory(JCas jcas, int begin, int end) {
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
  //* Feature: polarity

  /** getter for polarity - gets 
   * @generated */
  public String getPolarity() {
    if (AspectCategory_Type.featOkTst && ((AspectCategory_Type)jcasType).casFeat_polarity == null)
      jcasType.jcas.throwFeatMissing("polarity", "semeval2014.task4.type.AspectCategory");
    return jcasType.ll_cas.ll_getStringValue(addr, ((AspectCategory_Type)jcasType).casFeatCode_polarity);}
    
  /** setter for polarity - sets  
   * @generated */
  public void setPolarity(String v) {
    if (AspectCategory_Type.featOkTst && ((AspectCategory_Type)jcasType).casFeat_polarity == null)
      jcasType.jcas.throwFeatMissing("polarity", "semeval2014.task4.type.AspectCategory");
    jcasType.ll_cas.ll_setStringValue(addr, ((AspectCategory_Type)jcasType).casFeatCode_polarity, v);}    
   
    
  //*--------------*
  //* Feature: category

  /** getter for category - gets 
   * @generated */
  public String getCategory() {
    if (AspectCategory_Type.featOkTst && ((AspectCategory_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "semeval2014.task4.type.AspectCategory");
    return jcasType.ll_cas.ll_getStringValue(addr, ((AspectCategory_Type)jcasType).casFeatCode_category);}
    
  /** setter for category - sets  
   * @generated */
  public void setCategory(String v) {
    if (AspectCategory_Type.featOkTst && ((AspectCategory_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "semeval2014.task4.type.AspectCategory");
    jcasType.ll_cas.ll_setStringValue(addr, ((AspectCategory_Type)jcasType).casFeatCode_category, v);}    
  }

    