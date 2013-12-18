

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
public class FacetEntailmentResult extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(FacetEntailmentResult.class);
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
  protected FacetEntailmentResult() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public FacetEntailmentResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public FacetEntailmentResult(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public FacetEntailmentResult(JCas jcas, int begin, int end) {
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
    if (FacetEntailmentResult_Type.featOkTst && ((FacetEntailmentResult_Type)jcasType).casFeat_result == null)
      jcasType.jcas.throwFeatMissing("result", "semeval2013.task7.type.FacetEntailmentResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((FacetEntailmentResult_Type)jcasType).casFeatCode_result);}
    
  /** setter for result - sets  
   * @generated */
  public void setResult(String v) {
    if (FacetEntailmentResult_Type.featOkTst && ((FacetEntailmentResult_Type)jcasType).casFeat_result == null)
      jcasType.jcas.throwFeatMissing("result", "semeval2013.task7.type.FacetEntailmentResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((FacetEntailmentResult_Type)jcasType).casFeatCode_result, v);}    
   
    
  //*--------------*
  //* Feature: facetEntailment

  /** getter for facetEntailment - gets 
   * @generated */
  public FacetEntailment getFacetEntailment() {
    if (FacetEntailmentResult_Type.featOkTst && ((FacetEntailmentResult_Type)jcasType).casFeat_facetEntailment == null)
      jcasType.jcas.throwFeatMissing("facetEntailment", "semeval2013.task7.type.FacetEntailmentResult");
    return (FacetEntailment)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((FacetEntailmentResult_Type)jcasType).casFeatCode_facetEntailment)));}
    
  /** setter for facetEntailment - sets  
   * @generated */
  public void setFacetEntailment(FacetEntailment v) {
    if (FacetEntailmentResult_Type.featOkTst && ((FacetEntailmentResult_Type)jcasType).casFeat_facetEntailment == null)
      jcasType.jcas.throwFeatMissing("facetEntailment", "semeval2013.task7.type.FacetEntailmentResult");
    jcasType.ll_cas.ll_setRefValue(addr, ((FacetEntailmentResult_Type)jcasType).casFeatCode_facetEntailment, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    