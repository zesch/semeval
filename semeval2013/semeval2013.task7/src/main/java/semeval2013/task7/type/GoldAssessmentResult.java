

/* First created by JCasGen Wed Dec 18 16:14:16 CET 2013 */
package semeval2013.task7.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Dec 18 16:14:16 CET 2013
 * XML source: /home/zesch/git/semeval/semeval2013/semeval2013.task7/src/main/resources/desc/type/AssessmentTypes.xml
 * @generated */
public class GoldAssessmentResult extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GoldAssessmentResult.class);
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
  protected GoldAssessmentResult() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public GoldAssessmentResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public GoldAssessmentResult(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public GoldAssessmentResult(JCas jcas, int begin, int end) {
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
  //* Feature: result

  /** getter for result - gets 
   * @generated */
  public String getResult() {
    if (GoldAssessmentResult_Type.featOkTst && ((GoldAssessmentResult_Type)jcasType).casFeat_result == null)
      jcasType.jcas.throwFeatMissing("result", "semeval2013.task7.type.GoldAssessmentResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GoldAssessmentResult_Type)jcasType).casFeatCode_result);}
    
  /** setter for result - sets  
   * @generated */
  public void setResult(String v) {
    if (GoldAssessmentResult_Type.featOkTst && ((GoldAssessmentResult_Type)jcasType).casFeat_result == null)
      jcasType.jcas.throwFeatMissing("result", "semeval2013.task7.type.GoldAssessmentResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((GoldAssessmentResult_Type)jcasType).casFeatCode_result, v);}    
  }

    