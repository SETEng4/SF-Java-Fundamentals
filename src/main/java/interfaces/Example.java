package interfaces;

import java.util.Arrays;
import java.util.List;

interface Photographer {
  // methods declared like this in an interface are:
  // implicitly public
  // implicitly abstract
  String takePhoto(String subject);

  // Can define static methods in interfaces since Java 8
  // -- can ONLY be public (which is default for them) or private

  // Can declare private instance methods
  // -- can only have code in terms of the interface methods

  // Can declare "default" methods, these are public,
  // and like regular instance methods. But, we don't "inherit"
  // them we "fall back" to them
}

class MomWithCamera implements Photographer {
  public String takePhoto(String subject) {
    System.out.println("What lovely " + subject + " smile everyone!");
    return "Lovely picture of smiling " + subject;
  }
}

class SpySatellite implements Photographer {
  public String takePhoto(String subject) {
    System.out.println("Bleep bleep bleep (really, there's no sound in space!)");
    return "Grainy photo of " + subject + " from above and we can read the diary entry you're writing!";
  }
}

public class Example {
  public static void main(String[] args) {
    // Java 8 and older: Arrays.asList
    // The resulting list uses the original array for storage, so
    // you cannot change the list's length, but you can change
    // individual items using "set(idx, item)"
//    List<Photographer> photogs = Arrays.asList(new Photographer[]{
//        new MomWithCamera(), new SpySatellite()
//    });
    // Java 9 onwards
    // This list is "structurally unmodifiable"
    // any attempt to change the list using the add, remove, set, clear, etc. methods
    // throws UnsupportedOperationException
    // but it's not guaranteed "immutable" because if we have a list containing
    // mutable elements (e.g. StringBuilder) this cannot prevent changes to the elements
    List<Photographer> photogs = List.of(
        new MomWithCamera(), new SpySatellite()
    );
    System.out.println("type of list is: " + photogs.getClass());

    for (Photographer p : photogs) {
      System.out.println(p.takePhoto("My cute kids"));
    }
  }
}
