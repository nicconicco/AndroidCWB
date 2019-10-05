package carlos.nicolau.galves.androidcwb.examples_unit_test.callback;

public class ActionHandler {

    private Service service;

    public ActionHandler(Service service) {
        this.service = service;
    }

    public void doAction() {
        service.doAction("our-request", new Callback<Response>() {
            @Override
            public void reply(Response response) {
                handleResponse(response);
            }
        });
    }

    private void handleResponse(Response response) {
        if (response.isValid()) {
            response.setData(new Data("Successful data response"));
        }
    }

}