

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
public class StudentAnswer extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(StudentAnswer.class);
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
  protected StudentAnswer() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public StudentAnswer(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public StudentAnswer(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public StudentAnswer(JCas jcas, int begin, int end) {
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
    if (StudentAnswer_Type.featOkTst && ((StudentAnswer_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2013.task7.type.StudentAnswer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StudentAnswer_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (StudentAnswer_Type.featOkTst && ((StudentAnswer_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2013.task7.type.StudentAnswer");
    jcasType.ll_cas.ll_setStringValue(addr, ((StudentAnswer_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: count

  /** getter for count - gets 
   * @generated */
  public int getCount() {
    if (StudentAnswer_Type.featOkTst && ((StudentAnswer_Type)jcasType).casFeat_count == null)
      jcasType.jcas.throwFeatMissing("count", "semeval2013.task7.type.StudentAnswer");
    return jcasType.ll_cas.ll_getIntValue(addr, ((StudentAnswer_Type)jcasType).casFeatCode_count);}
    
  /** setter for count - sets  
   * @generated */
  public void setCount(int v) {
    if (StudentAnswer_Type.featOkTst && ((StudentAnswer_Type)jcasType).casFeat_count == null)
      jcasType.jcas.throwFeatMissing("count", "semeval2013.task7.type.StudentAnswer");
    jcasType.ll_cas.ll_setIntValue(addr, ((StudentAnswer_Type)jcasType).casFeatCode_count, v);}    
   
    
  //*--------------*
  //* Feature: answerMatch

  /** getter for answerMatch - gets 
   * @generated */
  public ReferenceAnswer getAnswerMatch() {
    if (StudentAnswer_Type.featOkTst && ((StudentAnswer_Type)jcasType).casFeat_answerMatch == null)
      jcasType.jcas.throwFeatMissing("answerMatch", "semeval2013.task7.type.StudentAnswer");
    return (ReferenceAnswer)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((StudentAnswer_Type)jcasType).casFeatCode_answerMatch)));}
    
  /** setter for answerMatch - sets  
   * @generated */
  public void setAnswerMatch(ReferenceAnswer v) {
    if (StudentAnswer_Type.featOkTst && ((StudentAnswer_Type)jcasType).casFeat_answerMatch == null)
      jcasType.jcas.throwFeatMissing("answerMatch", "semeval2013.task7.type.StudentAnswer");
    jcasType.ll_cas.ll_setRefValue(addr, ((StudentAnswer_Type)jcasType).casFeatCode_answerMatch, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: label

  /** getter for label - gets 
   * @generated */
  public String getLabel() {
    if (StudentAnswer_Type.featOkTst && ((StudentAnswer_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "semeval2013.task7.type.StudentAnswer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StudentAnswer_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets  
   * @generated */
  public void setLabel(String v) {
    if (StudentAnswer_Type.featOkTst && ((StudentAnswer_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "semeval2013.task7.type.StudentAnswer");
    jcasType.ll_cas.ll_setStringValue(addr, ((StudentAnswer_Type)jcasType).casFeatCode_label, v);}    
  }

    