package com.goshop.app.utils;

import com.goshop.app.BuildConfig;
import com.orhanobut.logger.Logger;
import android.util.Log;

public class JLogUtils {

    public static final boolean useLogTool = false;

    public static final boolean IS_DEBUG = BuildConfig.DEBUG;

    public static void i(String tag, String msg) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).i(msg + "");
            } else {
                Log.i(tag, msg + "");
            }
        }
    }

    public static void i(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).i(msg + "");
            } else {
                Log.i(tag, msg + "", tr);
            }
        }
    }

    public static void e(String tag, String msg) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).e(msg + "");
            } else {
                Log.e(tag, msg + "");
            }
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).e(tr, msg);
            } else {
                Log.e(tag, msg, tr);
            }
        }
    }

    public static void d(String tag, String msg) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).d(msg);
            } else {
                Log.d(tag, msg);
            }
        }
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).d(msg);
            } else {
                Log.d(tag, msg, tr);
            }
        }
    }

    public static void w(String tag, String msg) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).w(msg);
            } else {
                Log.w(tag, msg);
            }
        }
    }

    public static void w(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).w(msg);
            } else {
                Log.w(tag, msg, tr);
            }
        }
    }

    public static void v(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).v(msg);
            } else {
                Log.v(tag, msg, tr);
            }
        }
    }

    public static void v(String tag, String msg) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).v(msg);
            } else {
                Log.v(tag, msg);
            }
        }
    }

    public static void wtf(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).wtf(msg);
            } else {
                Log.wtf(tag, msg, tr);
            }
        }
    }

    public static void wtf(String tag, String msg) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).wtf(msg);
            } else {
                Log.wtf(tag, msg);
            }
        }
    }

    public static void json(String tag, int requestCode, String json) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag + "-" + requestCode + "-->").json(json);
            } else {
                Log.d(tag, requestCode + "-->" + json);
            }
        }
    }

    public static void json(String tag, String json) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).json(json);
            } else {
                Log.d(tag, json);
            }
        }
    }

    public static void xml(String tag, String xml) {
        if (IS_DEBUG) {
            if (useLogTool) {
                Logger.t(tag).xml(xml);
            } else {
                Log.d(tag, xml);
            }
        }
    }
}
