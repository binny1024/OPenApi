package com.binny.openapi.mvp.presenter.register;

import com.binny.openapi.mvp.bean.RegisterBean;
import com.binny.openapi.mvp.callback.register.RegisterCallback;
import com.binny.openapi.mvp.model.IRegisterModule;
import com.binny.openapi.mvp.model.RegisterModule;
import com.binny.openapi.mvp.ui.activity.register.IRegisterView;

import java.io.File;

/**
 * author  binny
 * date 5/7
 */
public class RegisterPresenter implements IRegisterPresenter {
    private IRegisterView mRegister;
    private IRegisterModule mRegisterModel;

    public RegisterPresenter(IRegisterView register) {
        mRegister = register;
        mRegisterModel = new RegisterModule();
    }
    @Override
    public void getData(String phone, String passwd, String name, String text, String other, String other2, File imageFile) {
        mRegisterModel.requestRegister(new RegisterCallback() {
            @Override
            public void onSuccess(RegisterBean registerBean) {
                mRegister.updateView(registerBean);
            }

            @Override
            public void onError(String result) {
                mRegister.onError(result);
            }
        }, phone, passwd, name, text, other, other2, imageFile);
    }
}
