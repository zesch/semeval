

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
public class FacetedReferenceAnswer extends ReferenceAnswer {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(FacetedReferenceAnswer.class);
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
  protected FacetedReferenceAnswer() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public FacetedReferenceAnswer(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public FacetedReferenceAnswer(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public FacetedReferenceAnswer(JCas jcas, int begin, int end) {
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
  //* Feature: Facets

  /** getter for Facets - gets 
   * @generated */
  public FSArray getFacets() {
    if (FacetedReferenceAnswer_Type.featOkTst && ((FacetedReferenceAnswer_Type)jcasType).casFeat_Facets == null)
      jcasType.jcas.throwFeatMissing("Facets", "semeval2013.task7.type.FacetedReferenceAnswer");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((FacetedReferenceAnswer_Type)jcasType).casFeatCode_Facets)));}
    
  /** setter for Facets - sets  
   * @generated */
  public void setFacets(FSArray v) {
    if (FacetedReferenceAnswer_Type.featOkTst && ((FacetedReferenceAnswer_Type)jcasType).casFeat_Facets == null)
      jcasType.jcas.throwFeatMissing("Facets", "semeval2013.task7.type.FacetedReferenceAnswer");
    jcasType.ll_cas.ll_setRefValue(addr, ((FacetedReferenceAnswer_Type)jcasType).casFeatCode_Facets, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for Facets - gets an indexed value - 
   * @generated */
  public Facet getFacets(int i) {
    if (FacetedReferenceAnswer_Type.featOkTst && ((FacetedReferenceAnswer_Type)jcasType).casFeat_Facets == null)
      jcasType.jcas.throwFeatMissing("Facets", "semeval2013.task7.type.FacetedReferenceAnswer");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((FacetedReferenceAnswer_Type)jcasType).casFeatCode_Facets), i);
    return (Facet)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((FacetedReferenceAnswer_Type)jcasType).casFeatCode_Facets), i)));}

  /** indexed setter for Facets - sets an indexed value - 
   * @generated */
  public void setFacets(int i, Facet v) { 
    if (FacetedReferenceAnswer_Type.featOkTst && ((FacetedReferenceAnswer_Type)jcasType).casFeat_Facets == null)
      jcasType.jcas.throwFeatMissing("Facets", "semeval2013.task7.type.FacetedReferenceAnswer");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((FacetedReferenceAnswer_Type)jcasType).casFeatCode_Facets), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((FacetedReferenceAnswer_Type)jcasType).casFeatCode_Facets), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    