package foo.rida;

public final class GetterWrapper {
    private final int number;

    public GetterWrapper(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
