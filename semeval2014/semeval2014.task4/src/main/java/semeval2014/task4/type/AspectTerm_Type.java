
/* First created by JCasGen Mon Dec 09 20:44:27 CET 2013 */
package semeval2014.task4.type;

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
 * Updated by JCasGen Mon Dec 09 21:20:57 CET 2013
 * @generated */
public class AspectTerm_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (AspectTerm_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = AspectTerm_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new AspectTerm(addr, AspectTerm_Type.this);
  			   AspectTerm_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new AspectTerm(addr, AspectTerm_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AspectTerm.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("semeval2014.task4.type.AspectTerm");
 
  /** @generated */
  final Feature casFeat_polarity;
  /** @generated */
  final int     casFeatCode_polarity;
  /** @generated */ 
  public String getPolarity(int addr) {
        if (featOkTst && casFeat_polarity == null)
      jcas.throwFeatMissing("polarity", "semeval2014.task4.type.AspectTerm");
    return ll_cas.ll_getStringValue(addr, casFeatCode_polarity);
  }
  /** @generated */    
  public void setPolarity(int addr, String v) {
        if (featOkTst && casFeat_polarity == null)
      jcas.throwFeatMissing("polarity", "semeval2014.task4.type.AspectTerm");
    ll_cas.ll_setStringValue(addr, casFeatCode_polarity, v);}
    
  
 
  /** @generated */
  final Feature casFeat_term;
  /** @generated */
  final int     casFeatCode_term;
  /** @generated */ 
  public String getTerm(int addr) {
        if (featOkTst && casFeat_term == null)
      jcas.throwFeatMissing("term", "semeval2014.task4.type.AspectTerm");
    return ll_cas.ll_getStringValue(addr, casFeatCode_term);
  }
  /** @generated */    
  public void setTerm(int addr, String v) {
        if (featOkTst && casFeat_term == null)
      jcas.throwFeatMissing("term", "semeval2014.task4.type.AspectTerm");
    ll_cas.ll_setStringValue(addr, casFeatCode_term, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public AspectTerm_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_polarity = jcas.getRequiredFeatureDE(casType, "polarity", "uima.cas.String", featOkTst);
    casFeatCode_polarity  = (null == casFeat_polarity) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_polarity).getCode();

 
    casFeat_term = jcas.getRequiredFeatureDE(casType, "term", "uima.cas.String", featOkTst);
    casFeatCode_term  = (null == casFeat_term) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_term).getCode();

  }
}



    