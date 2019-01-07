package cmd.http;

import java.util.List;

/**
 * the request
 */
public class RequestBody {

    private String type;
    private String call;
    private List<Object> args;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public List<Object> getArgs() {
        return args;
    }

    public void setArgs(List<Object> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "RequestBody{" +
                "type='" + type + '\'' +
                ", call='" + call + '\'' +
                ", args=" + args +
                '}';
    }
}
