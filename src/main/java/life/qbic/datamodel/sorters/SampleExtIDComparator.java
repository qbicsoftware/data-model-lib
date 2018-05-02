/*******************************************************************************
 * QBiC Project Wizard enables users to create hierarchical experiments including different study
 * conditions using factorial design. Copyright (C) "2016" Andreas Friedrich
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package life.qbic.datamodel.sorters;

import java.util.Comparator;

import life.qbic.datamodel.printing.IBarcodeBean;

/**
 * Compares IBarcodeBeans by external db id
 * 
 * @author Andreas Friedrich
 * 
 */
public class SampleExtIDComparator implements Comparator<IBarcodeBean> {

  private static final SampleExtIDComparator instance = new SampleExtIDComparator();

  public static SampleExtIDComparator getInstance() {
    return instance;
  }

  private SampleExtIDComparator() {}

  @Override
  public int compare(IBarcodeBean o1, IBarcodeBean o2) {
    String s1 = o1.getExtID();
    String s2 = o2.getExtID();
    if (s1 == null)
      s1 = "";
    if (s2 == null)
      s2 = "";
    return Helpers.compareAlphaNum(s1, s2);
  }

}
