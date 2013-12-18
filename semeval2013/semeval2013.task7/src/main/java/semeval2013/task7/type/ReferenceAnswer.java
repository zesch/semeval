

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
public class ReferenceAnswer extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ReferenceAnswer.class);
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
  protected ReferenceAnswer() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public ReferenceAnswer(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ReferenceAnswer(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public ReferenceAnswer(JCas jcas, int begin, int end) {
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
    if (ReferenceAnswer_Type.featOkTst && ((ReferenceAnswer_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2013.task7.type.ReferenceAnswer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ReferenceAnswer_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (ReferenceAnswer_Type.featOkTst && ((ReferenceAnswer_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2013.task7.type.ReferenceAnswer");
    jcasType.ll_cas.ll_setStringValue(addr, ((ReferenceAnswer_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: fileId

  /** getter for fileId - gets 
   * @generated */
  public String getFileId() {
    if (ReferenceAnswer_Type.featOkTst && ((ReferenceAnswer_Type)jcasType).casFeat_fileId == null)
      jcasType.jcas.throwFeatMissing("fileId", "semeval2013.task7.type.ReferenceAnswer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ReferenceAnswer_Type)jcasType).casFeatCode_fileId);}
    
  /** setter for fileId - sets  
   * @generated */
  public void setFileId(String v) {
    if (ReferenceAnswer_Type.featOkTst && ((ReferenceAnswer_Type)jcasType).casFeat_fileId == null)
      jcasType.jcas.throwFeatMissing("fileId", "semeval2013.task7.type.ReferenceAnswer");
    jcasType.ll_cas.ll_setStringValue(addr, ((ReferenceAnswer_Type)jcasType).casFeatCode_fileId, v);}    
   
    
  //*--------------*
  //* Feature: category

  /** getter for category - gets 
   * @generated */
  public String getCategory() {
    if (ReferenceAnswer_Type.featOkTst && ((ReferenceAnswer_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "semeval2013.task7.type.ReferenceAnswer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ReferenceAnswer_Type)jcasType).casFeatCode_category);}
    
  /** setter for category - sets  
   * @generated */
  public void setCategory(String v) {
    if (ReferenceAnswer_Type.featOkTst && ((ReferenceAnswer_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "semeval2013.task7.type.ReferenceAnswer");
    jcasType.ll_cas.ll_setStringValue(addr, ((ReferenceAnswer_Type)jcasType).casFeatCode_category, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets 
   * @generated */
  public String getText() {
    if (ReferenceAnswer_Type.featOkTst && ((ReferenceAnswer_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "semeval2013.task7.type.ReferenceAnswer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ReferenceAnswer_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets  
   * @generated */
  public void setText(String v) {
    if (ReferenceAnswer_Type.featOkTst && ((ReferenceAnswer_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "semeval2013.task7.type.ReferenceAnswer");
    jcasType.ll_cas.ll_setStringValue(addr, ((ReferenceAnswer_Type)jcasType).casFeatCode_text, v);}    
  }

    