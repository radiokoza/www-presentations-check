package org.presentation.model;

/**
 *
 * @author Jindřich Máca
 */
public class ErrorCode {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String explain() {
        //TODO: Define messages for different error codes.
        return null;
    }
}