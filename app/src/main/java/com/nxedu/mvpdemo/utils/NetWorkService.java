package com.nxedu.mvpdemo.utils;

import com.nxedu.mvpdemo.model.entity.UserInfoBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author dupeng
 * @version 1.0.0
 * @since 2017/5/5 20:52
 */

public interface NetWorkService {

    /**
     * Loginhttp://localhost:8080/lfd/QUserinfos?tel=18301335694
     */

    //查询参数的
    @GET("QUserinfos")
    Call<ResponseBody> getUserInfo(@Query("tel") String tel);

    /**
     * //用于访问zhy的信息
     http://192.168.1.102:8080/springmvc_users/user/zhy
     //用于访问lmj的信息
     http://192.168.1.102:8080/springmvc_users/user/lmj
     */
    //动态访问url
    @GET("{username}")
    Call<ResponseBody> geturl(@Path("username") String username);

    //一般get
    @GET("users")
    Call<ResponseBody> getUsers();

    @POST("add")
    Call<ResponseBody> addUser(@Body UserInfoBean user);

}
