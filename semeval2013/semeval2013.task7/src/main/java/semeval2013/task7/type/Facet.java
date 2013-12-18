

/* First created by JCasGen Wed Dec 18 16:13:13 CET 2013 */
package semeval2013.task7.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Dec 18 16:13:13 CET 2013
 * XML source: /home/zesch/git/semeval/semeval2013/semeval2013.task7/src/main/resources/desc/type/StudentAssessmentTypes.xml
 * @generated */
public class Facet extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Facet.class);
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
  protected Facet() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Facet(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Facet(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Facet(JCas jcas, int begin, int end) {
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
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public String getId() {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2013.task7.type.Facet");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Facet_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2013.task7.type.Facet");
    jcasType.ll_cas.ll_setStringValue(addr, ((Facet_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: term1Num

  /** getter for term1Num - gets 
   * @generated */
  public String getTerm1Num() {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_term1Num == null)
      jcasType.jcas.throwFeatMissing("term1Num", "semeval2013.task7.type.Facet");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Facet_Type)jcasType).casFeatCode_term1Num);}
    
  /** setter for term1Num - sets  
   * @generated */
  public void setTerm1Num(String v) {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_term1Num == null)
      jcasType.jcas.throwFeatMissing("term1Num", "semeval2013.task7.type.Facet");
    jcasType.ll_cas.ll_setStringValue(addr, ((Facet_Type)jcasType).casFeatCode_term1Num, v);}    
   
    
  //*--------------*
  //* Feature: term1Text

  /** getter for term1Text - gets 
   * @generated */
  public String getTerm1Text() {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_term1Text == null)
      jcasType.jcas.throwFeatMissing("term1Text", "semeval2013.task7.type.Facet");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Facet_Type)jcasType).casFeatCode_term1Text);}
    
  /** setter for term1Text - sets  
   * @generated */
  public void setTerm1Text(String v) {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_term1Text == null)
      jcasType.jcas.throwFeatMissing("term1Text", "semeval2013.task7.type.Facet");
    jcasType.ll_cas.ll_setStringValue(addr, ((Facet_Type)jcasType).casFeatCode_term1Text, v);}    
   
    
  //*--------------*
  //* Feature: term2Num

  /** getter for term2Num - gets 
   * @generated */
  public String getTerm2Num() {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_term2Num == null)
      jcasType.jcas.throwFeatMissing("term2Num", "semeval2013.task7.type.Facet");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Facet_Type)jcasType).casFeatCode_term2Num);}
    
  /** setter for term2Num - sets  
   * @generated */
  public void setTerm2Num(String v) {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_term2Num == null)
      jcasType.jcas.throwFeatMissing("term2Num", "semeval2013.task7.type.Facet");
    jcasType.ll_cas.ll_setStringValue(addr, ((Facet_Type)jcasType).casFeatCode_term2Num, v);}    
   
    
  //*--------------*
  //* Feature: term2Text

  /** getter for term2Text - gets 
   * @generated */
  public String getTerm2Text() {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_term2Text == null)
      jcasType.jcas.throwFeatMissing("term2Text", "semeval2013.task7.type.Facet");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Facet_Type)jcasType).casFeatCode_term2Text);}
    
  /** setter for term2Text - sets  
   * @generated */
  public void setTerm2Text(String v) {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_term2Text == null)
      jcasType.jcas.throwFeatMissing("term2Text", "semeval2013.task7.type.Facet");
    jcasType.ll_cas.ll_setStringValue(addr, ((Facet_Type)jcasType).casFeatCode_term2Text, v);}    
   
    
  //*--------------*
  //* Feature: isAssumed

  /** getter for isAssumed - gets 
   * @generated */
  public boolean getIsAssumed() {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_isAssumed == null)
      jcasType.jcas.throwFeatMissing("isAssumed", "semeval2013.task7.type.Facet");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Facet_Type)jcasType).casFeatCode_isAssumed);}
    
  /** setter for isAssumed - sets  
   * @generated */
  public void setIsAssumed(boolean v) {
    if (Facet_Type.featOkTst && ((Facet_Type)jcasType).casFeat_isAssumed == null)
      jcasType.jcas.throwFeatMissing("isAssumed", "semeval2013.task7.type.Facet");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Facet_Type)jcasType).casFeatCode_isAssumed, v);}    
  }

    