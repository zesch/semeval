
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
public class Facet_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Facet_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Facet_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Facet(addr, Facet_Type.this);
  			   Facet_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Facet(addr, Facet_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Facet.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("semeval2013.task7.type.Facet");
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated */ 
  public String getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "semeval2013.task7.type.Facet");
    return ll_cas.ll_getStringValue(addr, casFeatCode_id);
  }
  /** @generated */    
  public void setId(int addr, String v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "semeval2013.task7.type.Facet");
    ll_cas.ll_setStringValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_term1Num;
  /** @generated */
  final int     casFeatCode_term1Num;
  /** @generated */ 
  public String getTerm1Num(int addr) {
        if (featOkTst && casFeat_term1Num == null)
      jcas.throwFeatMissing("term1Num", "semeval2013.task7.type.Facet");
    return ll_cas.ll_getStringValue(addr, casFeatCode_term1Num);
  }
  /** @generated */    
  public void setTerm1Num(int addr, String v) {
        if (featOkTst && casFeat_term1Num == null)
      jcas.throwFeatMissing("term1Num", "semeval2013.task7.type.Facet");
    ll_cas.ll_setStringValue(addr, casFeatCode_term1Num, v);}
    
  
 
  /** @generated */
  final Feature casFeat_term1Text;
  /** @generated */
  final int     casFeatCode_term1Text;
  /** @generated */ 
  public String getTerm1Text(int addr) {
        if (featOkTst && casFeat_term1Text == null)
      jcas.throwFeatMissing("term1Text", "semeval2013.task7.type.Facet");
    return ll_cas.ll_getStringValue(addr, casFeatCode_term1Text);
  }
  /** @generated */    
  public void setTerm1Text(int addr, String v) {
        if (featOkTst && casFeat_term1Text == null)
      jcas.throwFeatMissing("term1Text", "semeval2013.task7.type.Facet");
    ll_cas.ll_setStringValue(addr, casFeatCode_term1Text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_term2Num;
  /** @generated */
  final int     casFeatCode_term2Num;
  /** @generated */ 
  public String getTerm2Num(int addr) {
        if (featOkTst && casFeat_term2Num == null)
      jcas.throwFeatMissing("term2Num", "semeval2013.task7.type.Facet");
    return ll_cas.ll_getStringValue(addr, casFeatCode_term2Num);
  }
  /** @generated */    
  public void setTerm2Num(int addr, String v) {
        if (featOkTst && casFeat_term2Num == null)
      jcas.throwFeatMissing("term2Num", "semeval2013.task7.type.Facet");
    ll_cas.ll_setStringValue(addr, casFeatCode_term2Num, v);}
    
  
 
  /** @generated */
  final Feature casFeat_term2Text;
  /** @generated */
  final int     casFeatCode_term2Text;
  /** @generated */ 
  public String getTerm2Text(int addr) {
        if (featOkTst && casFeat_term2Text == null)
      jcas.throwFeatMissing("term2Text", "semeval2013.task7.type.Facet");
    return ll_cas.ll_getStringValue(addr, casFeatCode_term2Text);
  }
  /** @generated */    
  public void setTerm2Text(int addr, String v) {
        if (featOkTst && casFeat_term2Text == null)
      jcas.throwFeatMissing("term2Text", "semeval2013.task7.type.Facet");
    ll_cas.ll_setStringValue(addr, casFeatCode_term2Text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_isAssumed;
  /** @generated */
  final int     casFeatCode_isAssumed;
  /** @generated */ 
  public boolean getIsAssumed(int addr) {
        if (featOkTst && casFeat_isAssumed == null)
      jcas.throwFeatMissing("isAssumed", "semeval2013.task7.type.Facet");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_isAssumed);
  }
  /** @generated */    
  public void setIsAssumed(int addr, boolean v) {
        if (featOkTst && casFeat_isAssumed == null)
      jcas.throwFeatMissing("isAssumed", "semeval2013.task7.type.Facet");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_isAssumed, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Facet_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.String", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_term1Num = jcas.getRequiredFeatureDE(casType, "term1Num", "uima.cas.String", featOkTst);
    casFeatCode_term1Num  = (null == casFeat_term1Num) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_term1Num).getCode();

 
    casFeat_term1Text = jcas.getRequiredFeatureDE(casType, "term1Text", "uima.cas.String", featOkTst);
    casFeatCode_term1Text  = (null == casFeat_term1Text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_term1Text).getCode();

 
    casFeat_term2Num = jcas.getRequiredFeatureDE(casType, "term2Num", "uima.cas.String", featOkTst);
    casFeatCode_term2Num  = (null == casFeat_term2Num) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_term2Num).getCode();

 
    casFeat_term2Text = jcas.getRequiredFeatureDE(casType, "term2Text", "uima.cas.String", featOkTst);
    casFeatCode_term2Text  = (null == casFeat_term2Text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_term2Text).getCode();

 
    casFeat_isAssumed = jcas.getRequiredFeatureDE(casType, "isAssumed", "uima.cas.Boolean", featOkTst);
    casFeatCode_isAssumed  = (null == casFeat_isAssumed) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_isAssumed).getCode();

  }
}



    