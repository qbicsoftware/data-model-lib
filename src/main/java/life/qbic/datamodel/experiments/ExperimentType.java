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
package life.qbic.datamodel.experiments;

/**
 * Current experiment type codes used in the wizard
 * 
 * @author Andreas Friedrich
 *
 */
public enum ExperimentType {
  Q_WF_NGS_QUALITYCONTROL, Q_BMI_GENERIC_IMAGING, Q_WF_MS_QUALITYCONTROL, Q_WF_MS_MAXQUANT, Q_NGS_VARIANT_CALLING, Q_NGS_MEASUREMENT, Q_NGS_MAPPING, Q_NGS_IMMUNE_MONITORING, Q_NGS_HLATYPING, Q_NGS_FLOWCELL_RUN, Q_NGS_EPITOPE_PREDICTION, Q_WF_NGS_EPITOPE_PREDICTION, Q_WF_NGS_VARIANT_ANNOTATION, Q_WF_NGS_HLATYPING, Q_EXPERIMENTAL_DESIGN, Q_SAMPLE_EXTRACTION, Q_SAMPLE_PREPARATION, Q_MHC_LIGAND_EXTRACTION, Q_MS_MEASUREMENT, Q_NGS_SINGLE_SAMPLE_RUN, Q_PROJECT_DETAILS, Q_MICROARRAY_MEASUREMENT
}
