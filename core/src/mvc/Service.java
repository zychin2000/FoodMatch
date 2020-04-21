package mvc;

public abstract class Service<T> {
    protected Model model;

    public abstract T execute();
}
