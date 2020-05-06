package life.qbic.datamodel.datasets.datastructure.folders

import life.qbic.datamodel.datasets.OxfordNanoporeMeasurement
import life.qbic.datamodel.datasets.datastructure.files.nanopore.Fast5File
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.Fast5FailFolder

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class Main {

    static void main(String[] args) {
        def file = Fast5File.create("my.fast5", "root/fast5")
        def folder = Fast5FailFolder.create("root/fast5_fail", [file])


        def oxMeasurement = OxfordNanoporeMeasurement.create("20200219_1107_1-E3-H3_PAE26974_454b8dc6_fds",
                "root/20200219_1107_1-E3-H3_PAE26974_454b8dc6_fds",
                [folder])
    }
}
