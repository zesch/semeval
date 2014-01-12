
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
public class Statement_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Statement_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Statement_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Statement(addr, Statement_Type.this);
  			   Statement_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Statement(addr, Statement_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Statement.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("semeval2012.task7.type.Statement");



  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated */ 
  public String getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "semeval2012.task7.type.Statement");
    return ll_cas.ll_getStringValue(addr, casFeatCode_id);
  }
  /** @generated */    
  public void setId(int addr, String v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "semeval2012.task7.type.Statement");
    ll_cas.ll_setStringValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_asksFor;
  /** @generated */
  final int     casFeatCode_asksFor;
  /** @generated */ 
  public String getAsksFor(int addr) {
        if (featOkTst && casFeat_asksFor == null)
      jcas.throwFeatMissing("asksFor", "semeval2012.task7.type.Statement");
    return ll_cas.ll_getStringValue(addr, casFeatCode_asksFor);
  }
  /** @generated */    
  public void setAsksFor(int addr, String v) {
        if (featOkTst && casFeat_asksFor == null)
      jcas.throwFeatMissing("asksFor", "semeval2012.task7.type.Statement");
    ll_cas.ll_setStringValue(addr, casFeatCode_asksFor, v);}
    
  
 
  /** @generated */
  final Feature casFeat_mostPlausibleAlternative;
  /** @generated */
  final int     casFeatCode_mostPlausibleAlternative;
  /** @generated */ 
  public String getMostPlausibleAlternative(int addr) {
        if (featOkTst && casFeat_mostPlausibleAlternative == null)
      jcas.throwFeatMissing("mostPlausibleAlternative", "semeval2012.task7.type.Statement");
    return ll_cas.ll_getStringValue(addr, casFeatCode_mostPlausibleAlternative);
  }
  /** @generated */    
  public void setMostPlausibleAlternative(int addr, String v) {
        if (featOkTst && casFeat_mostPlausibleAlternative == null)
      jcas.throwFeatMissing("mostPlausibleAlternative", "semeval2012.task7.type.Statement");
    ll_cas.ll_setStringValue(addr, casFeatCode_mostPlausibleAlternative, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Statement_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.String", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_asksFor = jcas.getRequiredFeatureDE(casType, "asksFor", "uima.cas.String", featOkTst);
    casFeatCode_asksFor  = (null == casFeat_asksFor) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_asksFor).getCode();

 
    casFeat_mostPlausibleAlternative = jcas.getRequiredFeatureDE(casType, "mostPlausibleAlternative", "uima.cas.String", featOkTst);
    casFeatCode_mostPlausibleAlternative  = (null == casFeat_mostPlausibleAlternative) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mostPlausibleAlternative).getCode();

  }
}



    