

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
public class FacetEntailment extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(FacetEntailment.class);
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
  protected FacetEntailment() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public FacetEntailment(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public FacetEntailment(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public FacetEntailment(JCas jcas, int begin, int end) {
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
    if (FacetEntailment_Type.featOkTst && ((FacetEntailment_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2013.task7.type.FacetEntailment");
    return jcasType.ll_cas.ll_getStringValue(addr, ((FacetEntailment_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (FacetEntailment_Type.featOkTst && ((FacetEntailment_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2013.task7.type.FacetEntailment");
    jcasType.ll_cas.ll_setStringValue(addr, ((FacetEntailment_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: facet

  /** getter for facet - gets 
   * @generated */
  public Facet getFacet() {
    if (FacetEntailment_Type.featOkTst && ((FacetEntailment_Type)jcasType).casFeat_facet == null)
      jcasType.jcas.throwFeatMissing("facet", "semeval2013.task7.type.FacetEntailment");
    return (Facet)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((FacetEntailment_Type)jcasType).casFeatCode_facet)));}
    
  /** setter for facet - sets  
   * @generated */
  public void setFacet(Facet v) {
    if (FacetEntailment_Type.featOkTst && ((FacetEntailment_Type)jcasType).casFeat_facet == null)
      jcasType.jcas.throwFeatMissing("facet", "semeval2013.task7.type.FacetEntailment");
    jcasType.ll_cas.ll_setRefValue(addr, ((FacetEntailment_Type)jcasType).casFeatCode_facet, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: label

  /** getter for label - gets 
   * @generated */
  public String getLabel() {
    if (FacetEntailment_Type.featOkTst && ((FacetEntailment_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "semeval2013.task7.type.FacetEntailment");
    return jcasType.ll_cas.ll_getStringValue(addr, ((FacetEntailment_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets  
   * @generated */
  public void setLabel(String v) {
    if (FacetEntailment_Type.featOkTst && ((FacetEntailment_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "semeval2013.task7.type.FacetEntailment");
    jcasType.ll_cas.ll_setStringValue(addr, ((FacetEntailment_Type)jcasType).casFeatCode_label, v);}    
  }

    