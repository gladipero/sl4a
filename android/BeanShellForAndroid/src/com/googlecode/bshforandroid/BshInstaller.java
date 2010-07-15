package com.googlecode.bshforandroid;

import java.io.File;

import android.content.Context;


import com.googlecode.android_scripting.AsyncTaskListener;
import com.googlecode.android_scripting.InterpreterInstaller;
import com.googlecode.android_scripting.Sl4aLog;
import com.googlecode.android_scripting.exception.Sl4aException;
import com.googlecode.android_scripting.interpreter.InterpreterConstants;
import com.googlecode.android_scripting.interpreter.InterpreterDescriptor;

public class BshInstaller extends InterpreterInstaller {

  public BshInstaller(InterpreterDescriptor descriptor, Context context,
      AsyncTaskListener<Boolean> listener) throws Sl4aException {
    super(descriptor, context, listener);
  }

  @Override
  protected boolean setup() {
    File dalvikCache = new File(InterpreterConstants.SL4A_DALVIK_CACHE_ROOT);
    if (!dalvikCache.isDirectory()) {
      try {
        dalvikCache.mkdir();
      } catch (SecurityException e) {
        Sl4aLog.e(mContext, "Setup failed.", e);
        return false;
      }
    }
    return true;
  }
}