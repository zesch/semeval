
/* First created by JCasGen Wed Dec 18 16:13:13 CET 2013 */
package semeval2013.task7.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed Dec 18 16:13:13 CET 2013
 * @generated */
public class FacetEntailmentResult_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (FacetEntailmentResult_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = FacetEntailmentResult_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new FacetEntailmentResult(addr, FacetEntailmentResult_Type.this);
  			   FacetEntailmentResult_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new FacetEntailmentResult(addr, FacetEntailmentResult_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = FacetEntailmentResult.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("semeval2013.task7.type.FacetEntailmentResult");
 
  /** @generated */
  final Feature casFeat_result;
  /** @generated */
  final int     casFeatCode_result;
  /** @generated */ 
  public String getResult(int addr) {
        if (featOkTst && casFeat_result == null)
      jcas.throwFeatMissing("result", "semeval2013.task7.type.FacetEntailmentResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_result);
  }
  /** @generated */    
  public void setResult(int addr, String v) {
        if (featOkTst && casFeat_result == null)
      jcas.throwFeatMissing("result", "semeval2013.task7.type.FacetEntailmentResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_result, v);}
    
  
 
  /** @generated */
  final Feature casFeat_facetEntailment;
  /** @generated */
  final int     casFeatCode_facetEntailment;
  /** @generated */ 
  public int getFacetEntailment(int addr) {
        if (featOkTst && casFeat_facetEntailment == null)
      jcas.throwFeatMissing("facetEntailment", "semeval2013.task7.type.FacetEntailmentResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_facetEntailment);
  }
  /** @generated */    
  public void setFacetEntailment(int addr, int v) {
        if (featOkTst && casFeat_facetEntailment == null)
      jcas.throwFeatMissing("facetEntailment", "semeval2013.task7.type.FacetEntailmentResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_facetEntailment, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public FacetEntailmentResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_result = jcas.getRequiredFeatureDE(casType, "result", "uima.cas.String", featOkTst);
    casFeatCode_result  = (null == casFeat_result) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_result).getCode();

 
    casFeat_facetEntailment = jcas.getRequiredFeatureDE(casType, "facetEntailment", "semeval2013.task7.type.FacetEntailment", featOkTst);
    casFeatCode_facetEntailment  = (null == casFeat_facetEntailment) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_facetEntailment).getCode();

  }
}



    