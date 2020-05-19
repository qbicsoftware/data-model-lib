package life.qbic.datamodel.datasets.datastructure.files

import spock.lang.Specification

/**
 * Tests for the DataFile class
 *
 * @author: Sven Fillinger
 */
class DataFileSpec extends Specification {

    def "name included in the relative path shall create a DataFile instance"() {
        given:
        def name = "random_file_name.txt"
        def relativePath = "a_relative/path/random_file_name.txt"

        when:
        def dataFile = new DataFile(name, relativePath, "txt")

        then:
        assert dataFile instanceof DataFile
        assert dataFile.name == name
        assert dataFile.relativePath == relativePath
        assert dataFile.fileType == "txt"
    }

    def "name that is not contained in the relative path shall throw an IllegalArgumentException"() {
        given:
        def name = "deviating_file.txt"
        def relativePath = "a_relative/path/random_file_name.txt"

        when:
        new DataFile(name, relativePath, "txt")

        then:
        thrown(IllegalArgumentException)
    }

    def "name that does not contain the given file type shall throw an IllegalArgumentException"() {
        given:
        def name = "random_file_name.csv"
        def relativePath = "a_relative/path/random_file_name.csv"

        when:
        new DataFile(name, relativePath, "txt")

        then:
        final IllegalArgumentException exception = thrown()
        assert exception.message == "File does not have the assumed type."
    }




}
