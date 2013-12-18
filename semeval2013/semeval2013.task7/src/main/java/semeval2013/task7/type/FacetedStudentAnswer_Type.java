
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

/** 
 * Updated by JCasGen Wed Dec 18 16:13:13 CET 2013
 * @generated */
public class FacetedStudentAnswer_Type extends StudentAnswer_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (FacetedStudentAnswer_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = FacetedStudentAnswer_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new FacetedStudentAnswer(addr, FacetedStudentAnswer_Type.this);
  			   FacetedStudentAnswer_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new FacetedStudentAnswer(addr, FacetedStudentAnswer_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = FacetedStudentAnswer.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("semeval2013.task7.type.FacetedStudentAnswer");
 
  /** @generated */
  final Feature casFeat_FacetEntailments;
  /** @generated */
  final int     casFeatCode_FacetEntailments;
  /** @generated */ 
  public int getFacetEntailments(int addr) {
        if (featOkTst && casFeat_FacetEntailments == null)
      jcas.throwFeatMissing("FacetEntailments", "semeval2013.task7.type.FacetedStudentAnswer");
    return ll_cas.ll_getRefValue(addr, casFeatCode_FacetEntailments);
  }
  /** @generated */    
  public void setFacetEntailments(int addr, int v) {
        if (featOkTst && casFeat_FacetEntailments == null)
      jcas.throwFeatMissing("FacetEntailments", "semeval2013.task7.type.FacetedStudentAnswer");
    ll_cas.ll_setRefValue(addr, casFeatCode_FacetEntailments, v);}
    
   /** @generated */
  public int getFacetEntailments(int addr, int i) {
        if (featOkTst && casFeat_FacetEntailments == null)
      jcas.throwFeatMissing("FacetEntailments", "semeval2013.task7.type.FacetedStudentAnswer");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_FacetEntailments), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_FacetEntailments), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_FacetEntailments), i);
  }
   
  /** @generated */ 
  public void setFacetEntailments(int addr, int i, int v) {
        if (featOkTst && casFeat_FacetEntailments == null)
      jcas.throwFeatMissing("FacetEntailments", "semeval2013.task7.type.FacetedStudentAnswer");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_FacetEntailments), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_FacetEntailments), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_FacetEntailments), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public FacetedStudentAnswer_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_FacetEntailments = jcas.getRequiredFeatureDE(casType, "FacetEntailments", "uima.cas.FSArray", featOkTst);
    casFeatCode_FacetEntailments  = (null == casFeat_FacetEntailments) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_FacetEntailments).getCode();

  }
}



    