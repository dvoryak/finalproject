package util;

import model.entity.Inspector;

import java.sql.SQLException;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 */
public interface InspectorSelectStrategy {

     /**
      * @return {@link Inspector}
      * @throws SQLException
      */
     Inspector getInspector() throws SQLException;

}
