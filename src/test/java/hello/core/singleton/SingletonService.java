package hello.core.singleton;

// 싱글톤 패턴
public class SingletonService {

    // static 영역에 객체를 딱 1개만 생성해 둔다
    private static final SingletonService instance = new SingletonService();

    // 생성자를 private 로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다
    // SingletonService sgt = new SingletonService(); 이렇게 호출 안됨
    private SingletonService() {
    }

    // public 으로 열어 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 한다.
    public static SingletonService getInstance() {
        return instance;
    }
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
