package ainstance;

import java.util.Arrays;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import package_.subpackage.A;

/**
 * Pattern-specific match representation of the Ainstance pattern, 
 * to be used in conjunction with AinstanceMatcher.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AinstanceMatcher
 * @see AinstanceProcessor
 * 
 */
public final class AinstanceMatch extends BasePatternMatch {
  private A fO;
  
  private static String[] parameterNames = {"O"};
  
  AinstanceMatch(final A pO) {
    this.fO = pO;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("O".equals(parameterName)) return this.fO;
    return null;
    
  }
  
  public A getO() {
    return this.fO;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if ("O".equals(parameterName) ) {
    	this.fO = (package_.subpackage.A) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setO(final A pO) {
    this.fO = pO;
    
  }
  
  @Override
  public String patternName() {
    return "Ainstance";
    
  }
  
  @Override
  public String[] parameterNames() {
    return AinstanceMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fO};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"O\"=" + prettyPrintValue(fO));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fO == null) ? 0 : fO.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (obj == null)
    	return false;
    if (!(obj instanceof IPatternMatch))
    	return false;
    IPatternMatch otherSig  = (IPatternMatch) obj;
    if (!pattern().equals(otherSig.pattern()))
    	return false;
    if (!AinstanceMatch.class.equals(obj.getClass()))
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    AinstanceMatch other = (AinstanceMatch) obj;
    if (fO == null) {if (other.fO != null) return false;}
    else if (!fO.equals(other.fO)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return AinstanceMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
}
