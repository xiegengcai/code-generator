package generator;
/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
	public static void main(String[] args) throws Exception {
		if (args == null || args.length < 1) {
			System.err.println("请指定配置文件参数。java generator.GeneratorMain conf/generator.properties");
			System.exit(0);
		}
		PropertiesProvider.initProperties(args[0]);
		Generator g = new Generator();
		g.clean();
		String [] tables = PropertiesProvider.getProperty("table.names").split(",");
		for (String table : tables) {
			g.generateTable(table);
		}
//		g.generateAllTable();
	}
}
