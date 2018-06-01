package large.excell.to.bean.ta.checkedRun;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.Logger;

import large.excell.to.bean.ta.bean.ExampleBean;
import large.excell.to.bean.ta.utilities.enums.ExcelFactoryType;
import large.excell.to.bean.ta.utilities.factory.Parser;
/**
 * 
 * @author Taleh Algayev
 * Jun 1, 2018
 */
public class MainApp {
	final static Logger log = Logger.getLogger(MainApp.class);
	public static void main(String[] args) throws Exception {
		
		Parser<ExampleBean> parser = new Parser<ExampleBean>(ExampleBean.class, ExcelFactoryType.COLUMN_INDEX_BASED_EXTRACTION,true);
		parser.setSkipHeader(true);
		
		long start = System.currentTimeMillis();
		byte [] file = Files.readAllBytes(Paths.get(MainApp.class.getClassLoader().getResource("sample.xlsx").toURI()));
		log.info("convert to byte -> "+(System.currentTimeMillis()-start));
		start = System.currentTimeMillis();
		List<ExampleBean> resultAfterParse = parser.parse(file);
		log.info("convert to bean -> "+(System.currentTimeMillis()-start));
		log.info("excell row size - > "+resultAfterParse.size());
	}
}
