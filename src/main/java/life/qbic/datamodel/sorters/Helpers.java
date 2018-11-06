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

/**
 * Helper functions used for qbicobject creation
 * 
 * @author Andreas Friedrich
 * 
 */
public class Helpers {
  
  /**
   * humanly readable order comparator (a1 < a2 < a10)
   * 
   * @param a
   * @param b
   * @return
   */
  public static int compareAlphaNum(String a, String b) {
    int la = a.length();
    int lb = b.length();
    int ka = 0;
    int kb = 0;
    while (true) {
      if (ka == la)
        return kb == lb ? 0 : -1;
      if (kb == lb)
        return 1;
      if (a.charAt(ka) >= '0' && a.charAt(ka) <= '9' && b.charAt(kb) >= '0'
          && b.charAt(kb) <= '9') {
        int na = 0;
        int nb = 0;
        while (ka < la && a.charAt(ka) == '0')
          ka++;
        while (ka + na < la && a.charAt(ka + na) >= '0' && a.charAt(ka + na) <= '9')
          na++;
        while (kb < lb && b.charAt(kb) == '0')
          kb++;
        while (kb + nb < lb && b.charAt(kb + nb) >= '0' && b.charAt(kb + nb) <= '9')
          nb++;
        if (na > nb)
          return 1;
        if (nb > na)
          return -1;
        if (ka == la)
          return kb == lb ? 0 : -1;
        if (kb == lb)
          return 1;

      }
      if (a.charAt(ka) != b.charAt(kb))
        return a.charAt(ka) - b.charAt(kb);
      ka++;
      kb++;
    }
  }

}
