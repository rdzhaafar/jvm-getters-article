package foo.rida;

public class ParentGetterWrapper {
    private final int number;

    public ParentGetterWrapper(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
