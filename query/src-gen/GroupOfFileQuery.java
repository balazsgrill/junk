import ainstance.AinstanceMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public final class GroupOfFileQuery extends BaseGeneratedPatternGroup {
  public GroupOfFileQuery() throws IncQueryException {
    matcherFactories.add(AinstanceMatcher.factory());
    
  }
}
