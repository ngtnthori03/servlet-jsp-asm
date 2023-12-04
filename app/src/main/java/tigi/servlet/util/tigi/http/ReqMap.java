package tigi.servlet.util.tigi.http;

public @interface ReqMap {

  String uri() default "/";

  HttpMethod method() default HttpMethod.GET;

}
