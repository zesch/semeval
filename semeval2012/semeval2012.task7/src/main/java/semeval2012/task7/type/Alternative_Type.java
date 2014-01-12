
/* First created by JCasGen Sat Jan 11 20:05:49 CET 2014 */
package semeval2012.task7.type;

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
 * Updated by JCasGen Sun Jan 12 11:49:07 CET 2014
 * @generated */
public class Alternative_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Alternative_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Alternative_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Alternative(addr, Alternative_Type.this);
  			   Alternative_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Alternative(addr, Alternative_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Alternative.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("semeval2012.task7.type.Alternative");
 
  /** @generated */
  final Feature casFeat_offset;
  /** @generated */
  final int     casFeatCode_offset;
  /** @generated */ 
  public String getOffset(int addr) {
        if (featOkTst && casFeat_offset == null)
      jcas.throwFeatMissing("offset", "semeval2012.task7.type.Alternative");
    return ll_cas.ll_getStringValue(addr, casFeatCode_offset);
  }
  /** @generated */    
  public void setOffset(int addr, String v) {
        if (featOkTst && casFeat_offset == null)
      jcas.throwFeatMissing("offset", "semeval2012.task7.type.Alternative");
    ll_cas.ll_setStringValue(addr, casFeatCode_offset, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Alternative_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_offset = jcas.getRequiredFeatureDE(casType, "offset", "uima.cas.String", featOkTst);
    casFeatCode_offset  = (null == casFeat_offset) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_offset).getCode();

  }
}



    