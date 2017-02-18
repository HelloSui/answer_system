package com.suixue.common;
import java.io.Serializable;
public class JsonResult  implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**返回结果码**/
    private String code;

    /**返回结果信息描述**/
    private String message;

    /**返回的数据**/
    private String data;

    /**签名数据**/
    private String sign;

    public JsonResult() {}

    public JsonResult(String code, String message, String data, String sign) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.sign = sign;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "[code=" + code + ", message=" + message + ",data=" + data + ", sign=" + sign + "]";
    }

}
