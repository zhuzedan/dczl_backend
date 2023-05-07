package com.zsdzxw.dzclxt.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@ApiModel(value = "响应结果")
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "0-成功，其余编码详见编码表")
    private Integer code;

    @ApiModelProperty(value = "响应消息")
    private String message;

    @ApiModelProperty(value = "数据结果集")
    private T data;

    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private Long totalNum;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    private Result(final ResultCode resultCode, final T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }


    private Result(final T data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
        this.data = data;
    }

    private Result(Long totalNum, final T data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
        this.data = data;
        this.totalNum = totalNum;
    }

    public static <T> Result<T> fail(ResultCode resultCode) {
        return new Result<>(resultCode, null);
    }

    public static <T> Result<T> fail(ResultCode resultCode, T data) {
        return new Result<>(resultCode, data);
    }

    public static <T> Result<T> fail(ResultCode resultCode, String message) {
        Result<T> objectResult = new Result<>();
        objectResult.setCode(resultCode.getCode());
        objectResult.setMessage(resultCode.getMessage() + " : -> " + message);
        return objectResult;
    }

    public static <T> Result<T> fail(Integer code, String message) {
        Result<T> objectResult = new Result<>();
        objectResult.setCode(code);
        objectResult.setMessage(message);
        return objectResult;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> success(ResultCode resultCode, T data) {
        return new Result<>(resultCode, data);
    }

    public static <T> Result<T> success(T data, Long totalNum) {
        return new Result<>(totalNum, data);
    }

    @Override
    public String toString() {
        String ans = "{" +
                "\"code\":" + code + "," +
                "\"message\":" + "\"" + message + '\"' +
                '}';
        JSONObject json = JSONObject.parseObject(ans);
        json.put("data", data);
        return json.toString(SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty);
    }
}
