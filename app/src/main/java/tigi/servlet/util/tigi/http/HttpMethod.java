package tigi.servlet.util.tigi.http;

public enum HttpMethod {

  GET("get"), POST("post"), PUT("put"), DELETE("delete"), OPTION("option");

  private final String value;

  HttpMethod(final String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
