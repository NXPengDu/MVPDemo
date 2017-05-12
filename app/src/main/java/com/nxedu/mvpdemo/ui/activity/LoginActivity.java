package com.nxedu.mvpdemo.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;
import com.nxedu.mvpdemo.R;
import com.nxedu.mvpdemo.model.entity.UserInfoBean;
import com.nxedu.mvpdemo.ui.common.BaseActivity;
import com.nxedu.mvpdemo.ui.view.ClearableEditText;
import com.nxedu.mvpdemo.utils.NetWorkReq;
import com.nxedu.mvpdemo.utils.NetWorkService;
import com.nxedu.mvpdemo.utils.ZProgressHUD;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.activity_login_loading_progressBar)
    CircleProgressBar progressBar;
    @BindView(R.id.activity_login_phone_edit)
    ClearableEditText activityLoginPhoneEdit;
    @BindView(R.id.activity_login_psd_edit)
    ClearableEditText activityLoginPsdEdit;
    @BindView(R.id.activity_login_button)
    Button activityLoginButton;
    private ZProgressHUD progressHUD;
    private Call<ResponseBody> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setProgressBar(progressBar);
    }

    @OnClick(R.id.activity_login_button)
    public void onClick() {
        String myUser = activityLoginPhoneEdit.getText().toString();
        String myPsd = activityLoginPsdEdit.getText().toString();
        //showLoading();
        progressHUD = ZProgressHUD.getInstance(this);
        progressHUD.setMessage("加载中");
        progressHUD.setSpinnerType(1);
        progressHUD.show();

        NetWorkService service = NetWorkReq.getService();
        //Call<ResponseBody> call = service.getUserInfo("18301335694");
        call = service.addUser(new UserInfoBean());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.v("Tag", response.body().string());
                    if(progressHUD != null) {
                        progressHUD.dismiss();//关闭loading
                    }

                    Toast.makeText(LoginActivity.this, response.body().string(), Toast.LENGTH_LONG).show();
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}
