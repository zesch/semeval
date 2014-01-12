

/* First created by JCasGen Sat Jan 11 20:05:49 CET 2014 */
package semeval2012.task7.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Jan 12 11:49:07 CET 2014
 * XML source: /home/zesch/git/semeval/semeval2012/semeval2012.task7/src/main/resources/desc/type/Copa.xml
 * @generated */
public class Statement extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Statement.class);
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
  protected Statement() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Statement(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Statement(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Statement(JCas jcas, int begin, int end) {
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
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public String getId() {
    if (Statement_Type.featOkTst && ((Statement_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2012.task7.type.Statement");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Statement_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (Statement_Type.featOkTst && ((Statement_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "semeval2012.task7.type.Statement");
    jcasType.ll_cas.ll_setStringValue(addr, ((Statement_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: asksFor

  /** getter for asksFor - gets 
   * @generated */
  public String getAsksFor() {
    if (Statement_Type.featOkTst && ((Statement_Type)jcasType).casFeat_asksFor == null)
      jcasType.jcas.throwFeatMissing("asksFor", "semeval2012.task7.type.Statement");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Statement_Type)jcasType).casFeatCode_asksFor);}
    
  /** setter for asksFor - sets  
   * @generated */
  public void setAsksFor(String v) {
    if (Statement_Type.featOkTst && ((Statement_Type)jcasType).casFeat_asksFor == null)
      jcasType.jcas.throwFeatMissing("asksFor", "semeval2012.task7.type.Statement");
    jcasType.ll_cas.ll_setStringValue(addr, ((Statement_Type)jcasType).casFeatCode_asksFor, v);}    
   
    
  //*--------------*
  //* Feature: mostPlausibleAlternative

  /** getter for mostPlausibleAlternative - gets 
   * @generated */
  public String getMostPlausibleAlternative() {
    if (Statement_Type.featOkTst && ((Statement_Type)jcasType).casFeat_mostPlausibleAlternative == null)
      jcasType.jcas.throwFeatMissing("mostPlausibleAlternative", "semeval2012.task7.type.Statement");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Statement_Type)jcasType).casFeatCode_mostPlausibleAlternative);}
    
  /** setter for mostPlausibleAlternative - sets  
   * @generated */
  public void setMostPlausibleAlternative(String v) {
    if (Statement_Type.featOkTst && ((Statement_Type)jcasType).casFeat_mostPlausibleAlternative == null)
      jcasType.jcas.throwFeatMissing("mostPlausibleAlternative", "semeval2012.task7.type.Statement");
    jcasType.ll_cas.ll_setStringValue(addr, ((Statement_Type)jcasType).casFeatCode_mostPlausibleAlternative, v);}    
  }

    