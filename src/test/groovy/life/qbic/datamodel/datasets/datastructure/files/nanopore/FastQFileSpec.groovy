package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class FastQFileSpec extends Specification {

    def "shall create a FastQFile instance"()  {
        given:
        final name = "test_file.fastq"
        final relativePath = "root/test_file.fastq"

        when:
        def dataObject = FastQFile.create(name, relativePath)

        then:
        assert dataObject instanceof FastQFile
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "test_file.fasta"
        final relativePath = "root/test_file.fasta"

        when:
        def dataObject = FastQFile.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }

    def "shall create a FastQFile instance using fastq.gz"()  {
        given:
        final name = "test_file.fastq.gz"
        final relativePath = "root/test_file.fastq.gz"

        when:
        def dataObject = FastQFile.create(name, relativePath)

        then:
        assert dataObject instanceof FastQFile
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }


}
