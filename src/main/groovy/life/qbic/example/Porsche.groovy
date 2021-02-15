package life.qbic.example

import groovy.transform.*

@PackageScope
class Porsche implements Car {

    @Override
    def startEngine() {
        println "Starting engine..."
        println "...RoarRoaar"
    }

} 