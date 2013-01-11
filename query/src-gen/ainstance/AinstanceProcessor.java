package ainstance;

import ainstance.AinstanceMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import package_.subpackage.A;

/**
 * A match processor tailored for the Ainstance pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class AinstanceProcessor implements IMatchProcessor<AinstanceMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pO the value of pattern parameter O in the currently processed match 
   * 
   */
  public abstract void process(final A O);
  
  @Override
  public void process(final AinstanceMatch match) {
    process(match.getO());  				
    
  }
}
