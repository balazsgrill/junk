package ainstance;

import ainstance.AinstanceMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate AinstanceMatcher in a type-safe way.
 * 
 * @see AinstanceMatcher
 * @see AinstanceMatch
 * 
 */
public class AinstanceMatcherFactory extends BaseGeneratedMatcherFactory<AinstanceMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AinstanceMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected AinstanceMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new AinstanceMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "query";
    
  }
  
  @Override
  protected String patternName() {
    return "Ainstance";
    
  }
  
  private AinstanceMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<AinstanceMatcherFactory> {
    @Override
    public AinstanceMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static AinstanceMatcherFactory INSTANCE = make();
    
    public static AinstanceMatcherFactory make() {
      try {
      	return new AinstanceMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
