package life.qbic.datamodel.sorters;


import java.util.Comparator;

import life.qbic.datamodel.printing.IBarcodeBean;

/**
 * Compares IBarcodeBeans by the qbicobject description
 * @author Andreas Friedrich
 *
 */
public class TopInfoComparator implements Comparator<IBarcodeBean> {

	private static final TopInfoComparator instance = 
			new TopInfoComparator();

	public static TopInfoComparator getInstance() {
		return instance;
	}

	private TopInfoComparator() {
	}

	@Override
	public int compare(IBarcodeBean o1, IBarcodeBean o2) {
		return o1.firstInfo().compareTo(o2.firstInfo());
	}

}
