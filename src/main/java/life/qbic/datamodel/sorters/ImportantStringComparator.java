package life.qbic.datamodel.sorters;


import java.util.Comparator;

import life.qbic.datamodel.printing.IBarcodeBean;

/**
 * Compares IBarcodeBeans by qbicobject ID
 * @author Andreas Friedrich
 *
 */
public class ImportantStringComparator implements Comparator<IBarcodeBean> {

	private static final ImportantStringComparator instance = 
			new ImportantStringComparator();

	public static ImportantStringComparator getInstance() {
		return instance;
	}

	private ImportantStringComparator() {
	}

	@Override
	public int compare(IBarcodeBean o1, IBarcodeBean o2) {
		return o1.getCodedString().compareTo(o2.getCodedString());
	}

}
