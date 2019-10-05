package carlos.nicolau.galves.androidcwb.examples_unit_test.callback;

public class Response {

    private Data data;
    private boolean isValid = true;

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

}