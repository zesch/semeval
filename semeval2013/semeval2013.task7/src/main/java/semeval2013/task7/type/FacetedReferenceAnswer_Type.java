
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
public class FacetedReferenceAnswer_Type extends ReferenceAnswer_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (FacetedReferenceAnswer_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = FacetedReferenceAnswer_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new FacetedReferenceAnswer(addr, FacetedReferenceAnswer_Type.this);
  			   FacetedReferenceAnswer_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new FacetedReferenceAnswer(addr, FacetedReferenceAnswer_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = FacetedReferenceAnswer.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("semeval2013.task7.type.FacetedReferenceAnswer");
 
  /** @generated */
  final Feature casFeat_Facets;
  /** @generated */
  final int     casFeatCode_Facets;
  /** @generated */ 
  public int getFacets(int addr) {
        if (featOkTst && casFeat_Facets == null)
      jcas.throwFeatMissing("Facets", "semeval2013.task7.type.FacetedReferenceAnswer");
    return ll_cas.ll_getRefValue(addr, casFeatCode_Facets);
  }
  /** @generated */    
  public void setFacets(int addr, int v) {
        if (featOkTst && casFeat_Facets == null)
      jcas.throwFeatMissing("Facets", "semeval2013.task7.type.FacetedReferenceAnswer");
    ll_cas.ll_setRefValue(addr, casFeatCode_Facets, v);}
    
   /** @generated */
  public int getFacets(int addr, int i) {
        if (featOkTst && casFeat_Facets == null)
      jcas.throwFeatMissing("Facets", "semeval2013.task7.type.FacetedReferenceAnswer");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_Facets), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_Facets), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_Facets), i);
  }
   
  /** @generated */ 
  public void setFacets(int addr, int i, int v) {
        if (featOkTst && casFeat_Facets == null)
      jcas.throwFeatMissing("Facets", "semeval2013.task7.type.FacetedReferenceAnswer");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_Facets), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_Facets), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_Facets), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public FacetedReferenceAnswer_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Facets = jcas.getRequiredFeatureDE(casType, "Facets", "uima.cas.FSArray", featOkTst);
    casFeatCode_Facets  = (null == casFeat_Facets) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Facets).getCode();

  }
}



    