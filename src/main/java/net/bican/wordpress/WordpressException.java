package net.bican.wordpress;

public class WordpressException extends Exception {
  private static final long serialVersionUID = 1207249988289308756L;
  private int               errorCode;

  public WordpressException(int errorCode) {
    this.errorCode = errorCode;
  }

  public WordpressResult getResult() {
    switch (this.errorCode) {
      case 401:
        return WordpressResult.PERMISSION_DENIED;
      case 404:
        return WordpressResult.NOT_FOUND;
      default:
        return WordpressResult.UNKNOWN_ERROR;
    }
  }

}
