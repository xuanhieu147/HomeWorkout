package com.poly.homeworkout.utils;

import android.app.Activity;

import com.poly.homeworkout.R;
import com.poly.homeworkout.constants.Constants;

public class ViewAnimationUtils {
    public static void animationRightToLeft(Activity activity) {
        activity.overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
    }

    public static void animationLeftToRight(Activity activity) {
        activity.overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
    }

    public static void animationTopToBottom(Activity activity) {
        activity.overridePendingTransition(R.anim.enter_from_top, R.anim.exit_to_top);
    }

    public static void animationBottomToTop(Activity activity) {
        activity.overridePendingTransition(R.anim.enter_from_bottom, R.anim.exit_to_bottom);
    }
    public static void animationStartActivity(Activity activity, int animationType) {
        if (activity != null) {
            switch (animationType) {
                case Constants.AnimationType.LEFT_TO_RIGHT:
                    animationLeftToRight(activity);
                    break;
                case Constants.AnimationType.RIGHT_TO_LEFT:
                    animationRightToLeft(activity);
                    break;
                case Constants.AnimationType.TOP_TO_BOTTOM:
                    animationTopToBottom(activity);
                    break;
                case Constants.AnimationType.BOTTOM_TO_TOP:
                    animationBottomToTop(activity);
                    break;
                default:
                    break;
            }
        }
    }

}
