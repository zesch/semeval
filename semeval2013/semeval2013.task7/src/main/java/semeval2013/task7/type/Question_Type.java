
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
public class Question_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Question_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Question_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Question(addr, Question_Type.this);
  			   Question_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Question(addr, Question_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Question.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("semeval2013.task7.type.Question");
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated */ 
  public String getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "semeval2013.task7.type.Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_id);
  }
  /** @generated */    
  public void setId(int addr, String v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "semeval2013.task7.type.Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_module;
  /** @generated */
  final int     casFeatCode_module;
  /** @generated */ 
  public String getModule(int addr) {
        if (featOkTst && casFeat_module == null)
      jcas.throwFeatMissing("module", "semeval2013.task7.type.Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_module);
  }
  /** @generated */    
  public void setModule(int addr, String v) {
        if (featOkTst && casFeat_module == null)
      jcas.throwFeatMissing("module", "semeval2013.task7.type.Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_module, v);}
    
  
 
  /** @generated */
  final Feature casFeat_style;
  /** @generated */
  final int     casFeatCode_style;
  /** @generated */ 
  public String getStyle(int addr) {
        if (featOkTst && casFeat_style == null)
      jcas.throwFeatMissing("style", "semeval2013.task7.type.Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_style);
  }
  /** @generated */    
  public void setStyle(int addr, String v) {
        if (featOkTst && casFeat_style == null)
      jcas.throwFeatMissing("style", "semeval2013.task7.type.Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_style, v);}
    
  
 
  /** @generated */
  final Feature casFeat_qtype;
  /** @generated */
  final int     casFeatCode_qtype;
  /** @generated */ 
  public String getQtype(int addr) {
        if (featOkTst && casFeat_qtype == null)
      jcas.throwFeatMissing("qtype", "semeval2013.task7.type.Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_qtype);
  }
  /** @generated */    
  public void setQtype(int addr, String v) {
        if (featOkTst && casFeat_qtype == null)
      jcas.throwFeatMissing("qtype", "semeval2013.task7.type.Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_qtype, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "semeval2013.task7.type.Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "semeval2013.task7.type.Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Question_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.String", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_module = jcas.getRequiredFeatureDE(casType, "module", "uima.cas.String", featOkTst);
    casFeatCode_module  = (null == casFeat_module) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_module).getCode();

 
    casFeat_style = jcas.getRequiredFeatureDE(casType, "style", "uima.cas.String", featOkTst);
    casFeatCode_style  = (null == casFeat_style) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_style).getCode();

 
    casFeat_qtype = jcas.getRequiredFeatureDE(casType, "qtype", "uima.cas.String", featOkTst);
    casFeatCode_qtype  = (null == casFeat_qtype) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_qtype).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

  }
}



    