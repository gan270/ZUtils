package com.chh.myutils.ioc;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * @ProjectName : chh.IntelliMattress
 * @Author : ganhs
 * @Time : 2021/4/16 8:53
 * @Description :
 */
public class ViewTools {

    public static void inject(Activity activity) {
        inject(new ViewFinder(activity), activity);
    }

    public static void inject(View view) {
        inject(new ViewFinder(view), view);

    }

    public static void inject(View view, Object o) {
        inject(new ViewFinder(view), o);

    }

    private static void inject(ViewFinder finder, Object o) {
        injectFiled(finder, o);
        injectEvent(finder, o);

    }

    private static void injectFiled(ViewFinder finder, Object o) {

        Class<?> clazz = o.getClass();

        Field[] mFields = clazz.getDeclaredFields();
        for (Field mField : mFields) {
            ViewById mViewById = mField.getAnnotation(ViewById.class);
            if (mViewById != null) {
                int value = mViewById.value();
                View mView = finder.findViewById(value);
                if (mView!=null){
                    mField.setAccessible(true);
                    try {
                        mField.set(o, mView);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private static void injectEvent(ViewFinder finder, Object o) {
    }
}
