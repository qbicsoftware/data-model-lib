package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * Tests for the FastQZippedFile class
 *
 * @author: Sven Fillinger
 */
class FastQZippedFileSpec extends Specification {

    def "shall create a FastQFile instance using fastq.gz"() {
        given:
        final name = "test_file.fastq.gz"
        final relativePath = "root/test_file.fastq.gz"

        when:
        def dataObject = FastQZippedFile.create(name, relativePath)

        then:
        assert dataObject instanceof FastQZippedFile
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "test_file.fasta"
        final relativePath = "root/test_file.fasta"

        when:
        def dataObject = FastQZippedFile.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }



}
