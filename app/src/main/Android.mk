LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional
LOCAL_PACKAGE_NAME := DU-About
LOCAL_SDK_VERSION := current
LOCAL_CERTIFICATE := platform
LOCAL_PRIVILEGED_MODULE := true

LOCAL_PROGUARD_FLAG_FILES := proguard.flags

LOCAL_SRC_FILES := $(call all-java-files-under, java)
LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/res \
    $(support_library_root_dir)/v7/cardview/res \
    $(support_library_root_dir)/v7/recyclerview/res \
    $(support_library_root_dir)/v7/appcompat/res \
    $(support_library_root_dir)/design/res \
    $(support_library_root_dir)/v7/preference/res \
    $(support_library_root_dir)/v14/preference/res

LOCAL_AAPT_INCLUDE_ALL_RESOURCES := true

LOCAL_AAPT_FLAGS := \
    --auto-add-overlay \
    --extra-packages android.support.v7.appcompat \
    --extra-packages android.support.v7.cardview \
    --extra-packages android.support.v7.recyclerview \
    --extra-packages android.support.design \
    --extra-packages android.support.v7.preference \
    --extra-packages android.support.v14.preference

LOCAL_STATIC_JAVA_LIBRARIES := \
    android-common \
    android-support-v13 \
    android-support-v4 \
    android-support-v7-appcompat \
    android-support-v7-cardview \
    android-support-v7-recyclerview \
    android-support-design \
    android-support-v7-preference \
    android-support-v14-preference \
    convertergson \
    gson \
    retrofit \
    okhttpcustom \
    okio \
    picasso

include $(BUILD_PACKAGE)

include $(CLEAR_VARS)

LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := \
    convertergson:libs/converter-gson-2.1.0.jar \
    gson:libs/gson-2.7.jar \
    retrofit:libs/retrofit-2.1.0.jar \
    okhttpcustom:libs/okhttp-3.3.0.jar \
    okio:libs/okio-1.8.0.jar \
    picasso:libs/picasso-2.5.2.jar

include $(BUILD_MULTI_PREBUILT)
