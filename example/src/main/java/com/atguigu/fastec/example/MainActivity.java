package com.atguigu.fastec.example;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.widget.Toast;

import com.atguigu.latte.activities.ProxyActivity;
import com.atguigu.latte.app.Latte;
import com.atguigu.latte.delegates.LatteDelegate;
import com.atguigu.latteec.ec.launcher.ILauncherListener;
import com.atguigu.latteec.ec.launcher.LauncherDelegate;
import com.atguigu.latteec.ec.launcher.OnLauncherFinishTag;
import com.atguigu.latteec.ec.main.EcBottomDelegate;
import com.atguigu.latteec.ec.sign.ISignListener;
import com.atguigu.latteec.ec.sign.SignInDelegate;

public class MainActivity extends ProxyActivity implements
        ILauncherListener,
        ISignListener{
//public class MainActivity extends Activity {

    @Override
    public LatteDelegate setRootDelegate() {
//        return new ExampleDelegate();
        return new LauncherDelegate();
//        return new LauncherScrollDelegate();
//        return new EcBottomDelegate();
//        return new SignUpDelegate();
//        return new SignInDelegate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Latte.getConfigurator().withActivity(this);
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功回调", Toast.LENGTH_LONG).show();
        Log.i("sujh_fragment","onSignInSuccess--"+getSupportDelegate());
        getSupportDelegate().startWithPop(new EcBottomDelegate());//进入主页
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功回调", Toast.LENGTH_LONG).show();
        getSupportDelegate().startWithPop(new EcBottomDelegate());//进入主页
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this, "启动结束，用户登录了", Toast.LENGTH_LONG).show();
                Log.i("sujh_fragment","启动结束，用户登录了--"+getSupportDelegate());
                getSupportDelegate().startWithPop(new EcBottomDelegate());//进入主页
                break;
            case NOT_SIGNED://没有登录跳到登录界面
                Toast.makeText(this, "启动结束，用户没登录", Toast.LENGTH_LONG).show();
                getSupportDelegate().startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
