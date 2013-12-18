
/* First created by JCasGen Wed Dec 18 16:14:16 CET 2013 */
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
 * Updated by JCasGen Wed Dec 18 16:14:16 CET 2013
 * @generated */
public class AssessmentResult_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (AssessmentResult_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = AssessmentResult_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new AssessmentResult(addr, AssessmentResult_Type.this);
  			   AssessmentResult_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new AssessmentResult(addr, AssessmentResult_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AssessmentResult.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("semeval2013.task7.type.AssessmentResult");
 
  /** @generated */
  final Feature casFeat_result;
  /** @generated */
  final int     casFeatCode_result;
  /** @generated */ 
  public String getResult(int addr) {
        if (featOkTst && casFeat_result == null)
      jcas.throwFeatMissing("result", "semeval2013.task7.type.AssessmentResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_result);
  }
  /** @generated */    
  public void setResult(int addr, String v) {
        if (featOkTst && casFeat_result == null)
      jcas.throwFeatMissing("result", "semeval2013.task7.type.AssessmentResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_result, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public AssessmentResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_result = jcas.getRequiredFeatureDE(casType, "result", "uima.cas.String", featOkTst);
    casFeatCode_result  = (null == casFeat_result) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_result).getCode();

  }
}



    