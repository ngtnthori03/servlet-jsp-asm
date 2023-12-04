package tigi.servlet.util.tigi.converter;

import org.apache.commons.beanutils.Converter;

import java.util.UUID;

public class UUIDFromString implements Converter {


  @Override
  public <T> T convert(Class<T> type, Object value) {
    return (T) UUID.fromString((String) value);
  }
}
