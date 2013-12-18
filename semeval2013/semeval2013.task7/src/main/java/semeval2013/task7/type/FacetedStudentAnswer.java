

/* First created by JCasGen Wed Dec 18 16:13:13 CET 2013 */
package semeval2013.task7.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


/** 
 * Updated by JCasGen Wed Dec 18 16:13:13 CET 2013
 * XML source: /home/zesch/git/semeval/semeval2013/semeval2013.task7/src/main/resources/desc/type/StudentAssessmentTypes.xml
 * @generated */
public class FacetedStudentAnswer extends StudentAnswer {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(FacetedStudentAnswer.class);
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
  protected FacetedStudentAnswer() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public FacetedStudentAnswer(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public FacetedStudentAnswer(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public FacetedStudentAnswer(JCas jcas, int begin, int end) {
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
  //* Feature: FacetEntailments

  /** getter for FacetEntailments - gets 
   * @generated */
  public FSArray getFacetEntailments() {
    if (FacetedStudentAnswer_Type.featOkTst && ((FacetedStudentAnswer_Type)jcasType).casFeat_FacetEntailments == null)
      jcasType.jcas.throwFeatMissing("FacetEntailments", "semeval2013.task7.type.FacetedStudentAnswer");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((FacetedStudentAnswer_Type)jcasType).casFeatCode_FacetEntailments)));}
    
  /** setter for FacetEntailments - sets  
   * @generated */
  public void setFacetEntailments(FSArray v) {
    if (FacetedStudentAnswer_Type.featOkTst && ((FacetedStudentAnswer_Type)jcasType).casFeat_FacetEntailments == null)
      jcasType.jcas.throwFeatMissing("FacetEntailments", "semeval2013.task7.type.FacetedStudentAnswer");
    jcasType.ll_cas.ll_setRefValue(addr, ((FacetedStudentAnswer_Type)jcasType).casFeatCode_FacetEntailments, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for FacetEntailments - gets an indexed value - 
   * @generated */
  public FacetEntailment getFacetEntailments(int i) {
    if (FacetedStudentAnswer_Type.featOkTst && ((FacetedStudentAnswer_Type)jcasType).casFeat_FacetEntailments == null)
      jcasType.jcas.throwFeatMissing("FacetEntailments", "semeval2013.task7.type.FacetedStudentAnswer");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((FacetedStudentAnswer_Type)jcasType).casFeatCode_FacetEntailments), i);
    return (FacetEntailment)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((FacetedStudentAnswer_Type)jcasType).casFeatCode_FacetEntailments), i)));}

  /** indexed setter for FacetEntailments - sets an indexed value - 
   * @generated */
  public void setFacetEntailments(int i, FacetEntailment v) { 
    if (FacetedStudentAnswer_Type.featOkTst && ((FacetedStudentAnswer_Type)jcasType).casFeat_FacetEntailments == null)
      jcasType.jcas.throwFeatMissing("FacetEntailments", "semeval2013.task7.type.FacetedStudentAnswer");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((FacetedStudentAnswer_Type)jcasType).casFeatCode_FacetEntailments), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((FacetedStudentAnswer_Type)jcasType).casFeatCode_FacetEntailments), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    