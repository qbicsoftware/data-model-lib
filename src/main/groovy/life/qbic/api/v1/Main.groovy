package life.qbic.api.v1

import conversion.Converter

/**
 * Example entry point for a showcase of the openBIS object adapter usage.
 */
class Main {

    static void main(String[] args){
        def oSample = new OpenbisSample() // create an example openBIS qbicobject
        def otherChild = new OpenbisSample() // create another openBIS qbicobject
        oSample.otherChildren = [otherChild] // and add this as child

        def converter = new Converter()

        def qSample = converter.convert(oSample)

        print(qSample.getChildren())

    }

}

class OpenbisSample {

    List<OpenbisSample> otherChildren

}
