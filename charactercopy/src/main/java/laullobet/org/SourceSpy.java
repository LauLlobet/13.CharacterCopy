package laullobet.org;

public class SourceSpy implements ISource{

    private final String string;
    private int calledNTimes;

    public SourceSpy(String string) {
        this.string = string;
    }

    @Override
    public char GetChar() {
        calledNTimes++;
        return string.charAt(calledNTimes-1);
    }

    public int getCalledNTimes() {
        return calledNTimes;
    }
}
