package cole.driscoll.personal.repo.Exceptions;


/**
 * Exception for when a post request to the Loopie API is unsuccessful, excluding status code 400
 * (user already exists).
 */
public class UnsuccessfulPostException extends Exception {

  public UnsuccessfulPostException(int statusCode) {
    super("Post request unsuccessful. For help, reference Loopie API status code: "+statusCode+". "
        + "If value is -1, then check print stack");
  }
}
