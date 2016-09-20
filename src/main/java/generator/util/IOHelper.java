package generator.util;

import generator.PropertiesProvider;

import java.io.*;
import java.net.URLEncoder;

/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */
public class IOHelper {

	private static final boolean encodeRemarksToUtf8 = Boolean.valueOf(PropertiesProvider.getProperty("encode.remarks2utf8", "false"));
	private static final String encoder = "UTF-8";
	public static void copy(Reader in,Writer out) throws IOException {
		int c = -1;
		while((c = in.read()) != -1) {
			out.write(c);
		}
	}
	
	public static String readFile(File file) throws IOException {
		Reader in = new FileReader(file);
		StringWriter out = new StringWriter();
		copy(in,out);
		return out.toString();
	}
	
	public static void saveFile(File file,String content) throws Exception {
		Writer writer = null;
		if (encodeRemarksToUtf8) {
			writer = new OutputStreamWriter(new FileOutputStream(file), encoder);
		} else {
			writer = new FileWriter(file);
		}
		writer.write(content);
		writer.close();
	}
	
}
