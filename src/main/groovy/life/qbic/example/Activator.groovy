package life.qbic.example

import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext

class Activator implements BundleActivator{

    @Override
    void start(BundleContext context ) throws Exception {

        System.out.println( context.getBundle().getSymbolicName() +  ": Hello OSGi-World." )
    }

    @Override
    void stop( BundleContext context ) throws Exception {

        System.out.println( context.getBundle().getSymbolicName() +  ": Bye OSGi-World." )
    }

}
