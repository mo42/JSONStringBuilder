package de.mo42;

/**
 * This class provides functionality for creating JSON files efficiently. The
 * basic idea is to use a string builder and some helper methods for adding JSON
 * objects and arrays. This class does not verify the provided JSON parts. It is
 * assumed that the JSON parts come from trusted source (e.g. from preprocessed
 * entries in a database).
 *
 * @author mo
 */
public class JSONStringBuilder {

  public final static String NOT_DELIMIT = "";
  public final static String DELIMIT = ",";

  private static final char BEGIN_JSON = '{';
  private static final char END_JSON = '}';
  private static final char QUOTE = '"';
  private static final char COLON = ':';
  private static final char START_ARRAY = '[';
  private static final char END_ARRAY = ']';
  private static final char SEPARATOR = ',';
  private StringBuilder stringBuilder;

  public JSONStringBuilder() {
    stringBuilder = new StringBuilder();
  }

  /**
   * Add a simple string value to the JSON document. This method quotes both
   * parameters.
   *
   * @param key   key of the JSON element
   * @param value JSON element
   */
  public void put(String key, String value) {
    quoteAppend(key);
    stringBuilder.append(COLON);
    quoteAppend(value);
  }

  public void startJSON() {
    stringBuilder.append(BEGIN_JSON);
  }

  public void startJSON(String key) {
    quoteAppend(key);
    stringBuilder.append(COLON).append(BEGIN_JSON);
  }

  public void endJSON() {
    stringBuilder.append(END_JSON);
  }

  public void startJSONArray() {
    stringBuilder.append(START_ARRAY);
  }

  public void startJSONArray(String key) {
    quoteAppend(key);
    stringBuilder.append(COLON).append(START_ARRAY);
  }

  public void endJSONArray() {
    stringBuilder.append(END_ARRAY);
  }

  public String toString() {
    return stringBuilder.toString();
  }

  private void quoteAppend(String key) {
    stringBuilder.append(QUOTE).append(key).append(QUOTE);
  }

  /**
   * Add comma.
   */
  public void separate() {
    stringBuilder.append(SEPARATOR);
  }

  /**
   * Add a integer value to the JSON document. This method quotes  the key.
   *
   * @param key   of  the JSON element
   * @param value JSON element
   */
  public void put(String key, int value) {
    quoteAppend(key);
    stringBuilder.append(COLON).append(value);
  }

  /**
   * Add a long value to the JSON document. This method quotes the key.
   *
   * @param key   of the JSON element
   * @param value JSON element
   */
  public void put(String key, long value) {
    quoteAppend(key);
    stringBuilder.append(COLON).append(value);
  }

  /**
   * Add JSON element. This method quotes the key.
   *
   * @param key  of the JSON element
   * @param json JSON element
   */
  public void addJSON(String key, String json) {
    quoteAppend(key);
    stringBuilder.append(COLON).append(json);
  }

  public void append(String string) {
    stringBuilder.append(string);
  }

  public void clear() {
    stringBuilder.setLength(0);
  }
}
