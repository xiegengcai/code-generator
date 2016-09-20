package generator.util;


import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */
public class DatabaseDataTypesUtils {

	private final static Map<Integer, Class<?>> _preferredJavaTypeForSqlType = new HashMap<>();
	 
	public static boolean isFloatNumber(int sqlType,int size,int decimalDigits) {
		Class javaType = getPreferredJavaType(sqlType,size,decimalDigits);
		if(javaType.equals(Float.class) || javaType.equals(Double.class) || javaType.equals(BigDecimal.class)) {
			return true;
		}
		return false;
	}
	
	public static boolean isIntegerNumber(int sqlType,int size,int decimalDigits) {
		Class javaType = getPreferredJavaType(sqlType,size,decimalDigits);
		if(javaType.equals(Long.class) || javaType.equals(Integer.class) || javaType.equals(Short.class)) {
			return true;
		}
		return false;
	}

	public static boolean isDate(int sqlType,int size,int decimalDigits) {
		Class javaType = getPreferredJavaType(sqlType,size,decimalDigits);
		if(javaType.equals(Date.class) || javaType.equals(Timestamp.class)) {
			return true;
		}
		return false;
	}
	
	public static Class<?> getPreferredJavaType(int sqlType, int size,
			int decimalDigits) {
		if ((sqlType == Types.DECIMAL || sqlType == Types.NUMERIC)
				&& decimalDigits == 0) {
			if (size == 1) {
				// https://sourceforge.net/tracker/?func=detail&atid=415993&aid=662953&group_id=36044
				return Boolean.TYPE;
			} else if (size < 3) {
				return Byte.TYPE;
			} else if (size < 5) {
				return Short.TYPE;
			} else if (size < 10) {
				return Integer.TYPE;
			} else if (size < 19) {
				return Long.TYPE;
			} else {
				return BigDecimal.class;
			}
		}
		Class<?> result = _preferredJavaTypeForSqlType.get(sqlType);
		if (result == null) {
			return Object.class;
		}
		return result;
	}
		   
   static {
      _preferredJavaTypeForSqlType.put(Types.TINYINT, Byte.class);
      _preferredJavaTypeForSqlType.put(Types.SMALLINT, Short.class);
      _preferredJavaTypeForSqlType.put(Types.INTEGER, Integer.class);
      _preferredJavaTypeForSqlType.put(Types.BIGINT, Long.class);
      _preferredJavaTypeForSqlType.put(Types.REAL, Float.class);
      _preferredJavaTypeForSqlType.put(Types.FLOAT, Double.class);
      _preferredJavaTypeForSqlType.put(Types.DOUBLE, Double.class);
      _preferredJavaTypeForSqlType.put(Types.DECIMAL, BigDecimal.class);
      _preferredJavaTypeForSqlType.put(Types.NUMERIC, BigDecimal.class);
      _preferredJavaTypeForSqlType.put(Types.BIT, Boolean.class);
      _preferredJavaTypeForSqlType.put(Types.CHAR, String.class);
      _preferredJavaTypeForSqlType.put(Types.VARCHAR, String.class);
      // according to resultset.gif, we should use java.io.Reader, but String is more convenient for EJB
      _preferredJavaTypeForSqlType.put(Types.LONGVARCHAR, String.class);
      _preferredJavaTypeForSqlType.put(Types.BINARY, byte[].class);
      _preferredJavaTypeForSqlType.put(Types.VARBINARY, byte[].class);
      _preferredJavaTypeForSqlType.put(Types.LONGVARBINARY, InputStream.class);
      _preferredJavaTypeForSqlType.put(Types.DATE, Date.class);
      _preferredJavaTypeForSqlType.put(Types.TIME, Time.class);
      _preferredJavaTypeForSqlType.put(Types.TIMESTAMP, Date.class);
      _preferredJavaTypeForSqlType.put(Types.CLOB, Clob.class);
      _preferredJavaTypeForSqlType.put(Types.BLOB, Blob.class);
      _preferredJavaTypeForSqlType.put(Types.ARRAY, Array.class);
      _preferredJavaTypeForSqlType.put(Types.REF, Ref.class);
      _preferredJavaTypeForSqlType.put(Types.STRUCT, Object.class);
      _preferredJavaTypeForSqlType.put(Types.JAVA_OBJECT, Object.class);
   }
		
//   private static class IntStringMap extends HashMap {
//
//		public String getString(int i) {
//			return (String) get(new Integer(i));
//		}
//
//		public String[] getStrings(int i) {
//			return (String[]) get(new Integer(i));
//		}
//
//		public void put(int i, String s) {
//			put(new Integer(i), s);
//		}
//
//		public void put(int i, String[] sa) {
//			put(new Integer(i), sa);
//		}
//	}
	   
}
