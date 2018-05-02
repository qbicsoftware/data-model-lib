package life.qbic.datamodel.printing;

public class Printer {

  public static enum PrinterType {
    Label_Printer("LABEL PRINTER"), A4_Printer("A4 PRINTER");

    private String name;

    PrinterType(String name) {
      this.name = name;
    }

    public String getText() {
      return this.name;
    }

    public static PrinterType fromString(String name) {
      if (name != null) {
        for (PrinterType b : PrinterType.values()) {
          String n1 = name.replace("_", " ");
          String n2 = b.name.replace("_", " ");
          if (n1.equalsIgnoreCase(n2)) {
            return b;
          }
        }
      }
      return null;
    }
  }

  private String location;
  private String name;
  private String hostname;
  private PrinterType type;
  private boolean adminPrinter;
  private String userGroup;

  public Printer(String location, String name, String hostname, PrinterType type, boolean adminOnly, String userGroup) {
    super();
    this.location = location;
    this.name = name;
    this.hostname = hostname;
    this.type = type;
    this.adminPrinter = adminOnly;
    this.userGroup = userGroup;
  }

  @Override
  public String toString() {
    return name + " at " + location + " (" + hostname + ")";
  }

  public String getLocation() {
    return location;
  }

  public String getName() {
    return name;
  }

  public String getHostname() {
    return hostname;
  }

  public PrinterType getType() {
    return type;
  }
  
  public boolean isAdminPrinter() {
    return adminPrinter;
  }

  public String getUserGroup(){return this.userGroup;}

}
