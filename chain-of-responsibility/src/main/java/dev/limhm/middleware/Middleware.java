package dev.limhm.middleware;

/**
 * Base  middleware class.
 */
public abstract class Middleware {

  private Middleware next;  // 포인터 역할

  /**
   * Builds chains of middleware objects.
   * <p>
   * {@code ...}: 가변인자를 의미하며 {@code Middleware[]} 형태로 받는다.
   */
  public static Middleware link(Middleware first, Middleware... chain) {
    Middleware head = first;
    for (Middleware nextInChain : chain) {
      head.next = nextInChain;  // next 필드에 방금 꺼내온 chain 객체 할당
      head = nextInChain;  // 다음 객체를 연결하기 위해 head 포인터 이동
    }
    return first;
  }

  /**
   * Subclass will implement this method with concrete checks.
   */
  public abstract boolean check(String email, String password);

  /**
   * Runs check on the next object in chain or end traversing if we're in last object in chain.
   */
  protected boolean checkNext(String email, String password) {
    if (next == null) {
      return true;
    }
    return next.check(email, password);
  }
}
