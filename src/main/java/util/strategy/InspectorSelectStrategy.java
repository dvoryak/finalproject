package util.strategy;

import model.entity.Inspector;

import java.sql.SQLException;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 */
public interface InspectorSelectStrategy {

     /** Return the inspector if he is exist in database, otherwise null
      *
      * @return {@link Inspector}
      * @throws SQLException
      */
     Inspector getInspector() throws SQLException;

}
