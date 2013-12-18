

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
public class Question extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Question.class);
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
  protected Question() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Question(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Question(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Question(JCas jcas, int begin, int end) {
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
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2013.task7.type.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2013.task7.type.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: module

  /** getter for module - gets 
   * @generated */
  public String getModule() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_module == null)
      jcasType.jcas.throwFeatMissing("module", "semeval2013.task7.type.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_module);}
    
  /** setter for module - sets  
   * @generated */
  public void setModule(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_module == null)
      jcasType.jcas.throwFeatMissing("module", "semeval2013.task7.type.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_module, v);}    
   
    
  //*--------------*
  //* Feature: style

  /** getter for style - gets 
   * @generated */
  public String getStyle() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_style == null)
      jcasType.jcas.throwFeatMissing("style", "semeval2013.task7.type.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_style);}
    
  /** setter for style - sets  
   * @generated */
  public void setStyle(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_style == null)
      jcasType.jcas.throwFeatMissing("style", "semeval2013.task7.type.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_style, v);}    
   
    
  //*--------------*
  //* Feature: qtype

  /** getter for qtype - gets 
   * @generated */
  public String getQtype() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_qtype == null)
      jcasType.jcas.throwFeatMissing("qtype", "semeval2013.task7.type.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_qtype);}
    
  /** setter for qtype - sets  
   * @generated */
  public void setQtype(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_qtype == null)
      jcasType.jcas.throwFeatMissing("qtype", "semeval2013.task7.type.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_qtype, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets 
   * @generated */
  public String getText() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "semeval2013.task7.type.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets  
   * @generated */
  public void setText(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "semeval2013.task7.type.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_text, v);}    
  }

    